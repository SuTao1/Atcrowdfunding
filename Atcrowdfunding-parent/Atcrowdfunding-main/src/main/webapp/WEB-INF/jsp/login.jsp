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

    <form id="loginForm" class="form-signin" action="${APP_PATH}/doLogin.do" METHOD="POST" role="form">
        <h2>${exception.message}<h2>
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" name="loginacct" class="form-control" value="admin" id="floginacct" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="password" name="loginpswd" class="form-control" value="123" id="floginpswd" placeholder="请输入登录密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <select id="floginType" class="form-control" name="loginType">
                <option value="member">会员</option>
                <option value="user" selected>管理</option>
            </select>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
            <br>
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="${APP_PATH}/reg.htm">我要注册</a>
            </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()" > 登录</a>
    </form>
</div>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src=${APP_PATH}/"bootstrap/js/bootstrap.min.js"></script>
<script>
    function dologin() {
        /*同步请求，提交表单*/
        //$("#loginForm").submit();

        /*异步请求，ajax封装*/
        $.ajax({
            url : "${APP_PATH}/doLogin.do",
            type : "POST",
            //timeout : 10000,
            async : true,
            data : {
                "loginacct" : $("#floginacct").val(),
                "loginpswd" : $("#floginpswd").val(),
                "loginType" : $("#floginType").val()
            },
            // 发出请求前的判断，可以对表单的
            beforeSend : function(){
                console.log("还可以对表单进行操作");
            },
            success : function(result){
                if(result.success){
                    alert(result.message);
                    window.location.href = "${APP_PATH}/main.htm";
                }else{
                    alert(result.message);
                }
            },
            error : function(){
                alert("失败");
            }
        });
    }
</script>
</body>
</html>
