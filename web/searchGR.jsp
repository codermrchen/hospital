<%--
  Created by IntelliJ IDEA.
  User: ice cream
  Date: 2022/3/31
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}layui/layui.js" charset="utf-8"></script>
</head>
<body>


<form class="layui-form layui-form-pane" action="form.html">
<div style="border: #009f95 1px solid;border-radius: 10px;width: 350px">
    <div class="layui-form-item">
       <h1 style="color: #5FB878;margin-left: 20px">个人信息</h1>
        <hr>
        <div class="layui-input-inline" style="margin-bottom: 20px">
            <label class="layui-form-label" style="margin-left: 10px">头像</label>
            <img style="width: 120px;height: 120px;margin-left: 20px" src="${pageContext.request.contextPath}/img/3.jpg">
        </div>

        <div class="layui-input-inline" style="margin-bottom: 20px">
            <label class="layui-form-label" style="margin-left: 10px">姓名</label>
            <input type="text" name="username" lay-verify="required"  value="${user.username}" style="margin-left: 20px;height: 30px;" disabled="disabled" autocomplete="off" class="layui-input">
        </div>


        <div class="layui-input-inline" style="margin-bottom: 20px">
            <label class="layui-form-label" style="margin-left: 10px">来自</label>
            <input type="text" name="username" lay-verify="required"  value="${user.city}" style="margin-left: 20px;height: 30px;" disabled="disabled" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline" style="margin-bottom: 20px">
            <label class="layui-form-label" style="margin-left: 10px">性别</label>
            <input type="text" name="username" lay-verify="required"  value="${user.xb}" style="margin-left: 20px;height: 30px;" disabled="disabled" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline" style="margin-bottom: 20px">
            <label class="layui-form-label" style="margin-left: 10px">生日</label>
            <input type="text" name="username" lay-verify="required"  value="${user.csrq}" style="margin-left: 20px;height: 30px;" disabled="disabled" autocomplete="off" class="layui-input">
        </div>


    </div>
</div>
</form>


</body>
</html>
