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
                        td9.html(obj[i].employee.type);
                        td0.html(obj[i].employee.performance);
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
    $("#qC").click(function () {
        $("li").removeAttr("disabled");
        $("div").css("display","none");
        $("#dC").css("display","block");
        $("#qC").attr("disabled","disabled");
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
    $("#addE").click(function () {
        var j=$("#j1").val();
        var tb=$("#t1");
        if(j==""){
            alert("您还没有选职位");
            return;
        }
        tb.html("");
        $.ajax({
            type:"post",
            url:"queryRec",
            data:{"jid":j},
            success:function(obj){
                var tr=$("<tr></tr>");
                var td1=$("<td>简历编号</td>");
                var td2=$("<td>简历姓名</td>");
                var td3=$("<td>操作简历</td>");
                tr.append(td1);
                tr.append(td2);
                tr.append(td3);
                tb.append(tr);
                if(obj.length>0){
                    for(var i in obj){
                        $.ajax({
                            type:"post",
                            url:"quVitae",
                            data:{"id":obj[i].vid},
                            success:function(ob){
                                var tr1=$("<tr></tr>");
                                var td4=$("<td></td>");
                                td4.html(ob.id);
                                var td5=$("<td></td>");
                                td5.html(ob.name);
                                var td6=$("<td><input class='act' type='button' value='入职'></td>");
                                $(document).on("click", ".act", function (){
                                    $.ajax({
                                        type:"post",
                                        url:"actEmp",
                                        data:{"vid":obj[i].vid,"jid":j,"mid":obj[i].id},
                                        success:function(obj){
                                            alert(obj);
                                            location.reload();
                                        }
                                    })
                                })
                                tr1.append(td4);
                                tr1.append(td5);
                                tr1.append(td6);
                                tb.append(tr1);
                            }
                        })
                    }
                }else{
                    var tr1=$("<tr></tr>");
                    var td4=$("<td>抱歉没有人来面试</td>");
                    tr1.append(td4);
                    tb.append(tr1);
                }
            }
        })
    })
    $("#upD").click(function () {
        $("#upD").attr("disabled","disabled");
        var d1=$("#d1").val();
        if(d1==="请选择"){
            alert("请选择部门");
            $("#upD").removeAttr("disabled");
            return;
        }
        $.ajax({
            type:"post",
            url:"quDep",
            data:{"id":d1},
            success:function(obj){
                var div=$("<div id='div3' style='display: block'></div>");
                var vd=$("<span>部门名称:</span><input id='dns' name='name'><br>");
                vd.val(obj);
                var que=$("<input id='que' type='button'value='确认'>");
                var res=$("<input id='ret' type='button'value='取消'>");
                div.append(vd);
                div.append(que);
                div.append(res);
                $(document.body).append(div);
                $(document).on("click", "#ret", function () {
                    div.remove();
                    $("#upD").removeAttr("disabled");
                    return;
                })
                $(document).on("click", "#que", function () {
                    var name=$("#dns").val();
                    $.ajax({
                        type:"post",
                        url:"upDEP",
                        data:{"name":name,"id":d1},
                        success:function(obj){
                            alert(obj);
                            location.reload();
                        }
                    })
                })
            }
        })
    })
    $("#upJ").click(function () {
        $("#upJ").attr("disabled","disabled");
        var j1=$("#j1").val();
        if(j1===null){
            alert("请选择职位");
            $("#upJ").removeAttr("disabled");
            return;
        }
        $.ajax({
            type:"post",
            url:"quJob",
            data:{"id":j1},
            success:function(obj){
                var div=$("<div id='div4' style='display: block'></div>");
                var vd=$("<span>职位名称:</span><input id='dnJ' name='name'><br>");
                vd.val(obj);
                var que=$("<input id='quJ' type='button'value='确认'>");
                var res=$("<input id='reJ' type='button'value='取消'>");
                div.append(vd);
                div.append(que);
                div.append(res);
                $(document.body).append(div);
                $(document).on("click", "#reJ", function () {
                    div.remove();
                    $("#upJ").removeAttr("disabled");
                    return;
                })
                $(document).on("click", "#quJ", function () {
                    var name=$("#dns").val();
                    $.ajax({
                        type:"post",
                        url:"upJob",
                        data:{"name":name,"id":j1},
                        success:function(obj){
                            alert(obj);
                            location.reload();
                        }
                    })
                })
            }
        })
    })
    $("#deD").click(function () {
        if(confirm("确认删除？")){
            var d1 = $("#d1").val();
            if (d1 === "请选择") {
                alert("请选择部门");
                return;
            }
            $.ajax({
                type:"post",
                url:"deDep",
                data:{"id":d1},
                success:function(obj){
                    alert(obj);
                    location.reload();
                }
            })
        }else{
            return;
        }
    })
    $("#deJ").click(function () {
        if(confirm("确认删除？")){
            var j1 = $("#j1").val();
            if(j1===null){
                alert("请选择职位");
                return;
            }
            $.ajax({
                type:"post",
                url:"deJob",
                data:{"id":j1},
                success:function(obj){
                    alert(obj);
                    location.reload();
                }
            })
        }else{
            return;
        }
    })
    $("#addT").click(function () {
        $("#p1").html("");
        $(this).attr("disabled","disabled");
        var f=$("<form action='addTrain' method='post'></form>");
        var c=$("<span>内容:</span><input name='content'><br>");
        var r=$("<span>要求:</span><input name='required'><br>");
        var s=$("<span>开始:</span><input class='date' name='starttime'><br>");
        var e=$("<span>结束:</span><input class='date' name='endtime'><br>");
        var b=$("<input id='quT' type='button' value='确认'><input id='reT' type='button' value='取消'>");
        f.append(c);
        f.append(r);
        f.append(s);
        f.append(e);
        f.append(b);
        $(document).on("click",".date",function () {
            $(this).ECalendar({
                type:"time",   //模式，time: 带时间选择; date: 不带时间选择;
                stamp : false,   //是否转成时间戳，默认true;
                offset:[0,2],   //弹框手动偏移量;
                format:"yyyy年mm月dd日",   //时间格式 默认 yyyy-mm-dd hh:ii;
                skin:3,   //皮肤颜色，默认随机，可选值：0-8,或者直接标注颜色值;
                step:10,   //选择时间分钟的精确度;
                callback:function(v,e){} //回调函数
            })
        })
        $("#p1").append(f);
        $(document).on("click","#quT",function (){
            f.submit();
        })
        $(document).on("click","#reT",function (){
            f.remove();
            $("#addT").removeAttr("disabled");
            return;
        })
    })
    $(".deT").click(function () {
        var t=$(this).next().html();
        $.ajax({
            type:"post",
            url:"delTrain",
            data:{"id":t},
            success:function(obj){
                alert(obj);
                location.reload();
            }
        })
    })
    $("#deE").click(function () {
        $("#t1").html("");
        $.ajax({
            type:"post",
            url:"quLea",
            data:"",
            success:function(obj){
                var tr=$("<tr></tr>");
                var td1=$("<td>员工编号</td>");
                var td2=$("<td>离职原因</td>");
                var td3=$("<td>申请时间</td>");
                var td4=$("<td>操作</td>");
                tr.append(td1);
                tr.append(td2);
                tr.append(td3);
                tr.append(td4);
                $("#t1").append(tr);
                for (var i in obj) {
                    var tr1=$("<tr></tr>");
                    var td5=$("<td></td>");
                    td5.html(obj[i].eid);
                    var td6=$("<td></td>");
                    td5.html(obj[i].cause);
                    var td7=$("<td></td>");
                    td5.html(obj[i].time);
                    var td8=$("<td><input class='.agg' type='button' value='同意'></td>");
                    tr1.append(td5);
                    tr1.append(td6);
                    tr1.append(td7);
                    tr1.append(td8);
                    $("#t1").append(tr1);
                    $(document).on("click",".agg",function () {
                        $.ajax({
                            type:"post",
                            url:"upLea",
                            data:{"eid":obj[i].eid},
                            success:function(obj){
                                alert(obj);
                            }
                        })
                    })
                }
            }
        })
    })
    $(".counter").click(function () {
        var eid=$(this).next().html();
        $.ajax({
            type:"post",
            url:"addCal",
            data:{"eid":eid},
            success:function(obj){

            }
        })
    })
})