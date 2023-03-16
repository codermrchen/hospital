<%--
  Created by IntelliJ IDEA.
  User: ice cream
  Date: 2022/3/31
  Time: 11:50
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
<div style="border: silver 1px solid;width: 1500px;border-radius: 10px">
    <h1 style="color: #5FB878;margin-left: 30px;margin-top: 20px;font-weight: bold">医生挂号处理</h1>
    <hr>
<table class="layui-table" lay-data="{width: 1500, height:500, url:'SearchGHServlet', page:true, id:'idTest'}" lay-filter="demo"
style="margin-left: 30px;">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'id', width:'10%'}">病号</th>
        <th lay-data="{field:'username', width:'10%', sort: true, fixed: true}">病人姓名</th>
        <th lay-data="{field:'sj', width:'10%'}">问诊时间</th>
        <th lay-data="{field:'hospital', width:'10%'}">医院</th>
        <th lay-data="{field:'office', width:'10%'}">科室</th>
        <th lay-data="{field:'doctor', width:'10%'}">医生</th>
        <th lay-data="{field:'reason', width:'10%'}">病情</th>
        <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}">操作</th>
    </tr>

    </thead>
</table>

<script type="text/html" id="barDemo">

    <%--进行页面跳转操作--%>
    <a href="GHCLresult.jsp" class="layui-btn jump_refresh_url">处理</a>
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
                    //删除数据
                    var json ={"id":data.id};
                   $.post("SearchGHServlet",json,function (data,code) {
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
                layer.alert('你确定要挂：<br>'+ JSON.stringify(data.xm)+'医生的号')
                var json ={"ysbh":data.ysbh};
                $.post("GHServlet",json,function (data,code) {



                })

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
