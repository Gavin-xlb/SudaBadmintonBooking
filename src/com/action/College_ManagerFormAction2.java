package com.action;

import com.beans.Class_Info;
import com.beans.Major_Info;
import com.beans.Student;
import com.dao.Class_InfoDao;
import com.dao.Major_InfoDao;
import com.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/College_ManagerFormAction2.do")
public class College_ManagerFormAction2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        String option=new String(request.getParameter("option").getBytes("ISO-8859-1"),"UTF-8").trim();
        String collegeName=new String(request.getParameter("collegeName").getBytes("ISO-8859-1"),"UTF-8").trim();
        if(option.equalsIgnoreCase("专业信息")){
            Major_InfoDao mid=new Major_InfoDao();
            ArrayList<Major_Info> array_m=new ArrayList<Major_Info>();
            array_m=mid.findMajorsByCollege(collegeName);
            StringBuffer results=new StringBuffer("<table>");
            results.append("<tr><td>专业名称</td><td>专业代码</td><td>专业人数</td></tr>");
            for(Major_Info m:array_m){
                results.append("<tr>");
                results.append("<td>");
                results.append(m.getMajor_name());
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
            ArrayList<Class_Info> array_c=new ArrayList<>();
            array_c=cid.findClassesByCollege(collegeName);
            StringBuffer results=new StringBuffer("<table>");
            results.append("<tr><td>专业名称</td><td>班级名称</td><td>班级人数</td></tr>");
            for(Class_Info c:array_c){
                results.append("<tr>");
                results.append("<td>");
                results.append(c.getClass_major());
                results.append("</td>");
                results.append("<td>");
                results.append(c.getClass_name());
                results.append("</td>");
                results.append("<td>");
                results.append(c.getClass_pc());
                results.append("</td>");
                results.append("</tr>");
            }
            results.append("</table>");
            response.getWriter().println(results.toString());
        }
        else{ //学生信息
            StudentDao sd=new StudentDao();
            ArrayList<Student> array_s=new ArrayList<>();
            array_s=sd.findStudentsByCollege(collegeName);
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
