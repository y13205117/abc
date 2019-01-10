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
    <title>招聘页面</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script src="js/recruit.js"></script>
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
</c:if>
部门:<select id="d1" name="did">
    <option>请选择</option>
    <c:forEach items="${sessionScope.department}" var="i">
        <option value="${i.id}">${i.name}</option>
    </c:forEach>
</select>
职位:<select id="j1" name="jid"></select><br>
<table >
    <tr>
        <td>招聘主题</td>
        <td>招聘人数</td>
        <td>招聘部门</td>
        <td>招聘职位</td>
        <td>发布时间</td>
        <td>查看内容</td>
    </tr>
</table>
<table id="t1">
    <c:if test="${empty sessionScope.recruit}">
        <tr>
            <td colspan="6">抱歉该职位还没有招聘</td>
        </tr>
    </c:if>
    <c:if test="${!empty sessionScope.recruit}">
        <c:forEach items="${sessionScope.recruit}" var="i">
            <tr>
                <td>${i.recruit.theme}</td>
                <td>${i.recruit.count}</td>
                <td>${i.department.name}</td>
                <td>${i.job.name}</td>
                <td>${i.recruit.releasetime}</td>
                <td><input class="qu" type="button" value="查看"><span>${i.recruit.id}</span></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<a href="index.jsp"><input type="button" value="返回主页"></a>
</body>
</html>

