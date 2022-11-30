package com.beans;

import java.io.Serializable;

public class Manager implements Serializable {
    private String Wno;
    private String Wrole;
    private String Wpassword;

    public String getWno() {
        return Wno;
    }

    public void setWno(String wno) {
        Wno = wno;
    }

    public String getWrole() {
        return Wrole;
    }

    public void setWrole(String wrole) {
        Wrole = wrole;
    }

    public String getWpassword() {
        return Wpassword;
    }

    public void setWpassword(String wpassword) {
        Wpassword = wpassword;
    }
}
