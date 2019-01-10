$(function () {
    $("#d1").change(function () {
        $("#j1").html("");
        $("#t1").html("");
        var did=$("#d1").val();
        $.ajax({
            type:"post",
            url:"queryJob",
            data:"did="+did,
            success:function(obj){
                if(obj.length>0){
                    for (var i in obj) {
                        var j=$("<option></option>");
                        j.html(obj[i].name);
                        j.val(obj[i].id);
                        $("#j1").append(j);
                    }
                }else{
                    var j=$("<option>抱歉该部门下还没有职位</option>");
                    $("#j1").append(j);
                }
            }
        })
    })
    $("#addD").click(function () {
        $("#addD").attr("disabled","disabled");
        $("#addJ").attr("disabled","disabled");
        var div=$("<div id='div1' style='display: block'></div>");
        var vd=$("<span>部门名称:</span><input id='dn' name='name'><br>");
        var que=$("<input id='qu' type='button'value='确认'>");
        var res=$("<input id='re' type='button'value='取消'>");
        div.append(vd);
        div.append(que);
        div.append(res);
        $(document.body).append(div);
        $(document).on("click", "#re", function () {
            $("#div1").remove();
            $("#addD").removeAttr("disabled");
            $("#addJ").removeAttr("disabled");
            return;
        })
        $(document).on("click", "#qu", function () {
            var name=$("#dn").val();
            $.ajax({
                type:"post",
                url:"saveDEP",
                data:"name="+name,
                success:function(obj){
                    alert(obj);
                    if(obj=="添加成功"){
                        location.reload();
                    }
                }
            })
        })
    })
    $("#addJ").click(function () {
        var did=$("#d1").val();
        $("#addD").attr("disabled","disabled");
        $("#addJ").attr("disabled","disabled");
        var div=$("<div id='div2' style='display: block'></div>");
        $("#div2").css("display","block");
        var vd=$("<span>职位名称:</span><input id='jn' name='name'><br>");
        var que=$("<input id='jqu' type='button'value='确认'>");
        var res=$("<input id='jre' type='button'value='取消'>");
        div.append(vd);
        div.append(que);
        div.append(res);
        $(document.body).append(div);
        $(document).on("click", "#jre", function () {
            $("#div2").remove();
            $("#addD").removeAttr("disabled");
            $("#addJ").removeAttr("disabled");
            return;
        })
        $(document).on("click", "#jqu", function () {
            var name=$("#jn").val();
            $.ajax({
                type:"post",
                url:"saveJob",
                data:{"name":name,"did":did},
                success:function(obj){
                    alert(obj);
                    if(obj=="添加成功"){
                        location.reload();
                    }
                }
            })
        })
    })
    $("#j1").change(function () {
        var tb=$("#t1");
        tb.html("");
        var did=$("#d1").val();
        var jid=$("#j1").val();
        $.ajax({
            type:"post",
            url:"queryEmp",
            data:{"did":did,"jid":jid},
            success:function(obj){
                if(obj.length>0){
                    var tr=$("<tr></tr>");
                    var td1=$("<td>员工编号</td>");
                    var td2=$("<td>员工姓名</td>");
                    var td3=$("<td>员工状态</td>");
                    var td4=$("<td>员工等级</td>");
                    var td5=$("<td>员工绩效</td>");
                    tr.append(td1);
                    tr.append(td2);
                    tr.append(td3);
                    tr.append(td4);
                    tr.append(td5);
                    tb.append(tr);
                    for (var i in obj){
                        var tr1=$("<tr></tr>");
                        var td6=$("<td></td>");
                        var td7=$("<td></td>");
                        var td9=$("<td></td>");
                        var td0=$("<td></td>");
                        td6.html(obj[i].employee.id);
                        td7.html(obj[i].vitae.name);
                        if(obj[i].state ==1){
                            var td8=$("<td>正式员工</td>");
                        }else if(obj[i].state ==2){
                            var td8=$("<td>试用期</td>");
                        }else if(obj[i].state ==3){
                            var td8=$("<td>兼职</td>");
                        }
                        td9.html(obj[i].employee.type)
                        td0.html(obj[i].employee.performance)
                        tr1.append(td6);
                        tr1.append(td7);
                        tr1.append(td8);
                        tr1.append(td9);
                        tr1.append(td0);
                        tb.append(tr1);
                    }
                }else {
                    var tr=$("<tr></tr>");
                    var td=$("<td colspan='5'>抱歉本职位还没有员工</td>");
                    tr.append(td);
                    tb.append(tr);
                }
            }
        })
    })
    $("#qE").click(function () {
        $("li").removeAttr("disabled");
        $("div").css("display","none");
        $("#dE").css("display","block");
        $("#qE").attr("disabled","disabled");
    })
    $("#qGC").click(function () {
        $("li").removeAttr("disabled");
        $("div").css("display","none");
        $("#dGC").css("display","block");
        $("#qGC").attr("disabled","disabled");
    })
    $("#qT").click(function () {
        $("li").removeAttr("disabled");
        $("div").css("display","none");
        $("#dT").css("display","block");
        $("#qT").attr("disabled","disabled");
    })
    $("#qR").click(function () {
        $("li").removeAttr("disabled");
        $("div").css("display","none");
        $("#dR").css("display","block");
        $("#qR").attr("disabled","disabled");
    })
    $("#qA").click(function () {
        $("li").removeAttr("disabled");
        $("div").css("display","none");
        $("#dA").css("display","block");
        $("#qA").attr("disabled","disabled");
    })
    $("#d2").change(function () {
        $("#j2").html("");
        var did=$("#d2").val();
        $.ajax({
            type:"post",
            url:"queryJob",
            data:"did="+did,
            success:function(obj){
                if(obj.length>0){
                    for (var i in obj) {
                        var j=$("<option></option>");
                        j.html(obj[i].name);
                        j.val(obj[i].id);
                        $("#j2").append(j);
                    }
                }else{
                    var j=$("<option>抱歉该部门下还没有职位</option>");
                    $("#j2").append(j);
                }
            }
        })
    })
    $("#addR").click(function () {
        $("#addDiv").css("display","block");
    })
    $("input[name='se']").click(function () {
        $("#sF").submit();
    })
    $("input[name='rs']").click(function () {
        $("#addDiv").css("display","none");
    })
    $("input[name='query']").click(function () {
        var mid=$(this).next().html();
        var tb=$("#MTB");
        $.ajax({
            type:"post",
            url:"queryMCV",
            data:{"mid":mid},
            success:function(obj){
                if(obj.length>0){
                    var tr=$("<tr></tr>");
                    var td1=$("<td>简历编号</td>");
                    var td2=$("<td>是否阅读</td>");
                    var td3=$("<td colspan='3'>投递时间</td>");
                    var td4=$("<td>查看简历</td>");
                    tr.append(td1);
                    tr.append(td2);
                    tr.append(td3);
                    tr.append(td4);
                    tb.append(tr);
                    for (var i in obj){
                        var tr1=$("<tr></tr>");
                        td6=$("<td></td>");
                        td6.html(obj[i].vid);
                        if(obj[i].state==0){
                            td7=$("<td>未读</td>");
                        }else if(obj[i].state==1){
                            td7=$("<td>已读</td>");
                        }else {
                            td7=$("<td>已发面试邀请</td>");
                        }
                        td8=$("<td colspan='3'></td>");
                        td8.html(obj[i].time);
                        td9=$("<td><input class='look' type='button' value='查看简历'></td>");
                        var s=$("<span style='display: none'></span>");
                        s.html(obj[i].vid);
                        td9.append(s);
                        tr1.append(td6);
                        tr1.append(td7);
                        tr1.append(td8);
                        tr1.append(td9);
                        tb.append(tr1);
                        $(document).on("click", ".look", function (){
                            $(this).attr("disabled","disabled");
                            var id=$(this).next().html();
                            var tb=$("#MTB");
                            $.ajax({
                                type:"post",
                                url:"quVitae",
                                data:{"id":id},
                                success:function(ob){
                                    var tr2=$("<tr></tr>");
                                    var td1=$("<td></td>");
                                    td1.html("姓名:"+ob.name);
                                    var td2=$("<td></td>");
                                    td2.html("性别:"+ob.sex);
                                    var td3=$("<td></td>");
                                    td3.html("出身日期:"+ob.birth);
                                    var td4=$("<td></td>");
                                    td4.html("电话:"+ob.phone);
                                    var td5=$("<td></td>");
                                    td5.html("Email:"+ob.email);
                                    var td6=$("<td></td>");
                                    td6.html("地址:"+ob.address);
                                    var td7=$("<td></td>");
                                    td7.html("学历:"+ob.education);
                                    var td8=$("<td><input class='inv' type='button' value='邀请面试'><input class='re' type='button' value='返回'></td>");
                                    tr2.append(td1);
                                    tr2.append(td2);
                                    tr2.append(td3);
                                    tr2.append(td4);
                                    tr2.append(td5);
                                    tr2.append(td6);
                                    tr2.append(td7);
                                    tr2.append(td8);
                                    tb.append(tr2);
                                    $(document).on("click", ".re", function (){
                                        tr2.remove();
                                        $(".look").removeAttr("disabled");
                                        $.ajax({
                                            type:"post",
                                            url:"updateMCV",
                                            data:{"mid":mid},
                                            success:function(){
                                            }
                                        })
                                        return;
                                    })
                                    $(document).on("click", ".inv", function (){
                                        $.ajax({
                                            type:"post",
                                            url:"invMCV",
                                            data:{"mid":mid},
                                            success:function(obj){
                                                alert(obj);
                                                return;
                                            }
                                        })
                                    })
                                }
                            })
                        })
                    }
                }else {
                    var tr=$("<tr></tr>");
                    var td=$("<td colspan='5'>抱歉本职位还没有人投递简历</td>");
                    tr.append(td);
                    tb.append(tr);
                }
            }
        })
    })
})