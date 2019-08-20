package com.imooc.os.service.Impl6;

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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource(name = "orderDao")
    private OrderDao orderDao;

    @Resource(name = "productDao")
    private ProductDao productDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addOrder(Order order) {
        order.setCreateTime(new Date());
        order.setStatus("待付款");
        orderDao.insert(order);
        Product product = productDao.select(order.getProductId());
        product.setStock(product.getStock() - order.getNumber());
        productDao.update(product);
    }
}
