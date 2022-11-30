package com.dao;

import com.beans.Manager_Password_Info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Manager_Password_InfoDao extends BaseDao {
    public Manager_Password_Info findManagerByWnoAndWrole(String wno,String wrole){
        String sql="SELECT * FROM Manager_Password_Info WHERE Wno=? AND Wrole=?";
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,wno);
            pstmt.setString(2,wrole);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                Manager_Password_Info mpi=new Manager_Password_Info();
                mpi.setWno(rst.getString(1).trim());
                mpi.setWrole(rst.getString(2).trim());
                mpi.setWpassword(rst.getString(3).trim());
                conn.close();
                return mpi;
            }
            else return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    public Manager_Password_Info findManagerByWnoAndWrole(String wno,String wrole1,String wrole2){
        String sql="SELECT * FROM Manager_Password_Info WHERE Wno=? AND (Wrole=? OR Wrole=?) ";
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,wno);
            pstmt.setString(2,wrole1);
            pstmt.setString(3,wrole2);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                Manager_Password_Info mpi=new Manager_Password_Info();
                mpi.setWno(rst.getString(1).trim());
                mpi.setWrole(rst.getString(2).trim());
                mpi.setWpassword(rst.getString(3).trim());
                conn.close();
                return mpi;
            }
            else return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    public boolean updatepswByWno(String psw,String wno){
        String sql="UPDATE Manager_Password_Info SET Wpassword=? WHERE Wno=?";
        int temp=0; //存放影响的行数;
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,psw);
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
