package cn.cmy.dao;

import cn.cmy.entity.Student;

import java.util.List;

public interface StudentDao {

    public void insert(Student student);
    public void update(Student student);
    public void delete(String id);
    public Student selectById(String id);
    public List<Student> selectAll();
}
