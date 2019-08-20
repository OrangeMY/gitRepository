package com.imooc.dao;

import com.imooc.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CourseDaoImpl {

    private Map<Integer, Course> map = new HashMap();

    public void insert(Course course) {
        map.put(course.getId(), course);
    }

    public Collection<Course> selectAll() {
        return map.values();
    }
}
