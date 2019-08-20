package com.imooc.os.service.Impl5;

import com.imooc.os.dao.OrderDao;
import com.imooc.os.dao.ProductDao;
import com.imooc.os.entity.Order;
import com.imooc.os.entity.Product;
import com.imooc.os.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import javax.annotation.Resource;
import java.util.Date;

// 第一种方式实现 spring事务管理，基于底层API的方式实现
// 相关概念可见spring事务管理 -> 基本概念 那一节的视频 介绍
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource(name = "orderDao")
    private OrderDao orderDao;

    @Resource(name = "productDao")
    private ProductDao productDao;

    public void addOrder(Order order) {
        order.setCreateTime(new Date());
        order.setStatus("待付款");
        orderDao.insert(order);
        Product product = productDao.select(order.getProductId());
        product.setStock(product.getStock() - order.getNumber());
        productDao.update(product);
    }
}
