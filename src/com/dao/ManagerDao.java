package com.dao;

import com.beans.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManagerDao extends BaseDao {
    public ArrayList<Manager> findManagersByRole(String role) {
        ArrayList<Manager> sm_array=new ArrayList<Manager>();
        String sql="SELECT * FROM Manager_Password_Info WHERE Wrole=?";
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,role);
            ResultSet rst=pstmt.executeQuery();
            //该角色在表中无数据
            //if(rst.next()==false) return null;
            while(rst.next()){
                Manager sm=new Manager();
                sm.setWno(rst.getString(1).trim());//System.out.println(sm.getWno());
                sm.setWrole(rst.getString(2).trim());
                sm.setWpassword(rst.getString(3).trim());
                sm_array.add(sm);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sm_array;

    }

    public boolean updateManagerPasswordByWno(String wno,String newpassword){
        String sql="UPDATE Manager_Password_Info SET Wpassword=? WHERE Wno=?";
        int temp=0; //存储受影响行数 0表示失败
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,newpassword);
            pstmt.setString(2,wno);
            temp=pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(temp==0) return false;
        return true;
    }


}
