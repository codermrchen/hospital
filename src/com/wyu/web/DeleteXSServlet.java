package com.wyu.web;

import com.wyu.service.XSBService;
import com.wyu.service.XSBServiceImpl;
import com.wyu.service.Yhbservice;
import com.wyu.service.YhbserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteXSServlet")
public class DeleteXSServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获得要删除的学生
        String xh = request.getParameter("xh");
        System.out.println("删除的学生学号是"+xh);
        XSBService xsbService = new XSBServiceImpl();
        int i = xsbService.deteleByXh(xh);
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
