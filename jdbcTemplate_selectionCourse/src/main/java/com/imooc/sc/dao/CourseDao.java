package com.imooc.sc.dao;

import com.imooc.sc.entity.Course;

import java.util.List;

public interface CourseDao {

    public void insert(Course c);

    public void update(Course c);

    public void delete(int id);

    public Course selectOne(int id);

    public List<Course> selectAll();

}
