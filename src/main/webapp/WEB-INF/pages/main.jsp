<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>主页</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script src="js/register.js"></script>
</head>
<body>
<c:if test="${empty sessionScope.user}">
    <form id="f1" method="post" action="login">
        用户名:<input name="name" type="text">
        密码:<input type="password" name="pass">
        <input name="login" type="button" value="登录">
        <a href="goRegister">注册</a>
    </form>
</c:if>
<c:if test="${!empty sessionScope.user}">
    <h4>欢迎${sessionScope.user.name}登陆<a href="goOut">注销</a></h4>
    <c:if test="${!empty sessionScope.memberShowCV}">
        <script language='javascript'>alert('您收到面试邀请，请及时查阅')</script>
    </c:if>
</c:if>
<a href="goVitae">查看个人简历</a>
<a href="goRecruit">查看招聘信息</a>
<a href="goShowMC">查看面试邀请</a>
</body>
</html>

