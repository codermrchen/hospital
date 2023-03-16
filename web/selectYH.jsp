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
    <h1 style="margin-left: 50px;margin-top: 20px;color: #5FB878">医生信息</h1>
    <hr>
<div style="width: 100px;height: 50px;margin-bottom: 30px" >
    <form method="post" action="DownloadServlet">
        <input type="submit" value="导出人员信息" style="position: relative;left: 50px;top: 30px;">
    </form>
    <form method="post" action="YSServlet">
        <input type="text" placeholder="请输入关键字" name="message" style="position: relative;left: 200px;top: 0px;height: 30px;">
        <input type="submit" value="搜索" style="height:30px;width:50px;position: relative;left: 375px;top: -30px;">
    </form>
</div>

<table class="layui-table" lay-data="{width: 1500, height:500, url:'SelectZYBServlet', page:true, id:'idTest'}" style="position: relative;left: 50px;top: 100px" lay-filter="demo">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'id', width:'10%', sort: true, fixed: true}">专业ID</th>
        <th lay-data="{field:'name', width:'10%'}">姓名</th>
        <th lay-data="{field:'borthday', width:'10%'}">出生日期</th>
        <th lay-data="{field:'degree', width:'10%'}">学历</th>
        <th lay-data="{field:'office_major', width:'10%'}">科室-主治</th>
        <th lay-data="{field:'performance', width:'10%'}">表现</th>

        <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
    </tr>

    </thead>
</table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

</div>
</body>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['table','jquery','layer'], function(){
        var table = layui.table;
        var $ = layui.jquery;
        var layer = layui.layer;
        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                //完成ajax就可以

                $.post('http://192.168.96.40:8080/GZ2049WebServlet/SelectNoticeOne',{'id':data.id},function (data1) {
                    var  obj=eval(data1);
                    layer.open({
                        type: 0 //此处以iframe举例
                        ,title: '公告详情'
                        ,area: ['390px', '260px']
                        ,shade: 0
                        ,maxmin: true
                        ,content:"ID:&nbsp;&nbsp;" +obj[0].id+"<br>发布人:&nbsp;&nbsp;"+ obj[0].upload_name+"<br>标题:&nbsp;&nbsp;"+obj[0].notice_title
                        ,btn: ['继续弹出', '全部关闭'] //只是为了演示
                        ,yes: function(){
                            $(that).click();
                        }
                        ,btn2: function(){
                            layer.closeAll();
                        }

                        ,zIndex: layer.zIndex //重点1
                        ,success: function(layero){
                            layer.setTop(layero); //重点2
                        }
                    });


                });

                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    //要去数据库删除
                    //此处要用到ajax技术
                    var json ={"id":data.id};
                    $.post("DeleteZYServlet",json,function (data,code) {
                     if(data=="1"){
                         layer.msg('恭喜，删除成功',{icon:1})
                     }else {
                         layer.msg('对不起，删除失败',{icon:5})
                     }

                    })

                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
        });

        var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            ,getCheckLength: function(){ //获取选中数目
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
            }
            ,isAll: function(){ //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选': '未全选')
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
</html>
