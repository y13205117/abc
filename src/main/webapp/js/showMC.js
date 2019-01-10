$(function () {
    $(".go").click(function () {
        var mid=$(this).next().next().html();
        $.ajax({
            type:"post",
            url:"goMCV",
            data:{"mid":mid},
            success:function(obj){
                alert(obj);
                location.reload();
            }
        })
    })
    $(".no").click(function () {
        var mid=$(this).next().html();
        $.ajax({
            type:"post",
            url:"notGoMCV",
            data:{"mid":mid},
            success:function(obj){
                alert(obj);
                location.reload();
            }
        })
    })
})