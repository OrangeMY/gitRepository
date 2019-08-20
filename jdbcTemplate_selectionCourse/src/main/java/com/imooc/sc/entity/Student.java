package com.imooc.sc.entity;

import java.util.Date;

public class Student {
    private int id;

    private String name;

    private String sex;

    private Date born;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Date getBorn() {
        return born;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", born=" + born +
                '}';
    }
}
