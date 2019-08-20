package com.imooc.aop.demo5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class TestSpringDemo5 {

    @Resource(name = "studentDao")
    private StudentDao studentDao;
    @Resource(name = "customerDao")
    private CustomerDao customerDao;

    @Test
    public void demo1(){
        studentDao.update();
        studentDao.save();
        studentDao.find();
        studentDao.delete();

        customerDao.delete();
        customerDao.find();
        customerDao.save();
        customerDao.update();
    }
}
