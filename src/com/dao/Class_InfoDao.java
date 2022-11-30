package com.dao;

import com.beans.Class_Info;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Class_InfoDao extends BaseDao {
    public ArrayList<Class_Info> findClassesByCollege(String college){
        ArrayList<Class_Info> array_c=new ArrayList<Class_Info>();
        String sql="SELECT * FROM Class_Info WHERE class_college=?";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,college.trim());
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Class_Info m=new Class_Info();
                m.setClass_college(rst.getString(1));
                m.setClass_major(rst.getString(2));
                m.setClass_name(rst.getString(3));
                m.setClass_pc(rst.getString(4));
                array_c.add(m);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array_c;
    }
    public ArrayList<Class_Info> findAllClasses(){
        ArrayList<Class_Info> array_c=new ArrayList<Class_Info>();
        String sql="SELECT * FROM Class_Info";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Class_Info m=new Class_Info();
                m.setClass_college(rst.getString(1));
                m.setClass_major(rst.getString(2));
                m.setClass_name(rst.getString(3));
                m.setClass_pc(rst.getString(4));
                array_c.add(m);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array_c;
    }
}
