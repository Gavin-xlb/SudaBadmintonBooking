package com.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/SucessfullyAppliedAction.do")
public class SucessfullyAppliedAction extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String t=df.format(new Date());// new Date()为获取当前系统时间
        /*request.setAttribute("codepath","qrCode/"+"Student_qrCode/"+
                new String(request.getParameter("stu_no").getBytes("ISO-8859-1"),"UTF-8")
                +"/"+t+".jpg");*/

        if(((String)request.getSession().getAttribute("status")).trim().equalsIgnoreCase("学生"))
        request.getSession().setAttribute("codepath",
                "Student_qrCode/"+new String(request.getParameter("stu_no").getBytes("ISO-8859-1"),"UTF-8").trim()
                +"/"+t+".jpg");
        else if(((String)request.getSession().getAttribute("status")).trim().equalsIgnoreCase("普通教师"))
            request.getSession().setAttribute("codepath",
                    "Teacher_qrCode/"+new String(request.getParameter("tea_no").getBytes("ISO-8859-1"),"UTF-8").trim()
                            +"/"+t+".jpg");
        



        request.getRequestDispatcher("Controller.do?action=SucessfullyAppliedShowing").forward(request,response);

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
