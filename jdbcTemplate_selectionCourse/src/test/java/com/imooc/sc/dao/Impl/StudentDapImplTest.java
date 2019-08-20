package com.imooc.sc.dao.Impl;

import com.imooc.sc.dao.StudentDao;
import com.imooc.sc.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring.xml")
public class StudentDapImplTest {

    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Test
    public void insert() {
        Student stu = new Student();
        stu.setName("程明杨");
        stu.setSex("男");
        stu.setBorn(new Date());
        studentDao.insert(stu);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void selectOne() {
    }

    @Test
    public void selectAll() {
    }
}