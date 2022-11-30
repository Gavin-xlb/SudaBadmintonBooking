package com.action;

import com.beans.*;
import com.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/School_ManagerFormAction2.do")
public class School_ManagerFormAction2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        String option=new String(request.getParameter("option").getBytes("ISO-8859-1"),"UTF-8").trim();
        if(option.equalsIgnoreCase("学院信息")){
            College_InfoDao cid=new College_InfoDao();
            ArrayList<College_Info> array_college;
            array_college=cid.findAllColleges();
            //System.out.println(array_college.size());
            StringBuffer results=new StringBuffer("<table>");
            results.append("<tr><td>学院名称</td><td>学院代码</td><td>学院人数</td></tr>");
            for(College_Info c:array_college){
                results.append("<tr>");
                results.append("<td>");
                results.append(c.getCollege_name());
                results.append("</td>");
                results.append("<td>");
                results.append(c.getCollege_id());
                results.append("</td>");
                results.append("<td>");
                results.append(c.getCollege_pc());
                results.append("</td>");
                results.append("</tr>");
            }
            results.append("</table>");
            response.getWriter().println(results.toString());
        }
        else if(option.equalsIgnoreCase("专业信息")){
            Major_InfoDao mid=new Major_InfoDao();
            ArrayList<Major_Info> array_mi;
            array_mi=mid.findAllMajors();
            StringBuffer results=new StringBuffer("<table>");
            results.append("<tr><td>专业名称</td><td>专业所在学院</td><td>专业代码</td><td>专业人数</td></tr>");
            for(Major_Info m:array_mi){
                results.append("<tr>");
                results.append("<td>");
                results.append(m.getMajor_name());
                results.append("</td>");
                results.append("<td>");
                results.append(m.getMajor_college());
                results.append("</td>");
                results.append("<td>");
                results.append(m.getMajor_id());
                results.append("</td>");
                results.append("<td>");
                results.append(m.getMajor_pc());
                results.append("</td>");
                results.append("</tr>");
            }
            results.append("</table>");
            response.getWriter().println(results.toString());
        }
        else if(option.equalsIgnoreCase("班级信息")){
            Class_InfoDao cid=new Class_InfoDao();
            ArrayList<Class_Info> array_ci;
            array_ci=cid.findAllClasses();
            StringBuffer results=new StringBuffer("<table>");
            results.append("<tr><td>班级名称</td><td>班级所在学院</td><td>班级所在专业</td><td>班级人数</td></tr>");
            for(Class_Info c:array_ci){
                results.append("<tr>");
                results.append("<td>");
                results.append(c.getClass_name());
                results.append("</td>");
                results.append("<td>");
                results.append(c.getClass_college());
                results.append("</td>");
                results.append("<td>");
                results.append(c.getClass_major());
                results.append("</td>");
                results.append("<td>");
                results.append(c.getClass_pc());
                results.append("</td>");
                results.append("</tr>");
            }
            results.append("</table>");
            response.getWriter().println(results.toString());
        }
        else if(option.equalsIgnoreCase("教师信息")){
            TeacherDao td=new TeacherDao();
            ArrayList<Teacher> array_tea;
            array_tea=td.findAllTeachers();
            StringBuffer results=new StringBuffer("<table>");
            results.append("<tr><td>身份证号</td><td>工号</td><td>姓名</td><td>角色</td><td>所在学院</td><td>健康码</td></tr>");
            for(Teacher t:array_tea){
                results.append("<tr>");
                results.append("<td>");
                results.append(t.getTidnumber());
                results.append("</td>");
                results.append("<td>");
                results.append(t.getTno());
                results.append("</td>");
                results.append("<td>");
                results.append(t.getTname());
                results.append("</td>");
                results.append("<td>");
                results.append(t.getTrole());
                results.append("</td>");
                results.append("<td>");
                results.append(t.getTcollege());
                results.append("</td>");
                results.append("<td>");
                results.append(t.getTcolor());
                results.append("</td>");
                results.append("</tr>");
            }
            results.append("</table>");
            response.getWriter().println(results.toString());
        }
        else{ //学生信息
            StudentDao sd=new StudentDao();
            ArrayList<Student> array_s;
            array_s=sd.findAllStudents();
            StringBuffer results=new StringBuffer("<table>");
            results.append("<tr><td>身份证号</td><td>学号</td><td>姓名</td><td>所在学院</td><td>所在专业</td><td>所在班级</td><td>健康码</td></tr>");
            for(Student s:array_s){
                results.append("<tr>");
                results.append("<td>");
                results.append(s.getSidnumber());
                results.append("</td>");
                results.append("<td>");
                results.append(s.getSno());
                results.append("</td>");
                results.append("<td>");
                results.append(s.getSname());
                results.append("</td>");
                results.append("<td>");
                results.append(s.getScollege());
                results.append("</td>");
                results.append("<td>");
                results.append(s.getSmajor());
                results.append("</td>");
                results.append("<td>");
                results.append(s.getSclass());
                results.append("</td>");
                results.append("<td>");
                results.append(s.getScolor());
                results.append("</td>");
                results.append("</tr>");
            }
            results.append("</table>");
            response.getWriter().println(results.toString());
        }
    }
}
