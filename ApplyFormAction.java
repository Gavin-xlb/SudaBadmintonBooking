package com.action;

import com.dao.StudentDao;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ApplyFormAction.do")
@MultipartConfig
public class ApplyFormAction extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String[] testarray=request.getParameterValues("option1");
        //System.out.println(testarray);
        //for(String s:testarray) System.out.println(s);
        //System.out.println(request.getParameter("phonenumber"));
        StudentDao stu_dao=new StudentDao();
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
        //学号
        String stu_num=new String(request.getParameter("stu_no").getBytes("ISO-8859-1"),"UTF-8");
        //姓名
        String stu_name=new String(request.getParameter("stu_name").getBytes("ISO-8859-1"),"UTF-8");
        //身份
        String stu_status="学生";
        //学院
        String stu_college=stu_dao.findBySno(stu_num.trim()).getScollege();
        request.setAttribute("stu_no",stu_num);
        String choice=(String)request.getSession().getAttribute("choice");
        //System.out.println(choice);
        //如果选择的是健康码申领，则需要制作二维码并显示，而且要把申领的结果反馈到数据库
        //如果是每日一报，只需要反馈到数据库
            String text = "姓名："+stu_name+"\n"+"身份："+stu_status+"\n"+"学号："+stu_num+"\n"+"学院："+stu_college+"\n";  //存放在二维码里的内容
            String logoPath = "D:\\IDEAdemo\\Teacher_and_Student_HealthCode_Management_System\\web\\image\\school_badge.jpg";
            String destPath = "D:\\IDEAdemo\\Teacher_and_Student_HealthCode_Management_System\\web\\qrCode\\Student_qrCode\\"+stu_num.trim();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String time=df.format(new Date());// new Date()为获取当前系统时间
            request.setAttribute("time",time);
            if(op1.trim().equalsIgnoreCase("yes") || op2.trim().equalsIgnoreCase("yes")
                    ||op3.trim().equalsIgnoreCase("yes") || op4.trim().equalsIgnoreCase("yes")|| sicknum >= 1) {
                if (op1.trim().equalsIgnoreCase("yes") || op2.trim().equalsIgnoreCase("yes") || sicknum == 1) {
                    try {//黄码
                        if(choice.equalsIgnoreCase("健康码申领")){
                            CreateQRcodeAction.encode(text, logoPath, destPath, true,time.trim(),0xffff00);
                            request.setAttribute("color","黄码");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (op3.trim().equalsIgnoreCase("yes") || op4.trim().equalsIgnoreCase("yes") || sicknum >= 2) {
                    try {//红码
                        if(choice.equalsIgnoreCase("健康码申领")){
                            CreateQRcodeAction.encode(text, logoPath, destPath, true,time.trim(),0xff0000);
                            request.setAttribute("color","红码");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                try {//绿码
                    if(choice.equalsIgnoreCase("健康码申领")){
                        CreateQRcodeAction.encode(text, logoPath, destPath, true,time.trim(),0x00ff00);
                        request.setAttribute("color","绿码");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        if(choice.equalsIgnoreCase("健康码申领"))
        request.getRequestDispatcher("Controller.do?action=SucessfullyApplied").forward(request,response);






    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}
