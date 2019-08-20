package com.imooc.entity;

import java.util.HashSet;
import java.util.Set;

public class CourseSet {

    private Set<Course> courses = new HashSet();

    // Set集合不同于List和Map，需要初始化，必须添加两个对象，必须添加，否则无法完成绑定
    public CourseSet() {
        courses.add(new Course());
        courses.add(new Course());
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
