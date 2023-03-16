package com.wyu.web;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Set<Map.Entry<String, String[]>> et = map.entrySet();

        Iterator<Map.Entry<String, String[]>> iterator = et.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> next = iterator.next();
            for (int i = 0; i < next.getValue().length; i++)
                System.out.println(next.getValue()[i]);
        }

        String username = map.get("username")[0];
        String password = map.get("password")[0];
        String xb = map.get("xb")[0];
        String city = map.get("city")[0];
        String likeArray[] = map.get("like");
        String like = "";
        for(int i = 0;i<likeArray.length;i++){
            like = likeArray[i]+",";
        }

/*        Connection ct = null;
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "INSERT INTO user(username,password,sex,city,like) VALUES (?,?,?,?,?)";

            int i = qr.update(ct,sql,username,password,sex,city,like);
            if(i>0)
                System.out.println("添加成功"+i+"条数据！");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }*/

        Connection ct = null;
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "INSERT INTO user(username,password,xb,city) VALUES (?,?,?,?)";
            int i = qr.update(ct,sql,username,password,xb,city);
            if(i>0)
                System.out.println("添加成功"+i+"条数据！");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

        request.setAttribute("loginMsg", "注册成功");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
