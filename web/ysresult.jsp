<%--
  Created by IntelliJ IDEA.
  User: ice cream
  Date: 2021/11/20
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <script src="layui/layui.js" charset="utf-8"></script>
</head>
<body >
<div style="border-radius: 5px;width: 1800px;height: 800px;border: #5FB878 1px solid;position:absolute;">
    <h1 style="margin-left: 70px;margin-top: 20px;color: #5FB878">医生信息</h1>
    <hr>


    <div class="layui-input-inline" style="margin-bottom: 20px">
        <label class="layui-form-label" style="margin-left: 10px">姓名</label>
        <input type="text" name="username" lay-verify="required"  value="${map.name}" style="margin-left: 70px;height: 30px;" disabled="disabled" autocomplete="off" class="layui-input">
    </div>


    <div class="layui-input-inline" style="margin-bottom: 20px">
        <label class="layui-form-label" style="margin-left: 10px">生日</label>
        <input type="text" name="username" lay-verify="required"  value="${map.borthday}" style="margin-left: 70px;height: 30px;" disabled="disabled" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-input-inline" style="margin-bottom: 20px">
        <label class="layui-form-label" style="margin-left: 10px">学历</label>
        <input type="text" name="username" lay-verify="required"  value="${map.degree}" style="margin-left: 70px;height: 30px;" disabled="disabled" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-input-inline" style="margin-bottom: 20px">
        <label class="layui-form-label" style="margin-left: 10px">办公室</label>
        <input type="text" name="username" lay-verify="required"  value="${map.office_major}" style="margin-left: 60px;height: 30px;" disabled="disabled" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-input-inline" style="margin-bottom: 20px">
        <label class="layui-form-label" style="margin-left: 10px">评价</label>
        <input type="text" name="username" lay-verify="required"  value="${map.performance}" style="margin-left: 70px;height: 30px;" disabled="disabled" autocomplete="off" class="layui-input">
    </div>

</div>
</body>


</html>
