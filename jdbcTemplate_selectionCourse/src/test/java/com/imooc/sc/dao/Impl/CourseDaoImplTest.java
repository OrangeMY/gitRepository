package com.imooc.sc.dao.Impl;

import com.imooc.sc.dao.CourseDao;
import com.imooc.sc.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring.xml")
public class CourseDaoImplTest {

    @Resource(name = "courseDao")
    private CourseDao courseDao;

    @Test
    public void insert() {
        Course c = new Course();
        c.setId(5);
        c.setName("数据结构");
        c.setScore(4);
        courseDao.insert(c);
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