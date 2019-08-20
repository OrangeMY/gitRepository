package com.imooc.os.dao;

import com.imooc.os.entity.Product;

import java.util.List;

public interface ProductDao {

    public void insert(Product product);

    public void update(Product product);

    public void delete(int id);

    public Product select(String id);

    public List<Product> select();

}
