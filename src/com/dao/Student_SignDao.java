package com.dao;

import com.beans.Student;
import com.beans.Student_Sign;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Student_SignDao extends BaseDao {
    public boolean InsertIntoStudent_Sign(String Sno,String Sname,String Sdate,String Scode_color,String Ssign_form){
        String sql="INSERT INTO Student_Sign "+"VALUES(?,?,?,?,?)";
        Student_Sign ss=findStudentBySnoAndSdate(Sno.trim(),Sdate.trim());
        if(ss!=null) return false;
//            deletefromStudent_SignBySnoAndSdate(Sno,Sdate);
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,Sno);
            pstmt.setString(2,Sname);
            pstmt.setString(3,Sdate);
            pstmt.setString(4,Scode_color);
            pstmt.setString(5,Ssign_form);
            pstmt.executeUpdate();
            conn.close();
            return true;
        }  catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Student_Sign> findStudentsBySno(String sno){
        String sql="SELECT Sno,Sname,Sdate,Scode_color,Ssign_form FROM Student_Sign WHERE Sno=? order by Sdate";
        ArrayList<Student_Sign> ss_array=new ArrayList<Student_Sign>();

        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,sno.trim());
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Student_Sign ss=new Student_Sign();
                ss.setSno(rst.getString(1));
                ss.setSname(rst.getString(2));
                ss.setSdate(rst.getString(3));
                ss.setScode_color(rst.getString(4));
                ss.setSsign_form(rst.getString(5));
                ss_array.add(ss);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ss_array;
    }
    public Student_Sign findStudentBySnoAndSdate(String sno,String sdate){
        String sql="SELECT Sno,Sname,Sdate,Scode_color,Ssign_form FROM Student_Sign WHERE Sno=? AND Sdate=?";
        Student_Sign ss=new Student_Sign();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,sno.trim());
            pstmt.setString(2,sdate.trim());
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                ss.setSno(rst.getString(1));
                ss.setSname(rst.getString(2));
                ss.setSdate(rst.getString(3));
                ss.setScode_color(rst.getString(4));
                ss.setSsign_form(rst.getString(5));
                conn.close();
            }
            else return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ss;
    }

    public boolean deletefromStudent_SignBySnoAndSdate(String sno,String sdate){
        String sql="DELETE FROM Student_Sign WHERE Sno=? AND Sdate=?";
        int temp=0; //存储受影响行数 0表示失败
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,sno.trim());
            pstmt.setString(2,sdate.trim());
            temp=pstmt.executeUpdate();
            conn.close();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        if(temp==0) return false;
        return true;
    }
    public ArrayList<Student_Sign> findStudentsByCollege(String college){
        String sql="SELECT * FROM Student_Sign WHERE Sno IN (SELECT Sno FROM Student_Info WHERE Scollege=?)";
        ArrayList<Student_Sign> array_ss=new ArrayList<Student_Sign>();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,college.trim());
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Student_Sign ss=new Student_Sign();
                ss.setSno(rst.getString(1));
                ss.setSname(rst.getString(2));
                ss.setSdate(rst.getString(3));
                ss.setScode_color(rst.getString(4));
                ss.setSsign_form(rst.getString(5));
                array_ss.add(ss);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array_ss;
    }
    public ArrayList<Student_Sign> findStudentsByCollegeAndMajor(String college,String major){
        String sql="SELECT * FROM Student_Sign WHERE Sno IN (SELECT Sno FROM Student_Info WHERE Scollege=? AND Smajor=?)";
        ArrayList<Student_Sign> array_ss=new ArrayList<Student_Sign>();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,college.trim());
            pstmt.setString(2,major.trim());
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Student_Sign ss=new Student_Sign();
                ss.setSno(rst.getString(1));
                ss.setSname(rst.getString(2));
                ss.setSdate(rst.getString(3));
                ss.setScode_color(rst.getString(4));
                ss.setSsign_form(rst.getString(5));
                array_ss.add(ss);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array_ss;
    }
    public ArrayList<Student_Sign> findStudentsByCollegeAndMajorAndClass(String college,String major,String c){
        String sql="SELECT * FROM Student_Sign WHERE Sno IN (SELECT Sno FROM Student_Info WHERE Scollege=? AND Smajor=? AND Sclass=?)";
        ArrayList<Student_Sign> array_ss=new ArrayList<Student_Sign>();
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,college.trim());
            pstmt.setString(2,major.trim());
            pstmt.setString(3,c.trim());
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Student_Sign ss=new Student_Sign();
                ss.setSno(rst.getString(1));
                ss.setSname(rst.getString(2));
                ss.setSdate(rst.getString(3));
                ss.setScode_color(rst.getString(4));
                ss.setSsign_form(rst.getString(5));
                array_ss.add(ss);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array_ss;
    }

}
