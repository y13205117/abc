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
                        j.html(obj[i]);
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
})