package com.dao;

import com.beans.College_Info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class College_InfoDao extends BaseDao {
    public ArrayList<College_Info> findAllColleges(){
        String sql="SELECT * FROM College_Info";
        ArrayList<College_Info> array_c=new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                College_Info ci=new College_Info();
                ci.setCollege_name(rst.getString(1));
                ci.setCollege_id(rst.getString(2));
                ci.setCollege_pc(rst.getString(3));
                array_c.add(ci);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array_c;
    }
}
