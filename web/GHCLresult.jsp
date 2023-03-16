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
<div style="border: silver 1px solid;width: 1000px;border-radius: 10px">
<form class="layui-form layui-form-pane" action="GHCLServlet">
<h1 style="color: #5FB878;margin-left: 30px;margin-top: 20px;font-weight: bold">挂号处理</h1>
<hr>
    <div class="layui-form-item" style="margin-left: 20px">
        <label class="layui-form-label">处理医生</label>
        <div class="layui-input-inline">
            <input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item layui-form-text" style="margin-left: 20px">
        <label class="layui-form-label"style="width: 800px">处理结果</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" name="result" class="layui-textarea" style="width: 800px"></textarea>
        </div>
    </div>

    <button class="layui-btn" lay-submit="" lay-filter="demo2" style="margin-left: 20px">跳转式提交</button>

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
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
                //在这里写代码
                

            })
            return ture;
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
