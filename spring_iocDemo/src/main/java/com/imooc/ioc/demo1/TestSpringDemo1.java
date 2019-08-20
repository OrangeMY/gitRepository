package com.imooc.ioc.demo1;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringDemo1 {

    @Test
    public void demo1(){
        //UserService userService = new UserServiceImpl();
        //设置属性
        UserServiceImpl userService = new UserServiceImpl();
        userService.setName("张三");
        userService.sayHello();
    }

    @Test
    /***
     * Spring的方式实现
     */
    public void demo2(){
        //创建Spring工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂获得类
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello();
    }
}
