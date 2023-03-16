package com.wyu.util;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/CheckCodeUtil")
public class CheckCodeUtil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义图形验证码的长和宽
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        //图形验证码写出，可以写出到文件，也可以写出到流
        // lineCaptcha.write("d:/tupian.png");
        //下面是输出到浏览器

        captcha.write(response.getOutputStream());
        String code = captcha.getCode();
        System.out.println("产生的验证码是"+code);
        request.getSession().setAttribute("code",code);
        request.setAttribute("loginMsg"," kon ");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
