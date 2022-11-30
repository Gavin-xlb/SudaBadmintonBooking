package com.beans;

import java.io.Serializable;

public class College_Info implements Serializable {
    private String college_name;
    private String college_id;
    private String college_pc;

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getCollege_id() {
        return college_id;
    }

    public void setCollege_id(String college_id) {
        this.college_id = college_id;
    }

    public String getCollege_pc() {
        return college_pc;
    }

    public void setCollege_pc(String college_pc) {
        this.college_pc = college_pc;
    }
}
