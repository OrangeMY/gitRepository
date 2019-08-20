package com.imooc.aop.demo5;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void save() {

        System.out.println("新增学生");
    }

    @Override
    public void update() {

        System.out.println("修改学生");
    }

    @Override
    public void find() {

        System.out.println("查询学生");
    }

    @Override
    public void delete() {

        System.out.println("删除学生");
    }
}
