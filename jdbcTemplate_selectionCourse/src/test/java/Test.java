import com.imooc.sc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {

    private JdbcTemplate jdbcTemplate;
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
    }

    public void testExecute() {
        String sql = "create table user1(id int, name varchar(20))";
        jdbcTemplate.execute(sql);
    }

    public void testUpdate() {
        String sql = "insert into student(name, sex) values(?, ?)";
        jdbcTemplate.update(sql, new Object[]{"张飞", "男"});
    }

    public void testBatchUpdate() {
        String sql = "insert into selection(student, course) values(?, ?)";
        List<Object[]> list = new ArrayList();
        list.add(new Object[]{1, 1001});
        list.add(new Object[]{1, 1003});
        jdbcTemplate.batchUpdate(sql, list);
    }

    public void testQueryForObject() {
        String sql = "select count(*) from student";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    public void testQueryForList() {
        String sql = "select name from student";
        List<String> list = jdbcTemplate.queryForList(sql, String.class);
        System.out.println(list);
    }

    // 这里的Map对象中的值，String表示列名，Object表示该列对应的值
    public void testQueryForMap() {
        String sql = "select * from student where id = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 1);
        System.out.println(map);
    }

    @org.junit.Test
    public void testQueryForMap2() {
        String sql = "select * from course";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
    }

    public void testQuery5() {
        String sql = "select * from student where id = ?";
        Student stu = (Student) jdbcTemplate.queryForObject(sql, new StudentRowMapper(), 1);
        System.out.println(stu);
    }

    @org.junit.Test
    public void testQuery6() {
        String sql = "select * from student";
        List<Student> list = jdbcTemplate.query(sql, new StudentRowMapper());
        System.out.println(list);
    }

    // 为了将查询结果封装成实体对象，则要进行映射
    // 这里的RowMapper的作用：例如：对于数据库中的student表，一行记录就是一个学生，而java中一个Student类对象
    // 表示一个学生，那么RowMapper用于将这两者进行映射

    // 介于testQuery6中重复使用RowMapper类，导致程序可读性不好，创建一个自己的StudentRowMapper类
    // 这里的i指的是行的索引, resultSet当然指的就是查询到的数据
    private class StudentRowMapper implements RowMapper {
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student stu = new Student();
            stu.setId(resultSet.getInt("id"));
            stu.setName(resultSet.getString("name"));
            stu.setSex(resultSet.getString("sex"));
            stu.setBorn(resultSet.getDate("born"));
            return stu;
        }
    }
}


