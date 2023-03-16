package com.wyu.filter;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CheckLoginFilter",value = "/*")
public class CheckLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //思路：
        //1.得到用户的url，若是登陆界面login.jsp则放行，有些系统是需要注册，则注册系统不用过滤
        //我们这个账号是管理员界面，不用注册的

        //1.获得用户url
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String contextPath = request.getContextPath();
        System.out.println("路径是"+contextPath);
        String requestURI = request.getRequestURI();
        System.out.println("路径2是"+requestURI);

        //如果是登录界面就放行
        if(request.getRequestURI().indexOf("Login.jsp")!=-1||request.getRequestURI().indexOf("CheckCodeUtil")!=-1||request.getRequestURI().indexOf("LoginServlet")!=-1||request.getRequestURI().indexOf("img/OIP-C.jpg")!=-1||request.getRequestURI().indexOf("register.jsp")!=-1||request.getRequestURI().indexOf("img/img2.jpg")!=-1){
            chain.doFilter(req, resp);
            return;
        }else {
            //如果不是登录界面
            //判断用户是否登录
            //得到session中的用户，判断其是否为空，如果为空，则说明没有登录，否则说明登录，放行
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if(user==null){
                //跳转到登录界面
                 response.sendRedirect("Login.jsp");
                System.out.println("用户未登录");
                return;
            }else {
                chain.doFilter(req, resp);
            }

        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
