$(function () {
    function qu(o) {
        $(o).attr("disabled", "disabled");
        var tf = $(o).parent().parent().parent();
        var id = $(o).next().html();
        $.ajax({
            type: "post",
            url: "quRecruit",
            data: "id=" + id,
            success: function (obj) {
                var tr1 = $("<tr></tr>");
                var td1 = $("<td colspan='5'></td>");
                td1.html(obj);
                var td2 = $("<td><input id='send' type='button' value='投递简历'><input id='re' type='button' value='返回'></td>");
                tr1.append(td1);
                tr1.append(td2);
                tr1.appendTo(tf);
                $(document).on("click", "#re", function () {
                    tr1.remove();
                    $(o).removeAttr("disabled");
                    return;
                })
                $(document).on("click", "#send", function () {
                    $.ajax({
                        type: "post",
                        url: "sendRecruit",
                        data: "id=" + id,
                        success: function (obj) {
                            alert(obj);
                        }
                    })
                })
            }
        })
    };
    $(".qu").click(function () {
       qu(this);
    })
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
                    var j=$("<option>抱歉该部门下还没有招聘</option>");
                    $("#j1").append(j);
                }
            }
        })
    })
    $("#j1").change(function () {
        var tb=$("#t1");
        tb.html("");
        var did=$("#d1").val();
        var jid=$("#j1").val();
        $.ajax({
            type:"post",
            url:"queryRecruit",
            data:{"did":did,"jid":jid},
            success:function(obj) {
                $("#t1").load(location.href+" #t1");
                if(obj=="ok"){
                    $(document).on("click", ".qu", function (){
                        qu(this);
                    })
                }
            }
        })
    })
})