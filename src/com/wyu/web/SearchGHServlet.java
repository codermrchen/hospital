package com.wyu.web;

import com.alibaba.fastjson.JSON;
import com.wyu.pojo.ghb;
import com.wyu.pojo.ysb;
import com.wyu.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SearchGHServlet")
public class SearchGHServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理分页问题
        //layui会每次请求是带两个参数到后台，得到这两个参数，就可以分页了

        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        System.out.println("page=="+page+","+"limit=="+limit);

        String id = request.getParameter("id");
        System.out.println("删除病人姓名是"+id);




        //到service完成查询操作
        GHService kc = new GHServiceImpl();
        //查询所有课程，包括分页
        List<ghb> list = kc.selectGHAll(page,limit);
        //查询总条数
        int count = kc.selecGHBAllCount();
        //判断集合！=0
        if(list.size()>0){
            //查询到数据
            String listjson = JSON.toJSONString(list);
            //layui前端要求是要封装成json数据，才可以解析，所以要将list集合中的数据解析成json才可以
            String json = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+listjson+"}";
            response.getWriter().append(json);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
