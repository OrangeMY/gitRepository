package com.imooc.sc.dao.Impl;

import com.imooc.sc.dao.StudentDao;
import com.imooc.sc.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("studentDao")
public class StudentDapImpl implements StudentDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public void insert(Student stu) {
        String sql = "insert into student(name, sex, born) values(?, ?, ?)";
        jdbcTemplate.update(sql, stu.getName(), stu.getSex(), stu.getBorn());
    }

    public void update(Student stu) {
        String sql = "update student set name = ?, sex = ?, born = ? where id = ?";
        jdbcTemplate.update(sql, stu.getName(), stu.getSex(), stu.getBorn(), stu.getId());
    }

    public void delete(int id) {
        String sql = "delete from student where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Student selectOne(int id) {
        String sql = "select * from student where id = ?";
        return (Student) jdbcTemplate.queryForObject(sql, new StudentRowMapper(),id);
    }

    public List<Student> selectAll() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    private class StudentRowMapper implements RowMapper {

        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student stu = new Student();
            stu.setName(resultSet.getString("name"));
            stu.setSex(resultSet.getString("sex"));
            stu.setBorn(resultSet.getDate("born"));
            return stu;
        }
    }
}
