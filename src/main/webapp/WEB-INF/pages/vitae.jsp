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
    <title>个人简历</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script src="js/vitae.js"></script>
</head>
<body>
<h4><a href="goOut">注销</a></h4>
<table border="1px">
    <c:if test="${empty sessionScope.vitae}">
        <tr>
            <td>抱歉你还没有简历</td>
            <td><input id="badd" type="button" value="添加简历"></td>
        </tr>
    </c:if>
    <c:if test="${!empty sessionScope.vitae}">
        <tr>
            <td colspan="3">个人信息</td>
        </tr>
        <tr>
            <td>姓名:${sessionScope.vitae.name}</td>
            <td>性别:${sessionScope.vitae.sex}</td>
            <td>出生日期:${sessionScope.vitae.birth}</td>
        </tr>
        <tr>
            <td colspan="3">联系方式</td>
        </tr>
        <tr>
            <td>电话:${sessionScope.vitae.phone}</td>
            <td colspan="2">Email:${sessionScope.vitae.email}</td>
        </tr>
        <tr>
            <td colspan="3">地址:${sessionScope.vitae.address}</td>
        </tr>
        <tr>
            <td colspan="3">学历:${sessionScope.vitae.education}</td>
        </tr>
        <tr>
            <td colspan="3"><input type="button" name="upd" value="修改">
                <input name="del" type="button" value="删除">
                <input name="id" hidden value="${sessionScope.vitae.id}">
            </td>
        </tr>
    </c:if>
</table>
<div id="d1" style="display: none">
    <form id="f2" method="post" action="updateVitae">
        姓名:<input name="name" value="${sessionScope.vitae.name}"><br>
        出生日期:<input name="birth" value="${sessionScope.vitae.birth}"><br>
        性别:<input name="sex" value="${sessionScope.vitae.sex}"><br>
        电话:<input name="phone" value="${sessionScope.vitae.phone}"><br>
        地址:<input name="address" value="${sessionScope.vitae.address}"><br>
        Email:<input name="email" value="${sessionScope.vitae.email}"><br>
        学历:<input name="education" value="${sessionScope.vitae.education}"><br>
        <input name="id" hidden value="${sessionScope.vitae.id}">
        <input name="uid" hidden value="${sessionScope.vitae.uid}">
        <input name="ud" type="button" value="修改">
        <input name="re" type="button" value="返回">
    </form>
</div>
<a href="index.jsp"><input type="button" value="返回主页"></a>
</body>
</html>

