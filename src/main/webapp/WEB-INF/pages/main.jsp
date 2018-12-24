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
    <script>
        $(function () {
            $("input[type='button']").click(function () {
                var name=$("input[name='name']").val();
                var pass=$("input[name='pass']").val();
                if(name==""){
                    alert("账号不能空");
                    return;
                }else if(pass==""){
                    alert("密码不能为空");
                    return;
                }
                $("#f1").submit();
            })
        })
    </script>
</head>
<body>
<c:if test="${empty sessionScope.user}">
    <form id="f1" method="post" action="login">
        用户名:<input name="name" type="text">
        密码:<input type="password" name="pass">
        <input type="button" value="登录">
        <a href="goRegister">注册</a>
    </form>
</c:if>
<h4>欢迎${sessionScope.user.name}登陆</h4>

</body>
</html>

