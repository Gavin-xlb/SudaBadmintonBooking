package com.action;

import com.beans.Student;
import com.beans.Manager;
import com.beans.Teacher;
import com.dao.StudentDao;
import com.dao.ManagerDao;
import com.dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/LoginAction.do")
public class LoginAction extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String status=new String(request.getParameter("status").getBytes("ISO-8859-1"),"UTF-8");
        String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
        String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        String password=new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
        String choice=new String(request.getParameter("choices").getBytes("ISO-8859-1"),"UTF-8");
        request.getSession().setAttribute("status",status);
        request.getSession().setAttribute("choice",choice);
        if(!choice.trim().equalsIgnoreCase("管理员登录")){
            //登录界面选择身份为学生
            if(status.equalsIgnoreCase("学生")) {
                StudentDao stuDao=new StudentDao();
                Student stu=stuDao.findBySno(username.trim());//System.out.println(stu);
                if(stu==null){ //数据库中没有该对象或者数据库连接失败
                    request.getRequestDispatcher("Controller.do?action=error&flag=1").forward(request,response);
                }
                else{
                    if(!(stu.getSname().trim().equalsIgnoreCase(name.trim()))){ //登录时的姓名与实际姓名不匹配
                        request.getRequestDispatcher("Controller.do?action=error&flag=2").forward(request,response);
                    }
                    else{
                        String passfromdb=stu.getSidnumber().substring(10);
                        if(!password.equalsIgnoreCase(passfromdb)){ //密码不正确
                            request.getRequestDispatcher("Controller.do?action=error&flag=3").forward(request,response);
                        }
                        else{
                            request.getSession().setAttribute("Student_Info",stu);
                            request.getRequestDispatcher("Controller.do?action=applycodeforstudent").forward(request,response);
                        }
                    }
                }
            }
            //登录界面选择身份不为学生
            else {
                TeacherDao teadao=new TeacherDao();
                Teacher tea=teadao.findByTno(username.trim());
                if(tea==null){ //数据库中没有该对象或者数据库连接失败
                    request.getRequestDispatcher("Controller.do?action=error&flag=1").forward(request,response);
                }
                else{
                    if(!(tea.getTname().trim().equalsIgnoreCase(name.trim()))){ //登录时的姓名与实际姓名不匹配
                        request.getRequestDispatcher("Controller.do?action=error&flag=2").forward(request,response);
                    }
                    else{
                        String passfromdb=tea.getTidnumber().substring(10);
                        if(!password.equalsIgnoreCase(passfromdb)){ //密码不正确
                            request.getRequestDispatcher("Controller.do?action=error&flag=3").forward(request,response);
                        }
                        else{
                            if(!status.trim().equalsIgnoreCase(tea.getTrole().trim())){
                                request.getRequestDispatcher("Controller.do?action=error&flag=4").forward(request,response);
                            }
                            request.getSession().setAttribute("Teacher_Info",tea);
                            request.getRequestDispatcher("Controller.do?action=applycodeforteacher").forward(request,response);
                        }
                    }
                }
            }
        }
        else{  //管理员登录
            //登录界面选择身份为系统管理员
            if(status.equalsIgnoreCase("系统管理员")){
                ManagerDao sysdao=new ManagerDao();
                //获得所有系统管理员的信息
                ArrayList<Manager> sm=sysdao.findManagersByRole(status.trim());
                if(sm.size()==0)
                    request.getRequestDispatcher("Controller.do?action=error&flag=1").forward(request,response);
                int i;
                for(i=0;i<sm.size();i++){
                    if(sm.get(i).getWno().trim().equalsIgnoreCase(username.trim()))
                        if(sm.get(i).getWpassword().trim().equalsIgnoreCase(password.trim())){
                            request.getRequestDispatcher("Controller.do?action=Sys_Manager").forward(request,response);
                        }
                        else request.getRequestDispatcher("Controller.do?action=error&flag=3").forward(request,response);
                }
                request.getRequestDispatcher("Controller.do?action=error&flag=1").forward(request,response);
            }
            else if(status.equalsIgnoreCase("校级管理员")){
                ManagerDao schooldao=new ManagerDao();
                //获得所有校级管理员的信息
                ArrayList<Manager> sm=schooldao.findManagersByRole(status.trim());
                if(sm.size()==0)
                    request.getRequestDispatcher("Controller.do?action=error&flag=1").forward(request,response);
                int i;
                for(i=0;i<sm.size();i++){
                    if(sm.get(i).getWno().trim().equalsIgnoreCase(username.trim()))
                        if(sm.get(i).getWpassword().trim().equalsIgnoreCase(password.trim())){
                            request.getRequestDispatcher("Controller.do?action=School_Manager").forward(request,response);
                        }
                        else request.getRequestDispatcher("Controller.do?action=error&flag=3").forward(request,response);
                }
                request.getRequestDispatcher("Controller.do?action=error&flag=1").forward(request,response);
            }
            else{
                ManagerDao collegedao=new ManagerDao();
                TeacherDao td=new TeacherDao();
                //获得所有院级管理员的信息
                ArrayList<Manager> sm=collegedao.findManagersByRole(status.trim());
                if(sm.size()==0)
                    request.getRequestDispatcher("Controller.do?action=error&flag=1").forward(request,response);
                int i;
                for(i=0;i<sm.size();i++){
                    if(sm.get(i).getWno().trim().equalsIgnoreCase(username.trim()))
                        if(sm.get(i).getWpassword().trim().equalsIgnoreCase(password.trim())){
                            request.getSession().setAttribute("college",td.findByTno(username.trim()).getTcollege().trim());
                            request.getRequestDispatcher("Controller.do?action=College_Manager").forward(request,response);
                        }
                        else request.getRequestDispatcher("Controller.do?action=error&flag=3").forward(request,response);
                }
                request.getRequestDispatcher("Controller.do?action=error&flag=1").forward(request,response);
            }
        }
    }
}
