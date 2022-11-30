package com.beans;

import java.io.Serializable;

public class Teacher_Sign implements Serializable {
    String Tno;
    String Tname;
    String Tdate;
    String Tcode_color;
    String Tsign_form;

    public String getTno() {
        return Tno;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTdate() {
        return Tdate;
    }

    public void setTdate(String tdate) {
        Tdate = tdate;
    }

    public String getTcode_color() {
        return Tcode_color;
    }

    public void setTcode_color(String tcode_color) {
        Tcode_color = tcode_color;
    }

    public String getTsign_form() {
        return Tsign_form;
    }

    public void setTsign_form(String tsign_form) {
        Tsign_form = tsign_form;
    }
}
