<%--
  Created by IntelliJ IDEA.
  User: 10049
  Date: 2020/6/7
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>
        <c:if test="${sessionScope.choice eq '健康码申领'}">申领学校健康码</c:if>
        <c:if test="${sessionScope.choice eq '每日一报'}">每日一报</c:if>
    </title>
    <style type="text/css">
        body{
            overflow:scroll;
        }
        div{
            text-align:left;
            position: absolute;
            width: 400px ;
            left:50%;
            margin-left: -200px;
        }
    </style>
    <script type="text/javascript" src="ExamineApplyform.js"></script>
</head>
<body>
<form name="applyform" action="Controller.do?action=applyformforstudent" method="post" style="text-align: center" >
    <div>
        <h3>个人信息</h3>
        <br/>
        姓名：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="stu_name" readonly="readonly" value="${sessionScope.Student_Info.sname} "><br>
        身份证号：<input type="text" name="stu_idnumber" readonly="readonly" value="${sessionScope.Student_Info.sidnumber} "><br>
        学号：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="stu_no" readonly="readonly" value="${sessionScope.Student_Info.sno} "><br>
        手机号：&nbsp&nbsp&nbsp<input type="text" name="phonenumber" maxlength="11" style="width: 150px" placeholder="请输入常用手机号">
        <span style="font-weight: bold;color: red">*必填</span><br>
        1.本人近期（14天内）是否去过湖北省或重点疫区？<br>
        <input type="radio" name="option1" value="yes">是&nbsp&nbsp&nbsp
        <input type="radio" name="option1" value="no" checked="checked">否<br>
        2.本人近期（14天内）是否去过国外？<br>
        <input type="radio" name="option2" value="yes">是&nbsp&nbsp&nbsp
        <input type="radio" name="option2" value="no" checked="checked">否<br>
        3.本人近期（14天内）是否接触过新冠确诊病人或疑似病人？<br>
        <input type="radio" name="option3" value="yes">是&nbsp&nbsp&nbsp
        <input type="radio" name="option3" value="no" checked="checked">否<br>
        4.本人是否被卫生部门确认为新冠肺炎确诊病例或疑似病例？<br>
        <input type="radio" name="option4" value="yes">是&nbsp&nbsp&nbsp
        <input type="radio" name="option4" value="no" checked="checked">否<br>
        5.当前健康状况？无异常、发烧（≥37.3℃）、乏力、干咳、鼻塞、流涕、咽痛、腹泻等。<br>
        <input type="checkbox" name="sickness" value="nosickness" checked="checked">无异常
        <input type="checkbox" name="sickness" value="fever">发烧
        <input type="checkbox" name="sickness" value="lackstrength">乏力
        <input type="checkbox" name="sickness" value="cough">干咳<br>
        <input type="checkbox" name="sickness" value="rhinobyon">鼻塞
        <input type="checkbox" name="sickness" value="rhinorrhea">流涕
        <input type="checkbox" name="sickness" value="sorethroat">咽痛
        <input type="checkbox" name="sickness" value="diarrhea">腹泻
        <p style="color: red;font-weight: bold">本人郑重承诺：填报信息真实，愿意承担相应的法律责任。</p><br>
        <input type="button" name="commit" style="width: 60px;align-content: center" value="提交" onclick="examine()"/>
    </div>
</form>
</body>
</html>
