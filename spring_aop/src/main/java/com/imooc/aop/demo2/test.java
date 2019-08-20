package com.imooc.aop.demo2;

import org.junit.Test;

public class test {

    @Test
    public void demo1() {
        ProductDao productDao = new ProductDao();
        MyCglibProxy myCglibProxy = new MyCglibProxy(productDao);
        ProductDao proxy = (ProductDao)myCglibProxy.createProxy();
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.find();
    }
}
