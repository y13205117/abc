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
    <title>员工界面</title>
    <link href="css/employee.css" rel="stylesheet">
    <script src="js/jquery-3.1.0.js"></script>
    <script src="js/employee.js"></script>
    <script>

    </script>
</head>
<body>
<h4>欢迎${sessionScope.emp.vitae.name}登录<a href="goOut">注销</a></h4>
<ul>
    <li id="eGC">考勤打卡</li>
    <li id="eV">个人信息</li>
    <li id="eM">通讯录</li>
    <li id="eT">查看培训</li>
    <li id="eA">查看奖惩</li>
    <li id="eL">申请离职</li>
    <li id="eC">查看薪资</li>
</ul>
<div id="dGC">
    <ul id="clock">
        <li id="sec"></li>
        <li id="hour"></li>
        <li id="min"></li>
    </ul>
    <input id="office" type="button" value="上班打卡"><input id="after" type="button" value="下班打卡">
</div>
<div id="dV">
    <table>
        <tr>
            <td>员工编号</td>
            <td>员工姓名</td>
            <td>所属部门</td>
            <td>所属岗位</td>
            <td>入职时间</td>
            <td>岗位状态</td>
            <td>绩效奖励</td>
        </tr>
        <tr>
            <td>${sessionScope.emp.employee.id}</td>
            <td>${sessionScope.emp.vitae.name}</td>
            <td>${sessionScope.emp.department.name}</td>
            <td>${sessionScope.emp.job.name}</td>
            <td>${sessionScope.emp.employee.entrytime}</td>
            <c:if test="${sessionScope.emp.employee.state==1}">
                <td>正式员工</td>
            </c:if>
            <c:if test="${sessionScope.emp.employee.state==2}">
                <td>试用期</td>
            </c:if>
            <td>${sessionScope.emp.employee.performance}</td>
        </tr>
    </table>
</div>
<div id="dM">
    <table>
        <tr>
            <td>姓名</td>
            <td>部门</td>
            <td>职位</td>
            <td colspan="2">电话</td>
            <td colspan="2">Email</td>
        </tr>
        <c:forEach items="${sessionScope.employee}" var="i">
            <tr>
                <td>${i.vitae.name}</td>
                <td>${i.department.name}</td>
                <td>${i.job.name}</td>
                <td colspan="2">${i.vitae.phone}</td>
                <td colspan="2">${i.vitae.email}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="dT">
    <table>
        <tr>
            <td colspan="2">培训内容</td>
            <td colspan="2">培训要求</td>
            <td colspan="2">开始时间</td>
            <td colspan="2">结束时间</td>
        </tr>
        <c:if test="${empty sessionScope.train}">
            <tr>
                <td colspan="8">您目前没有培训</td>
            </tr>
        </c:if>
        <c:if test="${!empty sessionScope.train}">
            <script language='javascript'>alert('您培训通知，请及时查阅')</script>
            <c:forEach items="${sessionScope.train}" var="i">
                <tr>
                    <td colspan="2">${i.content}</td>
                    <td colspan="2">${i.required}</td>
                    <td colspan="2">${i.starttime}</td>
                    <td colspan="2">${i.endtime}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
<div id="dA">
    <table>
        <tr>
            <td>奖惩原因</td>
            <td>奖惩金额</td>
            <td>奖惩时间</td>
            <td>是否结算</td>
        </tr>
        <c:if test="${empty sessionScope.awardRecord}">
            <tr>
                <td colspan="4">您没有奖惩记录</td>
            </tr>
        </c:if>
        <c:if test="${!empty sessionScope.awardRecord}">
            <c:forEach items="${sessionScope.awardRecord}" var="i">
                <tr>
                    <td>${i.cause}</td>
                    <td>${i.money}</td>
                    <td>${i.time}</td>
                    <c:if test="${empty i.cid}">
                        <td>未结算</td>
                    </c:if>
                    <c:if test="${!empty i.cid}">
                        <td>已结算</td>
                    </c:if>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
<div id="dC">
    <table>
        <tr>
            <td>员工编号</td>
            <td>是否复议</td>
            <td>复议原因</td>
            <td>结算时间</td>
            <td>实发薪资</td>
        </tr>
        <c:forEach items="${sessionScope.calculate}" var="i">
            <tr>
                <td>${i.id}</td>
                <c:if test="${i.reconsider==0}">
                    <td>未提出复议</td>
                </c:if>
                <c:if test="${i.reconsider==1}">
                    <td>以提交复议</td>
                </c:if>
                <c:if test="${i.reconsider==2}">
                    <td>以完成复议</td>
                </c:if>
                <td>${i.cause}</td>
                <td>${i.time}</td>
                <td>${i.realsalay}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="dL">
    <form id="fL" method="post" action="addlea">
        原因:<textarea name="cause"></textarea>
        <input name="lea" type="submit" value="提交报告">
    </form>
</div>
</body>
</html>

