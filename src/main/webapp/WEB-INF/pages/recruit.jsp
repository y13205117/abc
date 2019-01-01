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
    <%--<script src="js/recruit.js"></script>--%>
    <script>
        $(function () {
            $("input[name='qu']").click(function () {
                $("input[name='qu']").attr("disabled","disabled");
                var tf=$(this).parent();
                var id=$(this).next().html();
                $.ajax({
                    type:"post",
                    url:"quRecruit",
                    data:"id="+id,
                    success:function (obj){
                        var tr1=$("<tr></tr>");
                        var td1=$("<td colspan='4'>obj</td>");
                        var td2=$("<td><input id='send' type='button' value='投递简历'><input id='re' type='button' value='返回'></td>");
                        tr1.append(td1);
                        tr1.append(td2);
                        tr1.appendTo(tf);
                        $(document).on("click", "#re", function () {
                            tr1.remove();
                            $("input[name='qu']").removeAttr("disabled");
                            return;
                        })
                        $(document).on("click", "#send", function () {
                            $.ajax({
                                type:"post",
                                url:"sendRecruit",
                                data:"id="+id,
                                success:function (obj){
                                    alert(obj);
                                }
                            })
                        })
                    }
                })
            })
        })
    </script>
</head>
<body>
<table id="t1">
    <tr>
        <td>招聘主题</td>
        <td>招聘人数</td>
        <td>招聘要求</td>
        <td>发布时间</td>
        <td>查看内容</td>
    </tr>
    <c:forEach items="${sessionScope.recruit}" var="i">
        <tr>
            <td>${i.recruit.theme}</td>
            <td>${i.recruit.count}</td>
            <td>${i.recruit.require}</td>
            <td>${i.recruit.releasetime}</td>
            <td><input name="qu" type="button" value="查看"><span>${i.recruit.id}</span></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

