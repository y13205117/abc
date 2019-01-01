$(function () {
    $("#d1").change(function () {
        $("#j1").html("");
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
        var div=$("<div id='div1'></div>");
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
        var div=$("<div id='div2'></div>");
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
                    for (var i in obj){
                        var tr=$("<tr></tr>");
                        var td1=$("<td>员工编号:</td>");
                        var td2=$("<td>员工姓名:</td>");
                        var td3=$("<td>员工状态:</td>");
                        var td4=$("<td>员工等级:</td>");
                        var td5=$("<td>员工绩效:</td>");
                        td1.html(obj[i].employee.id);
                        td2.html(obj[i].vitae.name);
                        td3.html(obj[i].employee.state);
                        td4.html(obj[i].employee.type);
                        td5.html(obj[i].employee.performance);
                        tr.append(td1);
                        tr.append(td2);
                        tr.append(td3);
                        tr.append(td4);
                        tr.append(td5);
                        tb.append(tr);
                    }
                }else {
                    var tr=$("<tr></tr>");
                    var td=$("<td>抱歉本职位还没有员工</td>");
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
})