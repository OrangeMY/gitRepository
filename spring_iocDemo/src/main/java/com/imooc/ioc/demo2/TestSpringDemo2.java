package com.imooc.ioc.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringDemo2 {

    /***
     * Bean的实例化的三种方式
     */
    @Test
    public void TestDemo1(){
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂获得类的实例
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
    }

    @Test
    public void TestDemo2(){
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂获得类的实例
        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
    }

    @Test
    public void TestDemo3(){
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂获得类的实例
        Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
    }
}
