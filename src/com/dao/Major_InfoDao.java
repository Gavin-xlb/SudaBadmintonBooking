package com.dao;

import com.beans.Major_Info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Major_InfoDao extends BaseDao {
    public ArrayList<Major_Info> findMajorsByCollege(String college){
        ArrayList<Major_Info> array_m=new ArrayList<Major_Info>();
        String sql="SELECT * FROM Major_Info WHERE major_college=?";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,college.trim());
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Major_Info m=new Major_Info();
                m.setMajor_college(rst.getString(1));
                m.setMajor_name(rst.getString(2));
                m.setMajor_id(rst.getString(3));
                m.setMajor_pc(rst.getString(4));
                array_m.add(m);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array_m;
    }
    public ArrayList<Major_Info> findAllMajors(){
        ArrayList<Major_Info> array_m=new ArrayList<Major_Info>();
        String sql="SELECT * FROM Major_Info";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Major_Info m=new Major_Info();
                m.setMajor_college(rst.getString(1));
                m.setMajor_name(rst.getString(2));
                m.setMajor_id(rst.getString(3));
                m.setMajor_pc(rst.getString(4));
                array_m.add(m);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array_m;
    }


}
