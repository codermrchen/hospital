package com.wyu.web;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.User;
import com.wyu.service.XSBService;
import com.wyu.service.XSBServiceImpl;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/AmendServlet")
public class AmendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newpassword1 = request.getParameter("newpassword1");
        String newpassword2 = request.getParameter("newpassword2");

        try {
            Connection ct = null;
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "select * FROM user where username = ?";
            BeanHandler<User> hd = new BeanHandler(User.class);
            User user = qr.query(ct, sql, hd, username);
            System.out.println(user);
            if (user == null) {
                request.setAttribute("amendMsg", "用户名不存在！");
                request.getRequestDispatcher("amend.jsp").forward(request, response);
            } else if (user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                request.setAttribute("amendMsg", "");
            } else {
                request.setAttribute("amendMsg", "用户名或密码错误！");
                request.getRequestDispatcher("amend.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(newpassword1.equals(newpassword2)){
            Connection ct = null;
            //获得连接
            try {
                QueryRunner qr = new QueryRunner();
                ct = CtUtil.getConnection();
                //添加数据
                String sql = "update user set password=? where username=?;";

                int i = qr.update(ct, sql, newpassword1,username);
                if(i>0){
                    System.out.println("成功修改"+i+"条数据");
                    response.sendRedirect("amend.jsp");
                    return;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JdbcUtils.close(ct);
            }
        }else {
            request.setAttribute("newMsg", "新密码与确认密码不符");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
