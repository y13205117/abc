$(function () {
    $("#badd").click(function () {
        $("#badd").attr("disabled", "disabled");
        var form = $("<form action='saveVitae' method='post' id='f1'></form>");
        var name = $("<span>姓名:</span><input name='name'><br>");
        var birth = $("<span>出生日期:</span><input name='birth'><br>");
        var sex = $("<span>性别:</span><input name='sex' type='radio'value='男'>男<input name='sex' type='radio'value='女'>女<br>");
        var phone = $("<span>电话:</span><input name='phone'><br>");
        var address = $("<span>地址:</span><input name='address'><br>");
        var Email = $("<span>Email:</span><input name='email'><br>");
        var education = $("<span>学历:</span><input name='education'><br>");
        var add = $("<input type='button' id='add' value='添加简历'>");
        var ret = $("<input type='button' id='ret' value='返回'>");
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
        $(document).on("click", "#ret", function () {
            $("#f1").remove();
            $("#badd").removeAttr("disabled");
            return;
        })
        $(document).on("click", "#add", function () {
            form.submit();
        })
    })
    $("input[name='upd']").click(function () {
        $("#d1").css("display","block");
        $("input[name='upd']").attr("disabled","disabled");
        $("input[name='del']").attr("disabled","disabled");
    })
    $("input[name='re']").click(function () {
        $("#d1").css("display","none");
        $("input[name='upd']").removeAttr("disabled");
        $("input[name='del']").removeAttr("disabled");
    })
    $("input[name='ud']").click(function () {
        $("#f2").submit();
    })
    $("input[name='del']").click(function () {
        if(confirm("确认删除？")){
            var vid=$(this).next().val();
            $.ajax({
                type:"post",
                url:"deleteVitae",
                data:"id="+vid,
                success:function (obj){
                    alert(obj);
                    if(obj=="删除成功"){
                        location.reload();
                    }
                }
            })
        }else{
            return;
        }
    })
})