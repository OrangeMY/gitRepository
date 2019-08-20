package com.imooc.sc.entity;

import java.util.Date;

public class Selection {

    private int student;

    private int course;

    private Date selectionTime;

    private int score;

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Date getSelectionTime() {
        return selectionTime;
    }

    public void setSelectionTime(Date selectionTime) {
        this.selectionTime = selectionTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
