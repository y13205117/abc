<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <script>
        $(function () {
            $("#badd").click(function () {
                $("#badd").attr("disabled","disabled");
                var form=$("<form action='saveVitae' method='post' id='f1'></form>");
                var name=$("<span>姓名:</span><input name='name'><br>");
                var birth=$("<span>出生日期:</span><input name='birth'><br>");
                var sex=$("<span>性别:</span><input name='sex'><br>");
                var phone=$("<span>电话:</span><input name='phone'><br>");
                var address=$("<span>地址:</span><input name='address'><br>");
                var Email=$("<span>Email:</span><input name='email'><br>");
                var education=$("<span>学历:</span><input name='education'><br>");
                var add=$("<input type='button' id='add' value='添加简历'>");
                var ret=$("<input type='button' id='ret' value='返回'>");
                form.append(name);
                form.append(birth);
                form.append(sex);
                form.append(phone);
                form.append(address);
                form.append(Email);
                form.append(education);
                form.append(add);
                form.append(ret);
                $(document.body).append(form);
                $(document).on("click","#ret",function () {
                    $("#f1").remove();
                    $("#badd").removeAttr("disabled");
                    return;
                })
                $(document).on("click","#add",function () {
                    form.submit();
                })
            })
        })
    </script>
</head>
<body>
<table>
    <c:if test="${empty sessionScope.vitae}">
        <tr>抱歉你还没有个人简历</tr>
        <input id="badd" name="add" type="button" value="添加">
    </c:if>
    <c:if test="${!empty sessionScope.vitae}">
        <tr>
            姓名:<td>${sessionScope.vitae.name}</td>
            出生日期:<td>${sessionScope.vitae.birth}</td>
            性别:<td>${sessionScope.vitae.sex}</td>
            电话:<td>${sessionScope.vitae.phone}</td>
            地址:<td>${sessionScope.vitae.address}</td>
            Email:<td>${sessionScope.vitae.email}</td>
            学历:<td>${sessionScope.vitae.education}</td>
        </tr>
    </c:if>
</table>


</body>
</html>

