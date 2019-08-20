package cn.cmy.entity;

import java.util.Date;

public class Student {

    private String sId;
    private String sName;
    private Date sBirth;
    private String sSex;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Date getsBirth() {
        return sBirth;
    }

    public void setsBirth(Date sBirth) {
        this.sBirth = sBirth;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sBirth=" + sBirth +
                ", sSex='" + sSex + '\'' +
                '}';
    }
}
