<%--
  Created by IntelliJ IDEA.
  User: ice cream
  Date: 2021/11/30
  Time: 15:18
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
<table class="layui-table" lay-data="{width: 1500, height:500, url:'SelectKCBServlet', page:true, id:'idTest'}" lay-filter="demo">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'kch', width:'10%', sort: true, fixed: true}">课程号</th>
        <th lay-data="{field:'kcm', width:'10%'}">课程名</th>
        <th lay-data="{field:'kxxq', width:'10%'}">课程学期</th>
        <th lay-data="{field:'xs', width:'10%'}">学生</th>
        <th lay-data="{field:'xf', width:'10%'}">学分</th>
        <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}">操作</th>
    </tr>

    </thead>
</table>

<script type="text/html" id="barDemo">

    <a class="layui-btn layui-btn-xs" lay-event="edit">选修</a>

</script>

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
