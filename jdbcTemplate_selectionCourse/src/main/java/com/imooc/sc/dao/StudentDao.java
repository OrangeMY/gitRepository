package com.imooc.sc.dao;

import com.imooc.sc.entity.Student;

import java.util.List;

public interface StudentDao {

    public void insert(Student stu);

    public void update(Student stu);

    public void delete(int id);

    public Student selectOne(int id);

    public List<Student> selectAll();

}
