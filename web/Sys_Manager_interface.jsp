<%--
  Created by IntelliJ IDEA.
  User: 10049
  Date: 2020/6/10
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统管理员界面</title>
    <script type="text/javascript" src="Sys_Manager_interface.js"></script>
</head>
<body>
    <h3 align="center" style="color: cornflowerblue">系统管理员界面</h3>
<%--    <p>--%>
<%--        <form action="Controller.do?action=Sys_ManagerForm" method="post">--%>
<%--        学院:<input type="=text" name="college" placeholder="请输入有效学院名"/>&nbsp&nbsp&nbsp&nbsp--%>
<%--        专业:<input type="=text" name="major" placeholder="请输入有效专业名"/>&nbsp&nbsp&nbsp&nbsp--%>
<%--        班级:<input type="=text" name="class" placeholder="请输入有效班级号"/>--%>
<%--    </form>--%>

<%--    </p>--%>
    <h4 style="color: cornflowerblue">修改密码</h4><br>
    工号：&nbsp&nbsp&nbsp&nbsp<input type="text" id="username"><br>
    新密码：<input type="text" id="psw">&nbsp&nbsp&nbsp&nbsp
    <input type="button" value="修改" onclick="updatepsw()"/>
    <form action="#" name="Sys_ManagerForm">
<%--        <h4 style="color: cornflowerblue">信息管理</h4><br>--%>
<%--        操作:<select id="op">--%>
<%--        <option value="0">增加</option>--%>
<%--        <option value="1">删除</option>--%>
<%--        <option value="2">修改</option>--%>
<%--        <option value="3">查询</option>--%>
<%--    </select>&nbsp&nbsp&nbsp&nbsp--%>
<%--        <div style="display: none;" id="div1"><input type="text" id="text1"></div>--%>
        <h4 style="color: cornflowerblue">打卡信息查询</h4><br>
        身份:<select name="signInfo_Search_status">
        <option selected>学生</option>
        <option>教师</option>
    </select>&nbsp&nbsp&nbsp&nbsp
        查询内容:<select name="search_content">
        <option selected>健康码查询</option>
        <option>打卡记录查询</option>
    </select>&nbsp&nbsp&nbsp&nbsp
        查询范围:<select name="signInfo_Search_scope">
        <option selected>按学院查询</option>
        <option>按专业查询</option>
        <option>按班级查询</option>
        <option>按个人查询</option>
    </select><br/>
        学院:<input type="text" name="college_name"/>&nbsp&nbsp&nbsp&nbsp
        专业:<input type="text" name="major_name"/>&nbsp&nbsp&nbsp&nbsp
        班级:<input type="text" name="class_name"/>&nbsp&nbsp&nbsp&nbsp
        学号或工号:<input type="text" name="number"/>&nbsp&nbsp&nbsp&nbsp
        <input type="button" name="search2" value="查询" onclick="displaySign_Info2()">

    </form>

    <div align="center" id="newpart">
        <h4 align="left" style="color: cornflowerblue">查询结果如下:</h4>
        <p align="=center" style="text-align: center" id="newline"></p>
        <table style="text-align: center" width="900px" border="1" style="border-color:black" id="tableList"></table>
    </div>

</body>
</html>
