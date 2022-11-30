package com.beans;

import java.io.Serializable;

public class Student implements Serializable {
    private String Sidnumber;
    private String Sname;
    private String Sno;
    private String Scollege;
    private String Smajor;
    private String Sclass;
    private String Scolor;

    public String getSidnumber() {
        return Sidnumber;
    }

    public void setSidnumber(String sidnumber) {
        Sidnumber = sidnumber;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getScollege() {
        return Scollege;
    }

    public void setScollege(String scollege) {
        Scollege = scollege;
    }

    public String getSmajor() {
        return Smajor;
    }

    public void setSmajor(String smajor) {
        Smajor = smajor;
    }

    public String getSclass() {
        return Sclass;
    }

    public void setSclass(String sclass) {
        Sclass = sclass;
    }

    public String getScolor() {
        return Scolor;
    }

    public void setScolor(String scolor) {
        Scolor = scolor;
    }
}
