<%--
  Created by IntelliJ IDEA.
  User: ice cream
  Date: 2022/4/1
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <script src="layui/layui.js" charset="utf-8"></script>
</head>
<body>
<div style= "border: #009f95 1px solid;border-radius: 10px;width: 600px">
<form class="layui-form layui-form-pane" action="AmendServlet" method="post">
<h2 style="color: #5FB878;margin-left: 30px;margin-top: 20px;font-weight: bold">修改密码</h2>
    <hr style="margin-bottom: 20px">

    <div class="layui-form-item" style="margin-left: 20px">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
        <div style="width: 100%;height: 30px"><span style="font-size: 10px;color: red">${amendMsg}</span></div>
    </div>
    <div class="layui-form-item" style="margin-left: 20px">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">请务必填写用户名</div>
    </div>

    <div class="layui-form-item" style="margin-left: 20px">
        <label class="layui-form-label">新密码</label>
        <div class="layui-input-inline">
            <input type="password" name="newpassword1" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="margin-left: 20px">
        <label class="layui-form-label">确认新密码</label>
        <div class="layui-input-inline">
            <input type="password" name="newpassword2" placeholder="请输入密码" autocomplete="off" class="layui-input">
            <div style="width: 100%;height: 30px"><span style="font-size: 10px;color: red">${newMsg}</span></div>
        </div>
    </div>
    <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" style="margin-left: 20px;margin-bottom: 20px">立即提交</button>



</form>
</div>
</body>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {

                title: '最终的提交信息'
            })
            return true;
        });

        //表单赋值
        layui.$('#LAY-component-form-setval').on('click', function(){
            form.val('example', {
                "username": "贤心" // "name": "value"
                ,"password": "123456"
                ,"interest": 1
                ,"like[write]": true //复选框选中状态
                ,"close": true //开关状态
                ,"sex": "女"
                ,"desc": "我爱 layui"
            });
        });

        //表单取值
        layui.$('#LAY-component-form-getval').on('click', function(){
            var data = form.val('example');
            alert(JSON.stringify(data));
        });

    });
</script>

</html>
