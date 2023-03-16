<%--
  Created by IntelliJ IDEA.
  User: ice cream
  Date: 2021/10/16
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>医院挂号系统</title>
    <link rel="icon" href="img/5.jpg" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
  </head>
  <style>
    .jl{
      padding-left: 15px;
    }
  </style>

  <body>
  <div class="layui-layout layui-layout-admin">
    <div class="layui-header">
      <div class="layui-logo layui-hide-xs layui-bg-black" style="font-size: 25px">医院挂号系统</div>
      <!-- 头部区域（可配合layui 已有的水平导航） -->
      <ul class="layui-nav layui-layout-left layui-bg-black">


        <li class="layui-nav-item layui-hide-xs" ><a href="" style="font-size: 20px">用户:${user.username}Welcome</a></li>

      </ul>
      <ul class="layui-nav layui-layout-right layui-bg-black">

        <li class="layui-nav-item layui-hide layui-show-md-inline-block">
          <a href="javascript:;">
            <img src="${pageContext.request.contextPath}/img/3.jpg" class="layui-nav-img">
            ${user.username}
          </a>
          <dl class="layui-nav-child">
            <dd><a href="">密码：${user.password}</a></dd>
            <dd><a href="">出生日期：${user.csrq}</a></dd>
            <dd><a href="">性别：${user.xb}</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Logout">退出</a></li>
        <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
          <a href="javascript:;">
            <i class="layui-icon layui-icon-more-vertical"></i>
          </a>
        </li>
      </ul>
    </div>

    <div class="layui-side layui-bg-black">
      <center><img src="${pageContext.request.contextPath}/img/3.jpg" class="layui-nav-img" style="width: 130px;height: 130px;margin-top: 20px"></center>
      <p style="margin-left: 60px;margin-top: 10px">欢迎${user.username}</p>
      <hr>
      <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
          <li class="layui-nav-item layui-nav-itemed">
            <a class="" href="javascript:;"><i class="layui-icon layui-icon-username" style="font-size: 15px;color: #FBFBFB"></i>&nbsp;用户操作</a>
              <dl class="layui-nav-child">
              <dd class="jl"><a href="javascript:;"
                                data-url="searchGR.jsp"
                                data-id="searchGR"
                     data-title="<i class='layui-icon layui-icon-search' style='font-size: 15px;'>&nbsp;查询个人信息"
                     class="site-demo-active"

              ><i class="layui-icon layui-icon-search" style="font-size: 15px;color: #FBFBFB"></i>&nbsp;查询个人信息</a></dd>
              <dd class="jl"><a href="javascript:;"
                                data-url="searchYS.jsp"
                                data-id="searchYS"

                     data-title="<i class='layui-icon layui-icon-friends' style='font-size: 15px;'>查询医生预约情况"
                     class="site-demo-active"

              ><i class="layui-icon layui-icon-friends" style="font-size: 15px;color: #FBFBFB"></i>&nbsp;查询医生预约情况</a></dd>
              <dd class="jl"><a href="javascript:;"
                     data-url="GH.jsp"
                     data-id="GH"
                     data-title="<i class='layui-icon layui-icon-survey' style='font-size: 15px;'>个人挂号"
                     class="site-demo-active"
              ><i class="layui-icon layui-icon-survey" style="font-size: 15px;color: #FBFBFB"></i>&nbsp;个人挂号</a></dd>

                <dd class="jl"><a href="javascript:;"
                                  data-url="GHCL.jsp"
                                  data-id="GHCL"
                                  data-title="<i class='layui-icon layui-icon-util' style='font-size: 15px;'>挂号处理"
                                  class="site-demo-active"
                ><i class="layui-icon layui-icon-util" style="font-size: 15px;color: #FBFBFB"></i>&nbsp;挂号处理</a></dd>



                <dd class="jl"><a href="javascript:;"
                                  data-url="amend.jsp"
                                  data-id="amend"
                                  data-title="<i class='layui-icon layui-icon-edit' style='font-size: 15px;'>挂号处理"
                                  class="site-demo-active"
                ><i class="layui-icon layui-icon-edit" style="font-size: 15px;color: #FBFBFB"></i>&nbsp;修改个人密码</a></dd>
                <dd class="jl"><a href="javascript:;"
                                  data-url="xsym.jsp"
                                  data-id="xsym"

                                  data-title="<i class='layui-icon layui-icon-friends' style='font-size: 15px;'>健康药膳展示"
                                  class="site-demo-active"

                ><i class="layui-icon layui-icon-friends" style="font-size: 15px;color: #FBFBFB"></i>&nbsp;健康药膳展示</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item" style="display:${user.zp=="1"?"block":"none"}" >
            <a href="javascript:;"><i class="layui-icon layui-icon-user" style="font-size: 15px;color: #FBFBFB"></i>&nbsp;管理操作</a>
            <dl class="layui-nav-child">
              <dd class="jl"><a href="javascript:;"
                     data-url="selectYH.jsp"
                     data-id="selectYH"
                     data-title="<i class='layui-icon layui-icon-face-' style='font-size: 20px;font-weight: bold'></i>医生信息操作"
                     class="site-demo-active"
              ><i class="layui-icon layui-icon-auz" style="font-size: 15px;color: #FBFBFB"></i>&nbsp;医生信息操作</a></dd>
              <dd class="jl"><a href="javascript:;"
                     data-url="MessageHandle.jsp"
                     data-id="MessageHandle"
                     data-title="健康指导"
                     class="site-demo-active"
              ><i class="layui-icon layui-icon-auz" style="font-size: 15px;color: #FBFBFB"></i>&nbsp;健康指导</a></dd>

              <dd class="jl"><a href="javascript:;"
                     data-url="searchGH.jsp"
                     data-id="searchGH"
                     data-title="<i class='layui-icon layui-icon-auz' style='font-size: 15px;'>医生查看挂号操作"
                     class="site-demo-active"
              ><i class="layui-icon layui-icon-auz" style="font-size: 15px;color: #FBFBFB"></i>&nbsp;医生查看挂号操作</a></dd>
            </dl>
          </li>

        </ul>
      </div>
    </div>

    <div class="layui-body">
      <!-- 内容主体区域 -->
      <div style="padding: 15px;">


        <div class="layui-tab" lay-filter="demo" lay-allowClose="true">
          <ul class="layui-tab-title">
            <li class="layui-this">主页</li>

          </ul>
          <div class="layui-carousel" id="test10" style="margin-bottom: 20px">
            <div carousel-item="">
              <div><img src="img/1.jpg"width="100%"height="800px"></div>
              <div><img src="img/2.jpg"width="100%"height="800px"></div>
              <div><img src="img/6.jpg"width="100%"height="800px"></div>
              <div><img src="img/4.jpg"width="100%"height="800px"></div>
            </div>
            <div><h3>非常感谢您选择我们医院，我们医院将为你提供优质服务</h3></div>
          </div>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show"></div>



          </div>
        </div>




      </div>
    </div>

    <div class="layui-footer">
      <!-- 底部固定区域 -->
      <center>
        @医院挂号系统
      </center>
    </div>
  </div>

  <script>
    //JS
    layui.use(['element', 'layer', 'util', 'carousel', 'jquery'], function(){
      var element = layui.element
              ,layer = layui.layer
              ,util = layui.util
              ,carousel=layui.carousel
              ,$ = layui.jquery;

      //头部事件
      util.event('lay-header-event', {
        //左侧菜单事件
        menuLeft: function(othis){
          layer.msg('展开左侧菜单的操作', {icon: 0});
        }
        ,menuRight: function(){
          layer.open({
            type: 1
            ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
            ,area: ['260px', '100%']
            ,offset: 'rt' //右上角
            ,anim: 5
            ,shadeClose: true
          });
        }
      });

      //触发事件
      var active = {
        //在这里给active绑定几项事件，后面可通过active调用这些事件
        tabAdd: function (url, id, title) {
          //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
          //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
          element.tabAdd('demo', {
            title: title,
            content: '<iframe data-frameid="' + id
                    + '" scrolling="auto" frameborder="0" src="'
                    + url + '" style="width:100%;height: 730px"></iframe>',
            id: id
            //规定好的id
          })
          element.render('tab');

        },
        tabChange: function (id) {
          //切换到指定Tab项
          element.tabChange('demo', id); //根据传入的id传入到指定的tab项
        },
        tabDelete: function (id) {
          element.tabDelete("demo", id);//删除
        },
        tabDeleteAll: function (ids) {//删除所有
          $.each(ids, function (i, item) {
            element.tabDelete("demo", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
          })
        }
      };
//当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
      $('.site-demo-active').on(
              'click',
              function () {
                var dataid = $(this);

                //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
                if ($(".layui-tab-title li[lay-id]").length <= 0) {
                  //如果比零小，则直接打开新的tab项
                  active
                          .tabAdd(dataid.attr("data-url"), dataid
                                  .attr("data-id"), dataid
                                  .attr("data-title"));
                } else {
                  //否则判断该tab项是否以及存在

                  var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
                  $.each($(".layui-tab-title li[lay-id]"),
                          function () {
                            //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
                            if ($(this).attr("lay-id") == dataid
                                    .attr("data-id")) {
                              isData = true;
                            }
                          })
                  if (isData == false) {
                    //标志为false 新增一个tab项
                    active.tabAdd(dataid.attr("data-url"), dataid
                            .attr("data-id"), dataid
                            .attr("data-title"));
                  }
                }
                //最后不管是否新增tab，最后都转到要打开的选项页面上
                active.tabChange(dataid.attr("data-id"));
              });




    });

    layui.use(['carousel', 'form'], function(){          //轮播图
      var carousel = layui.carousel
              ,form = layui.form;


      //图片轮播
      carousel.render({
        elem: '#test10'
        ,width: '100%'
        ,height: '500px'
        ,interval: 5000
      });


      var $ = layui.$, active = {
        set: function(othis){
          var THIS = 'layui-bg-normal'
                  ,key = othis.data('key')
                  ,options = {};

          othis.css('background-color', '#5FB878').siblings().removeAttr('style');
          options[key] = othis.data('value');
          ins3.reload(options);
        }
      };

      //监听开关
      form.on('switch(autoplay)', function(){
        ins3.reload({
          autoplay: this.checked
        });
      });

      $('.demoSet').on('keyup', function(){
        var value = this.value
                ,options = {};
        if(!/^\d+$/.test(value)) return;

        options[this.name] = value;
        ins3.reload(options);
      });

      //其它示例
      $('.demoTest .layui-btn').on('click', function(){
        var othis = $(this), type = othis.data('type');
        active[type] ? active[type].call(this, othis) : '';
      });
    });



  </script>
  </body>
</html>
