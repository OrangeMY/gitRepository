package com.imooc.aop.demo1;

import org.junit.Test;

public class test {
    // 传统方法
    @Test
    public void demo1() {
        UserDao userDao = new UserDaoImpl();

        userDao.save();
        userDao.update();
        userDao.delete();
        userDao.find();
    }

    // 使用了JDK动态代理
    @Test
    public void demo2() {
        UserDao userDao = new UserDaoImpl();
        UserDao proxy = (UserDao)new MyJDKProxy(userDao).createProxy();
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.find();
    }
}
