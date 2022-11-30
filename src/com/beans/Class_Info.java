package com.beans;

import java.io.Serializable;

public class Class_Info implements Serializable {
    private String class_college;
    private String class_major;
    private String class_name;
    private String class_pc;

    public String getClass_college() {
        return class_college;
    }

    public void setClass_college(String class_college) {
        this.class_college = class_college;
    }

    public String getClass_major() {
        return class_major;
    }

    public void setClass_major(String class_major) {
        this.class_major = class_major;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_pc() {
        return class_pc;
    }

    public void setClass_pc(String class_pc) {
        this.class_pc = class_pc;
    }
}
