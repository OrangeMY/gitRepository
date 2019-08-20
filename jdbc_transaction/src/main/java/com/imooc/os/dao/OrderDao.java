package com.imooc.os.dao;

import com.imooc.os.entity.Order;

import java.util.List;

public interface OrderDao {

    public void insert(Order o);

    public void update(Order o);

    public void delete(String id);

    public Order select(String id);

    public List<Order> select();

}
