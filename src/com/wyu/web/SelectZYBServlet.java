package com.wyu.web;

import com.alibaba.fastjson.JSON;
import com.wyu.pojo.zyb;
import com.wyu.service.ZYBService;
import com.wyu.service.ZYBServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectZYBServlet")
public class SelectZYBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //用service调用数据
        ZYBService service = new ZYBServiceImpl();
        //查询所有专业的方法
        List<zyb> zys= service.selectZyAll();
        if(zys!=null){
            String listjson = JSON.toJSONString(zys);
            //layui前端要求是要封装成json数据，才可以解析，所以要将list集合中的数据解析成json才可以
            String json = "{\"code\":0,\"msg\":\"\",\"count\":"+15+",\"data\":"+listjson+"}";
            response.getWriter().append(json);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
