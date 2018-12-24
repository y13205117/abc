$(function () {
    $("input[type='button']").click(function () {
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