<%--
  Created by IntelliJ IDEA.
  User: 10049
  Date: 2020/6/6
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <style type="text/css">
        div{
            width: 400px;
            height: 300px;
        }
        .center-in-center {
            position: absolute;
            top: 50%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -moz-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            -o-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
        .setbg{
            width:100%;
            height:100%;
            background-image:url(./image/login_bg.jpg);
            background-repeat:no-repeat;
            position:absolute;
            z-index:100;
            background-size:cover;
        }
        .setbtn{
            width:90px;
            height:30px;
        }
        span{
            color:#ff0000;
            font-weight: bold;
        }

    </style>
    <script type="text/javascript" src="CheckLogin.js"></script>

</head>
<body class="setbg">
<h1 style="color: cornflowerblue" align="center">师生健康码管理系统</h1>
<div class="center-in-center">
    <form name="loginform" action="Controller.do?action=login" method="post">
        身份：&nbsp&nbsp&nbsp<select name="status" >
        <option>系统管理员</option>
        <option>校级管理员</option>
        <option>院级管理员</option>
        <option selected>学生</option>
        <option>普通教师</option>
    </select><br><br>
        用户名：<input type="text" name="username" size="15" placeholder="请输入工号或学号"/><span>*必填</span><br><br>
        姓名：&nbsp&nbsp&nbsp<input type="text" name="name" size="15" placeholder="请输入姓名"/><span>*普通教师及学生必填</span><br><br>
        密码：&nbsp&nbsp&nbsp<input type="password" name="password" size="20" placeholder="请输入密码"/><span>*必填</span><br><br>
        选项：&nbsp&nbsp&nbsp<select name="choices" id="op">
        <option selected>健康码申领</option>
        <option>每日一报</option>
        <option>管理员登录</option>
    </select><br><br>
        <div class="setbtn" style="text-align: center ;width: 300px;height:100px" >
            <input type="button" name="login" class="setbtn" value="登录"  onclick="check()"/>
        </div>

    </form>
</div>


</body>
</html>
