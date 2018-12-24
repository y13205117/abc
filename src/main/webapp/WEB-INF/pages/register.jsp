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
    <title>注册界面</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script src="js/register.js"></script>
</head>
<body>
<div>
    <form id="f1" method="post" action="register">
        用户名:<input name="name" type="text"><span id="us"></span><br/>
        密码:<input name="pass" type="password"><span id="up"></span><br/>
        确认密码:<input name="again" type="password"><span id="ag"></span><br/>
        <input name="reg" type="button" value="注册">
        <a href="index.jsp"><input type="button" value="返回"></a>
    </form>
</div>
</body>
</html>

