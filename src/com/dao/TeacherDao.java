package com.dao;


import com.beans.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TeacherDao extends BaseDao {
    public Teacher findByTno(String Tno){
        String sql="SELECT Tidnumber,Tname,Tno,Tcollege,Trole,Tcolor "+"FROM Teacher_Info WHERE Tno=?";
        Teacher teacher=new Teacher();
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,Tno);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                teacher.setTidnumber(rst.getString(1).trim());
                teacher.setTname(rst.getString(2).trim());
                teacher.setTno(rst.getString(3).trim());
                teacher.setTcollege(rst.getString(4).trim());
                teacher.setTrole(rst.getString(5).trim());
                teacher.setTcolor(rst.getString(6).trim());
                conn.close();
                return teacher;
            }
            else return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Teacher findByTnoAndCollege(String Tno,String college){
        String sql="SELECT Tidnumber,Tname,Tno,Tcollege,Trole,Tcolor "+"FROM Teacher_Info WHERE Tno=? AND Tcollege=?";
        Teacher teacher=new Teacher();
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,Tno);
            pstmt.setString(2,college);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                teacher.setTidnumber(rst.getString(1).trim());
                teacher.setTname(rst.getString(2).trim());
                teacher.setTno(rst.getString(3).trim());
                teacher.setTcollege(rst.getString(4).trim());
                teacher.setTrole(rst.getString(5).trim());
                teacher.setTcolor(rst.getString(6).trim());
                conn.close();
                return teacher;
            }
            else return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateTcolor(String tno,String color){
        String sql="UPDATE Teacher_Info SET Tcolor=? WHERE Tno=?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,color);
            pstmt.setString(2,tno);
            pstmt.executeUpdate();
            conn.close();
            return true;
        }  catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertTeacher(Teacher tea){
        String tidnum=tea.getTidnumber().trim();
        String tname=tea.getTname().trim();
        String tno=tea.getTno().trim();
        String tcollege=tea.getTcollege().trim();
        String trole=tea.getTrole().trim();
        String tcolor=tea.getTcolor().trim();
        String sql="INSERT INTO Teacher_Info VALUES(?,?,?,?,?,?)";
        int temp=0;
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,tidnum);
            pstmt.setString(2,tname);
            pstmt.setString(3,tno);
            pstmt.setString(4,tcollege);
            pstmt.setString(5,trole);
            pstmt.setString(6,tcolor);
            temp=pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(temp==0) return  false;
        return true;
    }
    public ArrayList<Teacher> findTeachersByCollege(String college){
        String sql="SELECT Tidnumber,Tname,Tno,Tcollege,Trole,Tcolor "+"FROM Teacher_Info WHERE Tcollege=? order by Tno";
        ArrayList<Teacher> tea_array=new ArrayList<Teacher>();
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,college);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Teacher teacher=new Teacher();
                teacher.setTidnumber(rst.getString(1).trim());
                teacher.setTname(rst.getString(2).trim());
                teacher.setTno(rst.getString(3).trim());
                teacher.setTcollege(rst.getString(4).trim());
                teacher.setTrole(rst.getString(5).trim());
                teacher.setTcolor(rst.getString(6).trim());
                tea_array.add(teacher);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tea_array;
    }
    public ArrayList<Teacher> findAllTeachers(){
        String sql="SELECT * FROM Teacher_Info";
        ArrayList<Teacher> array_teacher=new ArrayList<>();
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Teacher teacher=new Teacher();
                teacher.setTidnumber(rst.getString(1).trim());
                teacher.setTname(rst.getString(2).trim());
                teacher.setTno(rst.getString(3).trim());
                teacher.setTcollege(rst.getString(4).trim());
                teacher.setTrole(rst.getString(5).trim());
                teacher.setTcolor(rst.getString(6).trim());
                array_teacher.add(teacher);
            }conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array_teacher;
    }
}
