package com.wyu.web;

import com.alibaba.fastjson.JSON;
import com.wyu.pojo.xsb;
import com.wyu.service.XSBService;
import com.wyu.service.XSBServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //跳转到登录界面，同时将用户信息清空
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect("Login.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
