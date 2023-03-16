package com.wyu.web;

import com.wyu.pojo.User;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        System.out.println("用户名：" + username + " 密码：" + password + " 验证码：" + checkcode);

        String code = session.getAttribute("code") + "";
        System.out.println("session checkcode:" + code);

        if (!code.equals(checkcode)) {
            request.setAttribute("loginMsg", "验证码错误！");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            return;
        } else {

            try {
                Connection ct = null;
                QueryRunner qr = new QueryRunner();
                ct = CtUtil.getConnection();
                String sql = "select * FROM user where username = ?";
                BeanHandler<User> hd = new BeanHandler(User.class);
                User user = qr.query(ct, sql, hd, username);
                System.out.println(user);
                if (user.getUsername() == null) {
                    request.setAttribute("loginMsg", "用户名不存在！");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                } else if (user.getPassword().equals(password)) {
                    session.setAttribute("user",user);
                    request.setAttribute("loginMsg", "");

                    Cookie name = new Cookie("username", user.getUsername());
                    Cookie ward = new Cookie("password",user.getPassword());
                    name.setMaxAge(24*60);
                    response.addCookie(name);

                    ward.setMaxAge(24*60);
                    response.addCookie(ward);
                    response.sendRedirect("index.jsp");
                } else {
                    request.setAttribute("loginMsg", "密码错误！");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
