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
    <title>面试查询</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script src="js/showMC.js"></script>
</head>
<body>
<h4><a href="goOut">注销</a></h4>
<table>
    <tr>
        <td colspan="4">面试通知</td> 
    </tr>
    <tr>
        <c:if test="${empty sessionScope.memberShowCV}">
            <td colspan="4">抱歉，您还没有收到面试邀请</td>
        </c:if>
        <c:if test="${!empty sessionScope.memberShowCV}">
            <c:forEach items="${sessionScope.memberShowCV}" var="i">
                <td colspan="2">带好相应物品请于下周一到XXX路XX楼找XX小姐/先生</td>
                <td colspan="2"><input class="go" type="button" value="接受邀请"><input class="no" type="button" value="拒接邀请"><span>${i.id}</span></td>
            </c:forEach>
        </c:if>
    </tr>
</table>
</body>
</html>

