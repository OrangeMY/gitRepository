package com.imooc.aspectJ.demo2;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void save() {
        System.out.println("保存用户");
    }

    @Override
    public String update() {
        System.out.println("修改用户");
        return "...hello...";
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
    }

    @Override
    public void findOne() {
        System.out.println("查询一个用户");
        //int i = 1 / 0;
    }

    @Override
    public String findAll() {
        System.out.println("查询所有用户");
        return "返回值的String";
    }
}
