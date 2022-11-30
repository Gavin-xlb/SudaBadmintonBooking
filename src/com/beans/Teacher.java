package com.beans;

import java.io.Serializable;

public class Teacher implements Serializable{
    private String Tidnumber;
    private String Tname;
    private String Tno;
    private String Tcollege;
    private String Trole;
    private String Tcolor;

    public String getTidnumber() {
        return Tidnumber;
    }

    public void setTidnumber(String tidnumber) {
        Tidnumber = tidnumber;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTno() {
        return Tno;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public String getTcollege() {
        return Tcollege;
    }

    public void setTcollege(String tcollege) {
        Tcollege = tcollege;
    }

    public String getTrole() {
        return Trole;
    }

    public void setTrole(String trole) {
        Trole = trole;
    }

    public String getTcolor() {
        return Tcolor;
    }

    public void setTcolor(String tcolor) {
        Tcolor = tcolor;
    }
}
