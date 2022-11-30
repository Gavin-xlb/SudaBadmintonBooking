package com.action;

import com.beans.Student;
import com.beans.Student_Sign;
import com.dao.StudentDao;
import com.dao.Student_SignDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/ApplyFormActionforstudent.do")
@MultipartConfig
public class ApplyFormActionforstudent extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDao stu_dao=new StudentDao();
        Student_SignDao ss_dao=new Student_SignDao();
        Student stu=(Student)(request.getSession().getAttribute("Student_Info"));
        String op1=new String(request.getParameter("option1").getBytes("ISO-8859-1"),"UTF-8");
        String op2=new String(request.getParameter("option2").getBytes("ISO-8859-1"),"UTF-8");
        String op3=new String(request.getParameter("option3").getBytes("ISO-8859-1"),"UTF-8");
        String op4=new String(request.getParameter("option4").getBytes("ISO-8859-1"),"UTF-8");
        String[] op5=request.getParameterValues("sickness");
        for(String str:op5) str = new String(str.getBytes("ISO-8859-1"), "utf-8");
        int sicknum=0; //症状数
        for(int i=0;i<op5.length;i++){
            if(op5[i].equalsIgnoreCase("nosickness")) continue;
            sicknum++;
        }
        //学号或工号
        String stu_no=new String(request.getParameter("stu_no").getBytes("ISO-8859-1"),"UTF-8");
        //姓名
        String stu_name=new String(request.getParameter("stu_name").getBytes("ISO-8859-1"),"UTF-8");
        //身份
        String stu_status=(String)request.getSession().getAttribute("status");//System.out.println(stu_status);
        //学院
        //String stu_college=((Student)(request.getSession().getAttribute("Student_Info"))).getScollege();
        //码颜色
        //String stu_color=((Student)(request.getSession().getAttribute("Student_Info"))).getScolor();
        request.setAttribute("stu_no",stu_no);
        //获得选择的是每日一报/健康码申领
        String choice=(String)request.getSession().getAttribute("choice");//System.out.println(choice);
        String color="none";
        Student_SignDao stu_sign_dao=new Student_SignDao();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String time=df.format(new Date());// new Date()为获取当前系统时间
        boolean temp;
        //修改Student_Info里的Scolor属性，表名该学生的当前码状态
        if(op1.trim().equalsIgnoreCase("yes") || op2.trim().equalsIgnoreCase("yes")
                ||op3.trim().equalsIgnoreCase("yes") || op4.trim().equalsIgnoreCase("yes")|| sicknum >= 1) {
            if (op1.trim().equalsIgnoreCase("yes") || op2.trim().equalsIgnoreCase("yes") || sicknum == 1) {
                try {//黄码
                    color="yellow";
                    temp=stu_sign_dao.InsertIntoStudent_Sign(stu_no,stu_name,time,color,choice.trim());
                    if(temp==true){
                        if(stu.getScolor().trim().equalsIgnoreCase("green")||stu.getScolor().trim().equalsIgnoreCase("none"))
                            stu_dao.updateScolor(stu_no,color);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (op3.trim().equalsIgnoreCase("yes") || op4.trim().equalsIgnoreCase("yes") || sicknum >= 2) {
                try {//红码
                    color="red";
                    temp=stu_sign_dao.InsertIntoStudent_Sign(stu_no,stu_name,time,color,choice.trim());//System.out.println("修改前"+stu.getScolor().trim());
                    if(temp==true){
                        if(stu.getScolor().trim().equalsIgnoreCase("green")||stu.getScolor().trim().equalsIgnoreCase("yellow")
                                ||stu.getScolor().trim().equalsIgnoreCase("none"))
                            stu_dao.updateScolor(stu_no,color);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }//System.out.println("修改后"+stu_dao.findBySno(stu_no).getScolor().trim());
            }
        }
        else {//绿码
            try {
                color="green";
                temp=stu_sign_dao.InsertIntoStudent_Sign(stu_no,stu_name,time,color,choice.trim());
                if(temp==true){
                    //每日一报表中所有该学生的信息
                    ArrayList<Student_Sign> ss_array=ss_dao.findStudentsBySno(stu_no);
                    if(stu.getScolor().trim().equalsIgnoreCase("none")) stu_dao.updateScolor(stu_no,color);
                    else if(stu.getScolor().trim().equalsIgnoreCase("yellow")){
                        //找到最后一个黄码的位置
                        int pos=0;
                        for(int i=ss_array.size()-1;i>=0;i--){
                            if(ss_array.get(i).getScode_color().trim().equalsIgnoreCase("yellow")){
                                pos=i;
                                break;
                            }
                        }
                        if(pos<ss_array.size()-7) stu_dao.updateScolor(stu_no,"green");
                    }
                    else{ //red
                        //System.out.println("修改前："+stu.getScolor());
                        //System.out.println(ss_array.size());
                        if(ss_array.size()>7){
                            int j;
                            for(j=ss_array.size()-1;j>=ss_array.size()-7;j--){
                                if(!ss_array.get(j).getScode_color().trim().equalsIgnoreCase("green")) break;
                            }
                            //System.out.println(j);
                            if(j<ss_array.size()-7) stu_dao.updateScolor(stu_no,"yellow");
                            //System.out.println("修改后："+stu_dao.findBySno(stu_no).getScolor().trim());
                        }

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stu=stu_dao.findBySno(stu_no);
        String color_code;
        if(stu.getScolor().trim().equalsIgnoreCase("yellow")) color_code="#ffff00";
        else if(stu.getScolor().trim().equalsIgnoreCase("red")) color_code="#ff0000";
        else if(stu.getScolor().trim().equalsIgnoreCase("green")) color_code = "#00ff00";
        else color_code="#000000";
        request.setAttribute("stu_color",color_code);
        //System.out.println(stu.getScolor());
        if(choice.trim().equalsIgnoreCase("每日一报"))
            request.getRequestDispatcher("Controller.do?action=SucessfullySign").forward(request,response);
        else {
            request.getSession().setAttribute("student",stu);
            request.getRequestDispatcher("Controller.do?action=SucessfullyApplied").forward(request,response);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}
