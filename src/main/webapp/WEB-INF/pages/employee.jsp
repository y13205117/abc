<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/25
  Time: 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>员工界面</title>
    <link href="css/employee.css" rel="stylesheet">
    <script src="js/jquery-3.1.0.js"></script>
    <script src="js/employee.js"></script>
    <script>

    </script>
</head>
<body>
<div id="top">
    <h4>欢迎${sessionScope.emp.id}登录</h4>
</div>
<div id="left">
    <ul>
        <li id="eGC">考勤打卡</li>
        <li id="eV">个人信息</li>
        <li id="eM">通讯录</li>
        <li id="eT">查看培训</li>
        <li id="eA">查看奖惩</li>
        <li id="eL">申请离职</li>
    </ul>
</div>
<div id="right">
    <div id="dGC">
        <ul id="clock">
            <li id="sec"></li>
            <li id="hour"></li>
            <li id="min"></li>
        </ul>
        <input type="button" value="上班打卡"><input type="button" value="下班打卡">
    </div>
    <div id="dV"></div>
    <div id="dM"></div>
    <div id="dT"></div>
    <div id="dA"></div>
    <div id="dL"></div>
</div>
</body>
</html>

