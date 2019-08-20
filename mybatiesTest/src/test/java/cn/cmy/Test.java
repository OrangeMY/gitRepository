package cn.cmy;

import cn.cmy.dao.StudentDao;
import cn.cmy.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsReader("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<Student> list = sqlSession.selectList("cn.cmy.dao.StudentDao.selectAll");
//        System.out.println(list);

        // 测试插入
        Student student = new Student();
        student.setsId(12);
        student.setsName("程明杨");
        student.setsBirth(new Date());
        student.setsSex("男");
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        studentDao.insert(student);
        sqlSession.commit();
    }
}
