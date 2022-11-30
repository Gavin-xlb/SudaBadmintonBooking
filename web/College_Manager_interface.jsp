<%--
  Created by IntelliJ IDEA.
  User: 10049
  Date: 2020/6/10
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>院级管理员界面</title>
    <script type="text/javascript" src="College_Manager_interface.js"></script>
</head>
<body>
    <h3 align="center" style="color: cornflowerblue">院级管理员界面</h3>
    <p>所在学院:<input type="text" name="collegeName" id="collegeName" readonly="readonly" value="${sessionScope.college}"/></p><br>
        <h4 style="color: cornflowerblue">学院信息查询</h4><br>
        <form action="#" name="College_ManagerForm">
            <select name="collegeInfo_Search">
                <option selected>专业信息</option>
                <option>班级信息</option>
                <option>学生信息</option>
            </select>
            &nbsp&nbsp&nbsp&nbsp
            <input type="button" value="查询" name="search1" onclick="displayCollegeInfo()"/><br>
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
            </select>&nbsp&nbsp&nbsp&nbsp
            专业:<input type="text" name="major_name"/>&nbsp&nbsp&nbsp&nbsp
            班级:<input type="text" name="class_name"/>&nbsp&nbsp&nbsp&nbsp
            学号或工号:<input type="text" name="number"/>&nbsp&nbsp&nbsp&nbsp
            <input type="button" name="search2" value="查询" onclick="displaySign_Info()">
        </form>
    <div align="center" id="newpart">
        <h4 align="left" style="color: cornflowerblue">查询结果如下:</h4>
        <table style="text-align: center" width="900px" border="1" style="border-color:black" id="tableList"></table>
    </div>

</body>
</html>
