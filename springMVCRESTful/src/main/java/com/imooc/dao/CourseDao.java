package com.imooc.dao;

import com.imooc.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CourseDao {

    private Map<Integer, Course> map = new HashMap();

    public void insert(Course course) {
        map.put(course.getId(), course);
    }

    public void delete(int id) {
        map.remove(id);
    }

    public void update(Course course) {
        map.put(course.getId(), course);
    }

    public Course selectById(int id) {
        return map.get(id);
    }

    public Collection<Course> selectAll() {
        return map.values();
    }

}
