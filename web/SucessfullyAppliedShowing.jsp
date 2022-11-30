<%--
  Created by IntelliJ IDEA.
  User: 10049
  Date: 2020/6/7
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>申请结果</title>
    <style>
        .demo{
            width: 200px;
            height: 200px;
            display: table-cell;
            vertical-align: middle;
            text-align: center;
            position: absolute;
            left:50%;
            margin-left: -100px;
        }

    </style>
    <script type="text/javascript" src="qrcode.js"></script>
</head>
<body>
    <h3 style="color: cornflowerblue" align="center">感谢您完成此次填报！</h3><br>
    <p align="center" style="color: cornflowerblue">您的健康码为：</p>
    <div class="demo" id="qrcode">
    </div>
    <script>
        var qrcode = new QRCode('qrcode', {
            <c:if test="${sessionScope.status eq '学生'}" var="judge">
            text: '姓名：${sessionScope.student.sname}, 身份：${sessionScope.status}, 学号：${sessionScope.student.sno}, 学院：${sessionScope.student.scollege}',
            </c:if>
            <c:if test="${!judge}">
            text: '姓名：${sessionScope.teacher.tname}, 身份：${sessionScope.status}, 工号：${sessionScope.teacher.tno}, 学院：${sessionScope.teacher.tcollege}',
            </c:if>
            width: 200,
            height: 200,
            colorDark :
            <c:if test="${sessionScope.status eq '学生'}" var="judge">'${requestScope.stu_color}'</c:if>
            <c:if test="${!judge}">'${requestScope.tea_color}'</c:if>,
            colorLight : '#ffffff',
            correctLevel : QRCode.CorrectLevel.H
        });
    </script>
</body>
</html>
