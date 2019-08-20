package com.imooc.os.service.Impl1;

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

    @Autowired
    private TransactionDefinition transactionDefinition;

    @Autowired
    private DataSourceTransactionManager transactionManager;

    // PlatformTransactionManager 用于生成一个事务，同时传入一个TransactionDefinition参数，用于表示，生成一个什么样的
    // 事务，创建出来的事务就是TransactionStatus类型，即可以认为：TransactionDefinition表示如何定义事务，
    // TransactionStatus表示创建好的正在运行的事务
    // PlatfromTransactionManager同时拥有一些实现类，如：
    // DateSourceTransactionManager： 若持久层使用 jdbcTemplate、mybaties等等则选择该管理器
    // HibernateTransactionManager： 若持久层使用的是Hibernate，则使用该管理器
    // JpaTransactionManager： 若持久层用的是jpa模式，则使用该管理器
    // 事务的传播行为的概念理解：见test包中Propagation类
    public void addOrder(Order order) {
        order.setCreateTime(new Date());
        order.setStatus("待付款");
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
        try {
            orderDao.insert(order);
            Product product = productDao.select(order.getProductId());
            product.setStock(product.getStock() - order.getNumber());
            productDao.update(product);

            transactionManager.commit(transactionStatus);
        } catch(Exception e) {
            e.printStackTrace();
            transactionManager.rollback(transactionStatus);
        }
    }
}
