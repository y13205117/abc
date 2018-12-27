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
    <title></title>
</head>
<body>
<ul>
    <li>查看部门</li>
    <li>查看职位</li>
    <li>查看员工</li>
    <li>薪资结算</li>
    <li>查看考勤</li>
    <li>查看培训</li>
    <li>查看招聘</li>
    <li>查看奖惩</li>
</ul>
</body>
</html>

