package com.imooc.demo1;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao {

    public void save(){
        System.out.println("Dao中保存用户");
    }
}
