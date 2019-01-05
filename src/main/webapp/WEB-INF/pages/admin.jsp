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
    <script src="js/admin.js">

    </script>
    <style>
        div {
            display: none;
        }
    </style>
</head>
<body>
<ul>
    <li id="qE">查看员工</li>
    <li id="qGC">查看考勤</li>
    <li id="qT">查看培训</li>
    <li id="qR">查看招聘</li>
    <li id="qA">查看奖惩</li>
    <li>薪资结算</li>
</ul>
<div id="dE">
    <input id="addD" type="button" value="添加部门"><input id="addJ" type="button" value="添加职位">
    <input id="upD" type="button" value="修改部门"><input id="upJ" type="button" value="修改职位">
    <input id="deD" type="button" value="删除部门"><input id="deJ" type="button" value="删除职位">
    <input id="addE" type="button" value="添加员工"><input id="deE" type="button" value="员工离职"><br>
    <c:if test="${empty sessionScope.department}">
        抱歉还没有任何部门
    </c:if>
    <c:if test="${!empty sessionScope.department}">
        部门:<select id="d1" name="did">
        <option>请选择</option>
        <c:forEach items="${sessionScope.department}" var="i">
            <option value="${i.id}">${i.name}</option>
        </c:forEach>
        </select>
        职位:<select id="j1" name="jid"></select><br>
    </c:if>
    <table id="t1" border="1px"></table>
</div>
<div id="dGC">这里是考勤</div>
<div id="dT">这里是培训</div>
<div id="dR">
    <input id="addR" type="button" value="发布招聘"><br>
    <c:if test="${empty sessionScope.recruit}">
        抱歉还没有招聘
    </c:if>
    <c:if test="${!empty sessionScope.recruit}">
        <table id="MTB">
            <tr>
                <td>招聘主题</td>
                <td>招聘人数</td>
                <td>招聘部门</td>
                <td>招聘职位</td>
                <td>发布时间</td>
                <td>查看简历</td>
            </tr>
            <c:forEach items="${sessionScope.recruit}" var="i">
                <tr>
                    <td>${i.recruit.theme}</td>
                    <td>${i.recruit.count}</td>
                    <td>${i.department.name}</td>
                    <td>${i.job.name}</td>
                    <td>${i.recruit.releasetime}</td>
                    <td><input name="query" type="button" value="查看简历"><span>${i.recruit.id}</span></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <div id="addDiv" style="display: none">
        <form id="sF" action="amdinSendRecruit" method="post">
            <c:if test="${empty sessionScope.department}">
                抱歉还没有任何部门
            </c:if>
            <c:if test="${!empty sessionScope.department}">
                选择部门:<select id="d2" name="did">
                <option>请选择</option>
                <c:forEach items="${sessionScope.department}" var="i">
                    <option value="${i.id}">${i.name}</option>
                </c:forEach>
                </select><br>
                选择职位:<select id="j2" name="jid"></select><br>
            </c:if>
            招聘主题:<input name="theme"><br>
            招聘内容:<textarea name="content"></textarea><br>
            招聘人数:<input type="number" min="1" value="1" name="count"><br>
            <input name="se" type="button" value="确认发布"><input name="rs" type="button" value="返回">
        </form>
    </div>
</div>
<div id="dA">这里是奖惩</div>
<div></div>
</body>
</html>

