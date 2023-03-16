package com.wyu.web;

import com.alibaba.fastjson.JSON;
import com.wyu.pojo.KCB;
import com.wyu.service.KCBService;
import com.wyu.service.KCBServiceImpl;
import com.wyu.service.Yhbservice;
import com.wyu.service.YhbserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeleteZYServlet")
public class DeleteZYServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Yhbservice yhbservice = new YhbserviceImpl();
        int i = yhbservice.deteleById(id);
        String deleteMsg ="0";
        if(i>0){
            //删除成功
            deleteMsg = "1";
        }
        response.getWriter().append(deleteMsg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
