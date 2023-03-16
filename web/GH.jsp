<%--
  Created by IntelliJ IDEA.
  User: ice cream
  Date: 2022/3/31
  Time: 12:34
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
<div style="border: silver 1px solid;width: 1000px;border-radius: 10px;">
<form class="layui-form layui-form-pane" action="GHServlet" >
<h1 style="color: #5FB878;margin-left: 30px;margin-top: 20px;font-weight: bold">个人挂号</h1>
<hr>
    <div class="layui-form-item"  style="margin-left: 20px">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" style="margin-left: 20px">
        <div class="layui-inline">
            <label class="layui-form-label">问诊日期</label>
            <div class="layui-input-block">
                <input type="text" name="sj" id="date1" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>


    <div class="layui-form-item" style="margin-left: 20px">
        <label class="layui-form-label">选择医生</label>
        <div class="layui-input-inline">
            <select name="hospital">
                <option value="">请选择医院</option>
                <option value="五邑中医院" selected="">五邑中医院</option>
                <option value="汕头大学附属医学院">汕头大学附属医学院</option>
                <option value="广州医学院">广州医学院</option>
            </select>
        </div>
        <div class="layui-input-inline" >
            <select name="office">
                <option value="">科室</option>
                <option value="骨科">骨科</option>
                <option value="皮肤科" >皮肤科</option>
                <option value="泌尿科">泌尿科</option>

            </select>
        </div>
        <div class="layui-input-inline">
            <select name="doctor">
                <option value="">请选择医生</option>
                <option value="刘杰" id="1">刘杰</option>
                <option value="李华" id="2">李华</option>
                <option value="钟明"id="3">钟明</option>
            </select>
        </div>
    </div>


    <div class="layui-form-item layui-form-text" style="margin-left: 20px">
        <label class="layui-form-label"style="width: 800px">输入病因</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" class="layui-textarea" style="width: 800px"name="reason"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn" lay-submit="" lay-filter="demo2" style="margin-left: 20px">跳转式提交</button>
    </div>

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
        form.on('submit(demo2)', function(data){

           var bto = confirm("确定挂号");
           if(bto){
               window.location.href="Success.jsp";
               return true ;
           }
           return false;



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
