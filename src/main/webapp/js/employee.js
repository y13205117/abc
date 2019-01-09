$(function() {
    setInterval( function() {
        var seconds = new Date().getSeconds();
        var sdegree = seconds * 6;
        var srotate = "rotate(" + sdegree + "deg)";
        $("#sec").css({"-moz-transform" : srotate, "-webkit-transform" : srotate});
    }, 1000 );
    setInterval( function() {
        var hours = new Date().getHours();
        var mins = new Date().getMinutes();
        var hdegree = hours * 30 + (mins / 2);
        var hrotate = "rotate(" + hdegree + "deg)";
        $("#hour").css({"-moz-transform" : hrotate, "-webkit-transform" : hrotate});
    }, 1000 );
    setInterval( function() {
        var mins = new Date().getMinutes();
        var mdegree = mins * 6;
        var mrotate = "rotate(" + mdegree + "deg)";
        $("#min").css({"-moz-transform" : mrotate, "-webkit-transform" : mrotate});
    }, 1000 );
    $("#eGC").click(function () {
        $("li").removeAttr("disabled");
        $("div").css("display","none");
        $("#dGC").css("display","block");
        $("#eGC").attr("disabled","disabled");
    })
    $("#eV").click(function () {
        $("li").removeAttr("disabled");
        $("div").css("display","none");
        $("#dV").css("display","block");
        $("#eV").attr("disabled","disabled");
    })
    $("#eM").click(function () {
        $("li").removeAttr("disabled");
        $("div").css("display","none");
        $("#dM").css("display","block");
        $("#eM").attr("disabled","disabled");
    })
    $("#eT").click(function () {
        $("li").removeAttr("disabled");
        $("div").css("display","none");
        $("#dT").css("display","block");
        $("#eT").attr("disabled","disabled");
    })
    $("#eA").click(function () {
        $("li").removeAttr("disabled");
        $("div").css("display","none");
        $("#dA").css("display","block");
        $("#eA").attr("disabled","disabled");
    })
    $("#eL").click(function () {
        $("li").removeAttr("disabled");
        $("div").css("display","none");
        $("#dL").css("display","block");
        $("#eL").attr("disabled","disabled");
    })
    $("#office").click(function () {
        $.ajax({
            type:"post",
            url:"goOffice",
            data:"",
            success:function(obj){
                alert(obj);
            }
        })
    })
    $("#after").click(function () {
        $.ajax({
            type:"post",
            url:"goAfter",
            data:"",
            success:function(obj){
                alert(obj);
            }
        })
    })
})