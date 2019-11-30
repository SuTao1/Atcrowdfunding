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
            <input type="text" name="loginacct" class="form-control" id="inputSuccess4" placeholder="登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="password" name="userpswd" class="form-control" id="inputSuccess4" placeholder="登录密码"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" name="username" id="inputSuccess4" placeholder="用户姓名"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" name="email" id="inputSuccess4" placeholder="邮箱地址"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <select class="form-control" name="userType">
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
        $("#registerForm").submit();
    }
    /*$("button").on('click',function () {
        $.post("${APP_PATH}/register.do", $("form").serialize(), function (json) {
            alert(json.message());
        },'json')
    });*/
    /*$("button").on('click', function () {
        $.ajax({
            type: 'POST',
            url: "${APP_PATH}/register.do",
            async: false,
            data: {
                'loginName': $("input[name='loginName']").val(),
                'loginPassword': $("input[name='loginPassword']").val(),
                'email': $("input[name='email']").val(),
                'userType': $("select[name='userType']").val()
            },
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function () {
                console.log(data);
            }
        })
    });*/
</script>
</body>
</html>