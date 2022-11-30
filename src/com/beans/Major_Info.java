package com.beans;

import java.io.Serializable;

public class Major_Info implements Serializable {
    private String major_college;
    private String major_name;
    private String major_id;
    private String major_pc;

    public String getMajor_college() {
        return major_college;
    }

    public void setMajor_college(String major_college) {
        this.major_college = major_college;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public String getMajor_pc() {
        return major_pc;
    }

    public void setMajor_pc(String major_pc) {
        this.major_pc = major_pc;
    }
}
