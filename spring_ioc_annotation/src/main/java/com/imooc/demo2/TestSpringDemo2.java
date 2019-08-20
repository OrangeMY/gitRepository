package com.imooc.demo2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringDemo2 {
    @Test
    public void demo1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean1 bean1 = (Bean1) classPathXmlApplicationContext.getBean("bean1");
        bean1.say();
        classPathXmlApplicationContext.close();
    }

    @Test
    public void demo2(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean2 bean2 = (Bean2) classPathXmlApplicationContext.getBean("bean2");
        Bean2 bean3 = (Bean2) classPathXmlApplicationContext.getBean("bean2");
        System.out.println(bean2==bean3);
    }
}
