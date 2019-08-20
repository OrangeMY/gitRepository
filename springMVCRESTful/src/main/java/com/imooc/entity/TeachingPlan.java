package com.imooc.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TeachingPlan {

    private int id;
    // 用于表示于Teacher的关联
    private int tId;
    private String name;
    private String grade;
    private String major;
    // 教师与entity中的Teacher相关联
    private Teacher teacher;
    private Date appointTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int gettId() {
        return tId;
    }

    public void settId(String tId) {
        int id = Integer.parseInt(tId);
        this.tId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }
}
