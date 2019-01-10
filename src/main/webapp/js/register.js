$(function () {
    $("input[name='name']").blur(function () {
        var name=$("input[name='name']").val();
        var reg=/^[a-zA-Z]\w{7,17}$/;
        if(name==""){
            $("#us").css("color","red");
            $("#us").text("账号不能为空");
        }else {
            if(!reg.test(name)){
                $("#us").css("color","red");
                $("#us").text("账号以字母开头，长度在8~18之间");
            }else{
                $.ajax({
                    type:"post",
                    url:"myUnique",
                    data:{name:name},
                    success:function (obj) {
                        if(obj=="true"){
                            $("#us").css("color","greenyellow");
                            $("#us").text("√");
                        }else{
                            $("#us").css("color","red");
                            $("#us").text("用户名已存在");
                        }
                    }
                })
            }
        }
    })
    $("input[name='pass']").blur(function () {
        var pass=$("input[name='pass']").val();
        var reg=/^[a-zA-Z]\w{7,19}$/;
        if(pass==""){
            $("#up").css("color","red");
            $("#up").text("密码不能为空");
        }else {
            if(!reg.test(pass)){
                $("#up").css("color","red");
                $("#up").text("密码以字母开头，长度在8~20之间");
            }else{
                $("#up").css("color","greenyellow");
                $("#up").text("√");
            }
        }
    })
    $("input[name='again']").blur(function () {
        var pass=$("input[name='pass']").val();
        var again=$("input[name='again']").val();
        if(pass==again){
            $("#ag").css("color","greenyellow");
            $("#ag").text("√");
        }else{
            $("#ag").css("color","red");
            $("#ag").text("两次密码不一致");
        }
    })
    $("input[name='reg']").click(function () {
        var a=$("#us").text();
        var b=$("#up").text();
        var c=$("#ag").text();
        if(a=="√" && b=="√" && c=="√"){
            $("#f1").submit();
        }else{
            alert("信息有误")
        }
    })
    $("input[name='login']").click(function () {
        var name=$("input[name='name']").val();
        var pass=$("input[name='pass']").val();
        if(name==""){
            alert("账号不能空");
            return;
        }else if(pass==""){
            alert("密码不能为空");
            return;
        }
        $("#f1").submit();
    })
})