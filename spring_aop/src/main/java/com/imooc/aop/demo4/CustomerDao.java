package com.imooc.aop.demo4;

public class CustomerDao {
    public void find(){
        System.out.println("查询客户");
    }

    public void save(){
        System.out.println("保存用户");
    }

    public void update(){
        System.out.println("更新用户");
    }

    public void delete(){
        System.out.println("删除用户");
    }
}
