package com.action;

import com.beans.Manager_Password_Info;
import com.dao.Manager_Password_InfoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/School_ManagerFormAction.do")
public class School_ManagerFormAction extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8").trim();
        String psw=new String(request.getParameter("psw").getBytes("ISO-8859-1"),"UTF-8").trim();
        //System.out.println(username+" "+psw);
        Manager_Password_InfoDao mpid=new Manager_Password_InfoDao();
        Manager_Password_Info mpi=mpid.findManagerByWnoAndWrole(username,"院级管理员");
        String message;
        StringBuffer results=new StringBuffer("<response><message>");
        if(mpi==null)
            message="用户不存在或没有修改权限";
        else{ //找到该用户
            boolean flag=mpid.updatepswByWno(psw,username);
            if(flag) message="修改成功！";
            else message="修改失败!";
        }
        //System.out.println(message);
        results.append(message);
        results.append("</message></response>");
        response.getWriter().println(results.toString());
    }
}
