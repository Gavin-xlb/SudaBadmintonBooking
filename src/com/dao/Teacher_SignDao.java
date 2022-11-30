package com.dao;


import com.beans.Teacher;
import com.beans.Teacher_Sign;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Teacher_SignDao extends BaseDao {
    public boolean InsertIntoTeacher_Sign(String Tno,String Tname,String Tdate,String Tcode_color,String Tsign_form){
        String sql="INSERT INTO Teacher_Sign "+"VALUES(?,?,?,?,?)";
        Teacher_Sign ts=findTeacherByTnoAndTdate(Tno.trim(),Tdate.trim());
        //System.out.println(ts);
        //System.out.println(ts.getTdate());
        if(ts!=null) return false;
//            deletefromTeacher_SignByTnoAndTdate(Tno,Tdate);
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,Tno);
            pstmt.setString(2,Tname);
            pstmt.setString(3,Tdate);
            pstmt.setString(4,Tcode_color);
            pstmt.setString(5,Tsign_form);
            pstmt.executeUpdate();
            conn.close();
            return true;
        }  catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Teacher_Sign> findTeachersByTno(String tno){
        String sql="SELECT Tno,Tname,Tdate,Tcode_color,Tsign_form FROM Teacher_Sign WHERE Tno=? order by Tdate";
        ArrayList<Teacher_Sign> ts_array=new ArrayList<Teacher_Sign>();
        Teacher_Sign ts=new Teacher_Sign();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,tno.trim());
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                ts.setTno(rst.getString(1));
                ts.setTname(rst.getString(2));
                ts.setTdate(rst.getString(3));
                ts.setTcode_color(rst.getString(4));
                ts.setTsign_form(rst.getString(5));
                ts_array.add(ts);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts_array;
    }
    public ArrayList<Teacher_Sign> findTeachersByTnoAndCollege(String tno,String college){
        String sql="SELECT * FROM Teacher_Sign WHERE Tno IN (SELECT Tno FROM Teacher_Info WHERE Tno=? AND Tcollege=?) order by Tdate";
        ArrayList<Teacher_Sign> ts_array=new ArrayList<Teacher_Sign>();

        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,tno.trim());
            pstmt.setString(2,college.trim());
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Teacher_Sign ts=new Teacher_Sign();
                ts.setTno(rst.getString(1));
                ts.setTname(rst.getString(2));
                ts.setTdate(rst.getString(3));
                ts.setTcode_color(rst.getString(4));
                ts.setTsign_form(rst.getString(5));
                ts_array.add(ts);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts_array;
    }
    public ArrayList<Teacher_Sign> findTeachersByCollege(String college){
        String sql="SELECT * FROM Teacher_Sign WHERE Tno IN (SELECT Tno FROM Teacher_Info WHERE Tcollege=?) order by Tno";
        ArrayList<Teacher_Sign> ts_array=new ArrayList<Teacher_Sign>();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,college.trim());
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Teacher_Sign ts=new Teacher_Sign();
                ts.setTno(rst.getString(1));
                ts.setTname(rst.getString(2));
                ts.setTdate(rst.getString(3));
                ts.setTcode_color(rst.getString(4));
                ts.setTsign_form(rst.getString(5));
                ts_array.add(ts);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts_array;
    }
    public Teacher_Sign findTeacherByTnoAndTdate(String tno,String tdate){
        String sql="SELECT Tno,Tname,Tdate,Tcode_color,Tsign_form FROM Teacher_Sign WHERE Tno=? AND Tdate=?";
        Teacher_Sign ts=new Teacher_Sign();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,tno.trim());
            pstmt.setString(2,tdate.trim());
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                ts.setTno(rst.getString(1));
                ts.setTname(rst.getString(2));
                ts.setTdate(rst.getString(3));
                ts.setTcode_color(rst.getString(4));
                ts.setTsign_form(rst.getString(5));
                conn.close();
            }
            else return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts;
    }

    public boolean deletefromTeacher_SignByTnoAndTdate(String tno,String tdate){
        String sql="DELETE FROM Teacher_Sign WHERE Tno=? AND Tdate=?";
        int temp=0;
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,tno.trim());
            pstmt.setString(2,tdate.trim());
            pstmt.executeUpdate();
            conn.close();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        if(temp==0) return false;
        return  true;
    }
}
