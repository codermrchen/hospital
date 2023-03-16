package com.wyu.web;

import com.alibaba.fastjson.JSON;
import com.wyu.pojo.KCB;
import com.wyu.pojo.ysb;
import com.wyu.service.KCBService;
import com.wyu.service.KCBServiceImpl;
import com.wyu.service.YSService;
import com.wyu.service.YSServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchYSServlet", urlPatterns = "/SearchYSServlet")
public class SearchYSServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理分页问题
        //layui会每次请求是带两个参数到后台，得到这两个参数，就可以分页了
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        System.out.println("page=="+page+","+"limit=="+limit);

        String message = request.getParameter("message");


        //到service完成查询操作
        YSService kc = new YSServiceImpl();
        //查询所有课程，包括分页
        List<ysb> list = kc.selectYSAll(page,limit);
        //查询总条数
        int count = kc.selectKCBAllCount();
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
