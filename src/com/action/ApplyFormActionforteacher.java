package com.action;

import com.beans.Teacher;
import com.beans.Teacher_Sign;
import com.dao.TeacherDao;
import com.dao.Teacher_SignDao;

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

@WebServlet("/ApplyFormActionforteacher.do")
@MultipartConfig
public class ApplyFormActionforteacher extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeacherDao tea_dao=new TeacherDao();
        Teacher_SignDao ts_dao=new Teacher_SignDao();
        Teacher tea=(Teacher)(request.getSession().getAttribute("Teacher_Info"));
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
        String tea_no=new String(request.getParameter("tea_no").getBytes("ISO-8859-1"),"UTF-8");
        //姓名
        String tea_name=new String(request.getParameter("tea_name").getBytes("ISO-8859-1"),"UTF-8");
        //身份
        String tea_status=(String)request.getSession().getAttribute("status");//System.out.println(tea_status);
        //学院
        String tea_college=((Teacher)(request.getSession().getAttribute("Teacher_Info"))).getTcollege();
        //码颜色
        String tea_color=((Teacher)(request.getSession().getAttribute("Teacher_Info"))).getTcolor();
        request.setAttribute("tea_no",tea_no);
        //获得选择的是每日一报/健康码申领
        String choice=(String)request.getSession().getAttribute("choice");//System.out.println(choice);
        String color="none";
        Teacher_SignDao tea_sign_dao=new Teacher_SignDao();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String time=df.format(new Date());// new Date()为获取当前系统时间
        boolean temp;
        //修改Teacher_Info里的Tcolor属性，表名该教师的当前码状态
        if(op1.trim().equalsIgnoreCase("yes") || op2.trim().equalsIgnoreCase("yes")
                ||op3.trim().equalsIgnoreCase("yes") || op4.trim().equalsIgnoreCase("yes")|| sicknum >= 1) {
            if (op1.trim().equalsIgnoreCase("yes") || op2.trim().equalsIgnoreCase("yes") || sicknum == 1) {
                try {//黄码
                    color="yellow";
                    temp=tea_sign_dao.InsertIntoTeacher_Sign(tea_no,tea_name,time,color,choice.trim());
                    //System.out.println(temp);
                    if(temp==true){
                        if(tea.getTcolor().trim().equalsIgnoreCase("green")||tea.getTcolor().trim().equalsIgnoreCase("none"))
                            tea_dao.updateTcolor(tea_no,color);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (op3.trim().equalsIgnoreCase("yes") || op4.trim().equalsIgnoreCase("yes") || sicknum >= 2) {
                try {//红码
                    color="red";
                    temp=tea_sign_dao.InsertIntoTeacher_Sign(tea_no,tea_name,time,color,choice.trim());
                    if(temp==true){
                        if(tea.getTcolor().trim().equalsIgnoreCase("green")||tea.getTcolor().trim().equalsIgnoreCase("yellow")
                                ||tea.getTcolor().trim().equalsIgnoreCase("none"))
                            tea_dao.updateTcolor(tea_no,color);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else {//绿码
            try {
                color="green";
                temp=tea_sign_dao.InsertIntoTeacher_Sign(tea_no,tea_name,time,color,choice.trim());
                if(temp==true){
                    //每日一报表中所有该学生的信息
                    ArrayList<Teacher_Sign> ts_array=ts_dao.findTeachersByTno(tea_no);
                    if(tea.getTcolor().trim().equalsIgnoreCase("none")) tea_dao.updateTcolor(tea_no,color);
                    else if(tea.getTcolor().trim().equalsIgnoreCase("yellow")){
                        //找到最后一个黄码的位置
                        int pos=0;
                        for(int i=ts_array.size()-1;i>=0;i--){
                            if(ts_array.get(i).getTcode_color().trim().equalsIgnoreCase("yellow")){
                                pos=i;
                                break;
                            }
                        }
                        if(pos<ts_array.size()-7) tea_dao.updateTcolor(tea_no,"green");
                    }
                    else{ //red
                        if(ts_array.size()>7){
                            int j;
                            for(j=ts_array.size()-1;j>=ts_array.size()-7;j--){
                                if(!ts_array.get(j).getTcode_color().trim().equalsIgnoreCase("green")) break;
                            }
                            if(j<ts_array.size()-7) tea_dao.updateTcolor(tea_no,"yellow");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tea=tea_dao.findByTno(tea_no.trim());
        String color_code;
        //System.out.println(tea.getTcolor().trim());
        if(tea.getTcolor().trim().equalsIgnoreCase("yellow")) color_code="#ffff00";
        else if(tea.getTcolor().trim().equalsIgnoreCase("red")) color_code="#ff0000";
        else if(tea.getTcolor().trim().equalsIgnoreCase("green")) color_code = "#00ff00";
        else color_code="#000000";
        request.setAttribute("tea_color",color_code);
        if(choice.trim().equalsIgnoreCase("每日一报"))
            request.getRequestDispatcher("Controller.do?action=SucessfullySign").forward(request,response);
        else {
            request.getSession().setAttribute("teacher",tea);
            request.getRequestDispatcher("Controller.do?action=SucessfullyApplied").forward(request,response);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
