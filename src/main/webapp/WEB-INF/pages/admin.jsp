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
    <title>管理员界面</title>
    <script src="js/jquery-3.1.0.js"></script>
    <%--<script>--%>
        <%--$(function () {--%>
            <%--$("#d1").change(function () {--%>
                <%--$("#j1").html();--%>
                <%--$.ajax({--%>
                    <%--type:"post",--%>
                    <%--url:"",--%>
                    <%--data:"",--%>
                    <%--success:function(obj){--%>

                    <%--}--%>
                <%--})--%>
            <%--})--%>
        <%--})--%>
    <%--</script>--%>
</head>
<body>
<ul>
    <li>查看部门</li>
    <li>查看员工</li>
    <li>薪资结算</li>
    <li>查看考勤</li>
    <li>查看培训</li>
    <li>查看招聘</li>
    <li>查看奖惩</li>
</ul>
<c:if test="${empty sessionScope.department}">
    抱歉还没有任何部门
</c:if>
<c:if test="${!empty sessionScope.department}">
    部门:<select id="d1">
    <c:forEach items="${sessionScope.department}" var="i">
        <option>${i}</option>
    </c:forEach>
    </select>
    职位:<select id="j1"></select>
</c:if>
</body>
</html>

