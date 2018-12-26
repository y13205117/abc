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
</head>
<body>
<ul>
    <li>上班打卡</li>
    <li>下班打卡</li>
    <li>创建部门</li>
    <li>发布招聘</li>
    <li>查看简历</li>
</ul>
</body>
</html>

