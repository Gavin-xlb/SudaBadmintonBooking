package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller.do")
public class Controller extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String action=request.getParameter("action");
        String flag=request.getParameter("flag");
        if(action.equalsIgnoreCase("login")){
            request.getRequestDispatcher("LoginAction.do").forward(request,response);
        }
        else if(action.equalsIgnoreCase("error")){
            request.setAttribute("flag",flag);
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
        else if(action.equalsIgnoreCase("applycodeforstudent")){
            request.getRequestDispatcher("applyformforstudent.jsp").forward(request,response);
        }
        else if(action.equalsIgnoreCase("applycodeforteacher")){
            request.getRequestDispatcher("applyformforteacher.jsp").forward(request,response);
        }
        else if(action.equalsIgnoreCase("applyformforstudent")){
            request.getRequestDispatcher("ApplyFormActionforstudent.do").forward(request,response);
        }
        else if(action.equalsIgnoreCase("applyformforteacher")){
            request.getRequestDispatcher("ApplyFormActionforteacher.do").forward(request,response);
        }
        else if(action.equalsIgnoreCase("SucessfullySign")){
            request.getRequestDispatcher("SucessfullySign.jsp").forward(request,response);
        }
        else if(action.equalsIgnoreCase("SucessfullyApplied")){
            request.getRequestDispatcher("SucessfullyAppliedShowing.jsp").forward(request,response);
        }
        else if(action.equalsIgnoreCase("Sys_Manager")){
            request.getRequestDispatcher("Sys_Manager_interface.jsp").forward(request,response);
        }
        else if(action.equalsIgnoreCase("School_Manager")){
            request.getRequestDispatcher("School_Manager_interface.jsp").forward(request,response);
        }
        else if(action.equalsIgnoreCase("College_Manager")){
            request.getRequestDispatcher("College_Manager_interface.jsp").forward(request,response);
        }


    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String action=request.getParameter("action");
        if(action.equalsIgnoreCase("College_ManagerForm")){
            request.getRequestDispatcher("College_ManagerFormAction.do").forward(request,response);
        }
        else if(action.equalsIgnoreCase("College_ManagerForm2")){
            //System.out.println(request.getQueryString());
            request.getRequestDispatcher("College_ManagerFormAction2.do").forward(request,response);
        }
        //System.out.println(request.getQueryString());
        if(action.equalsIgnoreCase("School_ManagerForm")){
            request.getRequestDispatcher("School_ManagerFormAction.do").forward(request,response);
        }
        else if(action.equalsIgnoreCase("School_ManagerForm2")){
            request.getRequestDispatcher("School_ManagerFormAction2.do").forward(request,response);
        }
        else if(action.equalsIgnoreCase("School_ManagerForm3")){
            request.getRequestDispatcher("School_ManagerFormAction3.do").forward(request,response);
        }
        else if(action.equalsIgnoreCase("Sys_ManagerForm")){
            request.getRequestDispatcher("Sys_ManagerFormAction.do").forward(request,response);
        }
        else if(action.equalsIgnoreCase("Sys_ManagerForm2")){
            request.getRequestDispatcher("Sys_ManagerFormAction2.do").forward(request,response);
        }
    }
}
