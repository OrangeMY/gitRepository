package com.imooc.os.service;

import com.imooc.os.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-service6.xml")
public class OrderTest {

    @Resource(name = "orderService")
    private OrderService orderService;

    @Test
    public void testAddOrder() {
        Order order = new Order("100013", "100003", 2, 5000, "程明杨",
                "13576228786", "西安市");
        orderService.addOrder(order);
    }
}


