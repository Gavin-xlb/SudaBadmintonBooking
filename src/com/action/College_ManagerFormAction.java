package com.action;

import com.beans.Student;
import com.beans.Student_Sign;
import com.beans.Teacher;
import com.beans.Teacher_Sign;
import com.dao.StudentDao;
import com.dao.Student_SignDao;
import com.dao.TeacherDao;
import com.dao.Teacher_SignDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/College_ManagerFormAction.do")
public class College_ManagerFormAction extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");
        String collegeName=new String(request.getParameter("collegeName").getBytes("ISO-8859-1"),"UTF-8").trim();
        String status=new String(request.getParameter("status").getBytes("ISO-8859-1"),"UTF-8").trim();
        String content=new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8").trim();
        String scope=new String(request.getParameter("scope").getBytes("ISO-8859-1"),"UTF-8").trim();
        String major_name=new String(request.getParameter("major_name").getBytes("ISO-8859-1"),"UTF-8").trim();
        String class_name=new String(request.getParameter("class_name").getBytes("ISO-8859-1"),"UTF-8").trim();
        String number=new String(request.getParameter("number").getBytes("ISO-8859-1"),"UTF-8").trim();
        if(status.equalsIgnoreCase("学生")){
            StudentDao sd=new StudentDao();
            if(content.equalsIgnoreCase("健康码查询")){
                if(scope.equalsIgnoreCase("按个人查询")){ //按个人查询
                    Student stu=sd.findBySnoAndCollege(number,collegeName);
                    //System.out.println(stu.getSno());
                    StringBuffer results=new StringBuffer("<table>");
                    results.append("<tr><td>学号</td><td>姓名</td><td>健康码</td></tr>");
                    if(stu!=null){
                        results.append("<tr>");
                        results.append("<td>");
                        results.append(stu.getSno());
                        results.append("</td>");
                        results.append("<td>");
                        results.append(stu.getSname());
                        results.append("</td>");
                        results.append("<td>");
                        results.append(stu.getScolor());
                        results.append("</td>");
                        results.append("</tr>");
                    }
                    results.append("</table>");
                    response.setContentType("text/xml;charset=UTF-8");
                    response.setHeader("Cache-Control","no-cache");
                    response.getWriter().println(results.toString());
                }
                else{
                    ArrayList<Student> array_stu=new ArrayList<Student>();
                    if(scope.equalsIgnoreCase("按学院查询"))
                        array_stu=sd.findStudentsByCollege(collegeName);
                    else if(scope.equalsIgnoreCase("按专业查询")){
                        array_stu=sd.findStudentsByMajorAndCollege(major_name,collegeName);
                    }

                    else if(scope.equalsIgnoreCase("按班级查询")){
                        array_stu=sd.findStudentsByClassAndMajorAndCollege(class_name,major_name,collegeName);
                    }
                    StringBuffer results=new StringBuffer("<table>");
                    results.append("<tr><td>学号</td><td>姓名</td><td>健康码</td></tr>");
                    for(Student s:array_stu){
                        results.append("<tr>");
                        results.append("<td>");
                        results.append(s.getSno());
                        results.append("</td>");
                        results.append("<td>");
                        results.append(s.getSname());
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
            else{ //打卡记录查询
                ArrayList<Student_Sign> array_ss=new ArrayList<Student_Sign>();
                Student_SignDao ssd=new Student_SignDao();
                if(scope.equalsIgnoreCase("按学院查询")){
                    array_ss=ssd.findStudentsByCollege(collegeName);

                }
                else if(scope.equalsIgnoreCase("按专业查询")){
                    array_ss=ssd.findStudentsByCollegeAndMajor(collegeName,major_name);
                }
                else if(scope.equalsIgnoreCase("按班级查询")){
                    array_ss=ssd.findStudentsByCollegeAndMajorAndClass(collegeName,major_name,class_name);
                }
                else{ //按个人查询
                    array_ss=ssd.findStudentsBySno(number);
                    //System.out.println(array_ss.size());
                }
                StringBuffer results=new StringBuffer("<table>");
                results.append("<tr><td>学号</td><td>姓名</td><td>日期</td><td>当天码的颜色</td><td>申请方式</td></tr>");
                for(Student_Sign s:array_ss){
                    results.append("<tr>");
                    results.append("<td>");
                    results.append(s.getSno());
                    results.append("</td>");
                    results.append("<td>");
                    results.append(s.getSname());
                    results.append("</td>");
                    results.append("<td>");
                    results.append(s.getSdate());
                    results.append("</td>");
                    results.append("<td>");
                    results.append(s.getScode_color());
                    results.append("</td>");
                    results.append("<td>");
                    results.append(s.getSsign_form());
                    results.append("</td>");
                    results.append("</tr>");
                }
                results.append("</table>");
                response.getWriter().println(results.toString());
            }
        }
        else{ //教师
            TeacherDao td=new TeacherDao();
            if(content.equalsIgnoreCase("健康码查询")){
                if(scope.equalsIgnoreCase("按个人查询")){ //按个人查询
                    Teacher tea=td.findByTnoAndCollege(number,collegeName);
                    //System.out.println(stu.getSno());
                    StringBuffer results=new StringBuffer("<table>");
                    results.append("<tr><td>工号</td><td>姓名</td><td>身份</td><td>健康码</td></tr>");
                    if (tea != null) {
                        results.append("<tr>");
                        results.append("<td>");
                        results.append(tea.getTno());
                        results.append("</td>");
                        results.append("<td>");
                        results.append(tea.getTname());
                        results.append("</td>");
                        results.append("<td>");
                        results.append(tea.getTrole());
                        results.append("</td>");
                        results.append("<td>");
                        results.append(tea.getTcolor());
                        results.append("</td>");
                        results.append("</tr>");
                    }

                    results.append("</table>");
                    response.getWriter().println(results.toString());
                }
                else{
                    ArrayList<Teacher> array_tea=new ArrayList<Teacher>();
                    if(scope.equalsIgnoreCase("按学院查询"))
                        array_tea=td.findTeachersByCollege(collegeName);
                    StringBuffer results=new StringBuffer("<table>");
                    results.append("<tr><td>工号</td><td>姓名</td><td>身份</td><td>健康码</td></tr>");
                    for(Teacher t:array_tea){
                        results.append("<tr>");
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
                        results.append(t.getTcolor());
                        results.append("</td>");
                        results.append("</tr>");
                    }
                    results.append("</table>");
                    response.getWriter().println(results.toString());
                }
            }
            else{ //打卡查询
                ArrayList<Teacher_Sign> array_ts=new ArrayList<Teacher_Sign>();
                Teacher_SignDao tsd=new Teacher_SignDao();
                if(scope.equalsIgnoreCase("按学院查询")){
                    array_ts=tsd.findTeachersByCollege(collegeName);
                }
                else{ //按个人查询
                    array_ts=tsd.findTeachersByTnoAndCollege(number,collegeName);
                }
                StringBuffer results=new StringBuffer("<table>");
                results.append("<tr><td>工号</td><td>姓名</td><td>日期</td><td>当天码的颜色</td><td>申请方式</td></tr>");
                for(Teacher_Sign s:array_ts){
                    results.append("<tr>");
                    results.append("<td>");
                    results.append(s.getTno());
                    results.append("</td>");
                    results.append("<td>");
                    results.append(s.getTname());
                    results.append("</td>");
                    results.append("<td>");
                    results.append(s.getTdate());
                    results.append("</td>");
                    results.append("<td>");
                    results.append(s.getTcode_color());
                    results.append("</td>");
                    results.append("<td>");
                    results.append(s.getTsign_form());
                    results.append("</td>");
                    results.append("</tr>");
                }
                results.append("</table>");
                response.getWriter().println(results.toString());
            }
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
    }
}
