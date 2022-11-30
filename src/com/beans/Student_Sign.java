package com.beans;

import java.io.Serializable;

public class Student_Sign implements Serializable {
    String Sno;
    String Sname;
    String Sdate;
    String Scode_color;
    String Ssign_form;

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSdate() {
        return Sdate;
    }

    public void setSdate(String sdate) {
        Sdate = sdate;
    }

    public String getScode_color() {
        return Scode_color;
    }

    public void setScode_color(String scode_color) {
        Scode_color = scode_color;
    }

    public String getSsign_form() {
        return Ssign_form;
    }

    public void setSsign_form(String ssign_form) {
        Ssign_form = ssign_form;
    }
}
