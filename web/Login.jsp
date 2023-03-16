<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<style>
    body {
        background-image: url("img/OIP-C.jpg");
        background-size: cover;
    }
    header .header {
        background-color: #fff;
        height: 45px;
    }

    /*header a img {*/
    /*    width: 134px;*/
    /*    margin-top: 4px;*/
    /*}*/

    .login-page {
        border-radius: 20px;
        width: 360px;
        padding: 12% 0 0;
        margin: auto;
    }

    .login-page .form .login {
        color: white;
        margin-top: -31px;
        margin-bottom: 26px;
    }

    .form {
        position: relative;
        background-color: rgba(41, 36, 33, 0.8);
        border-radius: 20px;
        /*background: #FFFFFF;*/
        max-width: 360px;
        margin: 0 auto 100px;
        padding: 45px;
        text-align: center;
        box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    }

    .input {
        font-family: "Roboto", sans-serif;
        border-radius: 10px;
        outline: 0;
        background: #f2f2f2;
        width: 100%;
        border: 0;
        margin: 0 0 20px;
        padding: 12px;
        box-sizing: border-box;
        font-size: 14px;
    }

    .input1 {
        font-family: "Roboto", sans-serif;
        border-radius: 10px;
        outline: 0;
        background: #f2f2f2;
        width: 100%;
        border: 0;
        margin: 0 0 20px;
        padding: 12px;
        box-sizing: border-box;
        font-size: 14px;
    }

    .form button {
        font-family: "Roboto", sans-serif;
        text-transform: uppercase;
        outline: 0;
        border-radius: 25px;
        /*background-color: #328f8a;*/
        /*background-image: linear-gradient(45deg, #328f8a, #08ac4b);*/
        background-color: #007aff;
        width: 50%;
        border: 0;
        padding: 10px;
        color: #FFFFFF;
        font-size: 14px;
        cursor: pointer;
    }

    .form .message {
        margin: 15px 0 0;
        color: #b3b3b3;
        font-size: 14px;
    }

    .form .message a {
        font-weight: bold;
        color:#007aff;
        text-decoration: none;
    }

    .container {
        position: relative;
        z-index: 1;
        max-width: 300px;
        margin: 0 auto;
    }


</style>


<body>
<div class="login-page">
    <div class="form">
        <div class="login">
            <h3 style="font-size: 25px">LOGIN</h3>
            <p style="font-size: 10px">请输入账号和密码</p>
        </div>
        <form action="LoginServlet" method="post">
            <input class="input" type="text" name="username" placeholder="账号"/>
            <input class="input" type="password" name="password" placeholder="密码"/>
            <input class="input1" type="text" name="checkcode" placeholder="验证码" style="position: relative"/>
            <a href="javascript:(0)" onclick="shuaxin()">
                <%--            <img id="CheckCodeImg" src="CheckCodeUtil" style="height: 35px;border-radius: 10px;">--%>
                <img id="CheckCodeImg" src="CheckCodeUtil"
                     style="position: absolute;right: 45px;width: 20%;border-radius: 0px 10px 10px 0px">
            </a>
            <div style="width: 100%;height: 30px"><span style="font-size: 10px;color: red">${loginMsg}</span></div>
            <button type="submit">登录</button>
            <p class="message" style="margin-top: 30px">没有账号? | <a href="register.jsp">注册</a></p>
        </form>
    </div>
</div>
</body>
<script>
    var checkcodeimg = document.getElementById("CheckCodeImg");

    function shuaxin() {
        checkcodeimg.setAttribute("src", "CheckCodeUtil?" + new Date().getTime());
    }
</script>
</html>