<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/regStyle.css"/>
</head>
<style>
    body {
        background-image: url("img/img2.jpg");
        background-repeat: no-repeat;
        background-size: 100%;
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
            <div class="login-header">
                <h3>REGISTER</h3>
                <p>Please enter your credentials to login.</p>
            </div>
        </div>
        <form class="login-form" action="RegisterServlet" method="post">
            <input class="input" type="text" name="username" placeholder="username"/>
            <input class="input" type="password" name="password" placeholder="password"/>
            <table style="border-spacing: 0px 12px">
                <tr>
                    <th style="font-family: Roboto,sans-serif;font-size: 17px; font-weight: 500">性别&nbsp&nbsp</th>
                    <td>
                        <input type="radio" name="xb" value="男">男 &nbsp&nbsp&nbsp <input type="radio" name="xb"
                                                                                          value="女">女
                    </td>
                </tr>
                <tr>
                    <th style="font-family: Roboto,sans-serif;font-size: 16px;font-weight: 500">爱好&nbsp&nbsp</th>
                    <td>
                        <input type="checkbox" name="like" value="篮球">篮球
                        <input type="checkbox" name="like" value="排球">排球
                        <input type="checkbox" name="like" value="篮球">篮球
                        <input type="checkbox" name="like" value="篮球">篮球
                    </td>
                </tr>

                <tr>
                    <th style="font-family: Roboto,sans-serif;font-size: 16px;font-weight: 500">城市&nbsp&nbsp</th>
                    <td>
                        <select name="city" style="width: 60px;height: 25px">
                            <option value="bj">北京</option>
                            <option value="sh">上海</option>
                            <option value="gz">广州</option>
                            <option value="sz">深圳</option>
                        </select>
                    </td>
                </tr>
            </table>
            <button type="submit">register</button>
            <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>
    </div>
</div>
</body>
</html>