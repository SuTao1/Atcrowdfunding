<%--
  Created by IntelliJ IDEA.
  User: 29665
  Date: 2019/11/27
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/login.css">
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="/index.htm" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <form ID="registerForm" action="${APP_PATH}/doRegister.do" method="POST" class="form-signin" role="form">
        ${exception.message}
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户注册</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" name="loginacct" value="admin" class="form-control" id="floginacct" placeholder="账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="password" name="userpswd" value="123" class="form-control" id="fuserpswd" placeholder="密码"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" value="苏轼" name="username" id="fusername" placeholder="用户姓名"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" value="999@gmail.com" name="email" id="femail" placeholder="邮箱"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <select id="fuserType" class="form-control" name="userType">
                <option value="0">企业</option>
                <option value="1" selected>个人</option>
            </select>
        </div>
        <div class="checkbox">
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="${APP_PATH}/login.htm">我有账号</a>
            </label>
        </div>
        <%--<a class="btn btn-lg btn-success btn-block" href="/member.htm" id="req1"> 注册</a>--%>
        <button class="btn btn-lg btn-success btn-block" onclick="doregister()">注册</button>
    </form>
</div>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script>
    function doregister() {
        // 同步
        /*$("#registerForm").submit();*/
        // 异步
        $.ajax({
            url : "${APP_PATH}/doRegister.do",
            type : "POST",
            data : {
                "loginacct" : $("#floginacct").val(),
                "userpswd" : $("#fuserpswd").val(),
                "username" : $("#fusername").val(),
                "email" : $("#femail").val(),
                "userType" : $("#fuserType").val()
            },
            async : true,
            beforeSend : function () {
                console.log("预处理");
            },
            success : function (result) {
                if(result.success){
                    alert(result.message);
                    window.location.href="${APP_PATH}/login.htm";
                }else{
                    alert(result.message);
                    window.location.href="${APP_PATH}/reg.htm";
                }
            },
            error : function (exception) {
                console.log(exception.message);
            }
        })
    }
    // 登录名文本框鼠标失去焦点触发事件
    $("#floginacct").blur(function () {
        $.ajax({
            url : "${APP_PATH}/loginacctVerification.do",
            data : {
                "loginacct" : $("#floginacct").val()
            },
            type : "GET",
            beforeSend : function () {
                console.log("预处理");
            },
            success : function (result) {
                alert(result.message);
            },
            error : function (exception) {
                alert(exception.message);
            }
        })
    })


</script>
</body>
</html>