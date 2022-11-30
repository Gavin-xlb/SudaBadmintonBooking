package com.dao;

import com.beans.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDao extends BaseDao {
    public Student findBySno(String Sno){
        String sql="SELECT Sidnumber,Sname,Sno,Scollege,Smajor,Sclass,Scolor "+"FROM Student_Info WHERE Sno=?";
        Student stu=new Student();//System.out.println(Sno);
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,Sno);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                stu.setSidnumber(rst.getString(1).trim());
                stu.setSname(rst.getString(2).trim());
                stu.setSno(rst.getString(3).trim());
                stu.setScollege(rst.getString(4).trim());
                stu.setSmajor(rst.getString(5).trim());
                stu.setSclass(rst.getString(6).trim());//System.out.println(stu.getSno());
                stu.setScolor(rst.getString(7).trim());
                conn.close();
                return stu;
            }
            else return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Student findBySnoAndCollege(String Sno,String college){
        String sql="SELECT Sidnumber,Sname,Sno,Scollege,Smajor,Sclass,Scolor "+"FROM Student_Info WHERE Sno=? AND Scollege=?";
        Student stu=new Student();//System.out.println(Sno);
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,Sno);
            pstmt.setString(2,college);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                stu.setSidnumber(rst.getString(1).trim());
                stu.setSname(rst.getString(2).trim());
                stu.setSno(rst.getString(3).trim());
                stu.setScollege(rst.getString(4).trim());
                stu.setSmajor(rst.getString(5).trim());
                stu.setSclass(rst.getString(6).trim());//System.out.println(stu.getSno());
                stu.setScolor(rst.getString(7).trim());
                conn.close();
                return stu;
            }
            else return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Student> findStudentsByCollege(String college){
        String sql="SELECT Sidnumber,Sname,Sno,Scollege,Smajor,Sclass,Scolor "+"FROM Student_Info WHERE Scollege=?";
        ArrayList<Student> array_stu=new ArrayList<Student>();
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,college);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Student stu=new Student();
                stu.setSidnumber(rst.getString(1).trim());
                stu.setSname(rst.getString(2).trim());
                stu.setSno(rst.getString(3).trim());
                stu.setScollege(rst.getString(4).trim());
                stu.setSmajor(rst.getString(5).trim());
                stu.setSclass(rst.getString(6).trim());//System.out.println(stu.getSno());
                stu.setScolor(rst.getString(7).trim());
                array_stu.add(stu);
            }conn.close();
            return array_stu;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Student> findAllStudents(){
        String sql="SELECT * FROM Student_Info";
        ArrayList<Student> array_stu=new ArrayList<Student>();
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Student stu=new Student();
                stu.setSidnumber(rst.getString(1).trim());
                stu.setSname(rst.getString(2).trim());
                stu.setSno(rst.getString(3).trim());
                stu.setScollege(rst.getString(4).trim());
                stu.setSmajor(rst.getString(5).trim());
                stu.setSclass(rst.getString(6).trim());//System.out.println(stu.getSno());
                stu.setScolor(rst.getString(7).trim());
                array_stu.add(stu);
            }conn.close();
            return array_stu;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Student> findStudentsByMajorAndCollege(String major,String college){
        String sql="SELECT Sidnumber,Sname,Sno,Scollege,Smajor,Sclass,Scolor "+"FROM Student_Info WHERE Smajor=? AND Scollege=?";
        ArrayList<Student> array_stu=new ArrayList<Student>();
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,major);
            pstmt.setString(2,college);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Student stu=new Student();
                stu.setSidnumber(rst.getString(1).trim());
                stu.setSname(rst.getString(2).trim());
                stu.setSno(rst.getString(3).trim());
                stu.setScollege(rst.getString(4).trim());
                stu.setSmajor(rst.getString(5).trim());
                stu.setSclass(rst.getString(6).trim());//System.out.println(stu.getSno());
                stu.setScolor(rst.getString(7).trim());
                array_stu.add(stu);
            }conn.close();
            return array_stu;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Student> findStudentsByMajor(String major){
        String sql="SELECT * FROM Student_Info WHERE Smajor=?";
        ArrayList<Student> array_stu=new ArrayList<Student>();
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,major);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Student stu=new Student();
                stu.setSidnumber(rst.getString(1).trim());
                stu.setSname(rst.getString(2).trim());
                stu.setSno(rst.getString(3).trim());
                stu.setScollege(rst.getString(4).trim());
                stu.setSmajor(rst.getString(5).trim());
                stu.setSclass(rst.getString(6).trim());//System.out.println(stu.getSno());
                stu.setScolor(rst.getString(7).trim());
                array_stu.add(stu);
            }conn.close();
            return array_stu;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Student> findStudentsByClassAndMajorAndCollege(String c,String m,String col){
        String sql="SELECT Sidnumber,Sname,Sno,Scollege,Smajor,Sclass,Scolor "+"FROM Student_Info WHERE Sclass=? AND Smajor=? AND Scollege=?";
        ArrayList<Student> array_stu=new ArrayList<Student>();
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,c);
            pstmt.setString(2,m);
            pstmt.setString(3,col);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Student stu=new Student();
                stu.setSidnumber(rst.getString(1).trim());
                stu.setSname(rst.getString(2).trim());
                stu.setSno(rst.getString(3).trim());
                stu.setScollege(rst.getString(4).trim());
                stu.setSmajor(rst.getString(5).trim());
                stu.setSclass(rst.getString(6).trim());//System.out.println(stu.getSno());
                stu.setScolor(rst.getString(7).trim());
                array_stu.add(stu);
            }conn.close();
            return array_stu;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateScolor(String sno,String color){
        String sql="UPDATE Student_Info SET Scolor=? WHERE Sno=?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,color);
            pstmt.setString(2,sno);
            pstmt.executeUpdate();
            conn.close();
            return true;
        }  catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public  boolean insertStudent(Student stu){
        String sidnum=stu.getSidnumber().trim();
        String sname=stu.getSname().trim();
        String sno=stu.getSno().trim();
        String scollege=stu.getScollege().trim();
        String smajor=stu.getSmajor().trim();
        String sclass=stu.getSclass().trim();
        String scolor=stu.getScolor().trim();
        String sql="INSERT INTO Student_Info VALUES(?,?,?,?,?,?,?)";
        int temp=0;
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,sidnum);
            pstmt.setString(2,sname);
            pstmt.setString(3,sno);
            pstmt.setString(4,scollege);
            pstmt.setString(5,smajor);
            pstmt.setString(6,sclass);
            pstmt.setString(7,scolor);
            temp=pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(temp==0) return  false;
        return true;
    }
}
