<%--
  Created by IntelliJ IDEA.
  User: 10049
  Date: 2020/6/6
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>登录失败</title>
</head>
<body>
    <c:if test="${requestScope.flag==1}">
        <h2>数据源连接失败或者数据库中不存在此对象！</h2>
    </c:if>
    <c:if test="${requestScope.flag==2}">
        <h2>登录时的姓名与实际姓名不匹配！</h2>
    </c:if>
    <c:if test="${requestScope.flag==3}">
        <h2>密码不正确！</h2>
    </c:if>
    <c:if test="${requestScope.flag==4}">
        <h2>身份不匹配！</h2>
    </c:if>


<br>
<a href="login.jsp">返回登录界面</a>
</body>
</html>
