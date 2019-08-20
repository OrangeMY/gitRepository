package com.imooc.aspectJ.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext3.xml")
public class TestDemo2 {

    @Resource(name = "customerDao")
    private CustomerDao customerDao;

    @Test
    public void testDemo2(){
        customerDao.save();
        customerDao.delete();
        customerDao.update();
        customerDao.findOne();
        customerDao.findAll();
    }
}
