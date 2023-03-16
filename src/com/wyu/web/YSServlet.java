package com.wyu.web;

import com.alibaba.druid.util.JdbcUtils;
import com.alibaba.fastjson.JSON;
import com.wyu.pojo.User;
import com.wyu.pojo.zyb;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Map;

@WebServlet(name = "YSServlet", urlPatterns = "/YSServlet")
public class YSServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        HttpSession session = request.getSession();
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select * from zyb where id=?";
            MapHandler handler = new MapHandler();
            Map<String, Object> map = qr.query(ct, sql, handler, message);
            session.setAttribute("map",map);
            map.forEach((k,v)->{
                if(k.equals("name"))
                    System.out.println("专业名:"+v);
            } );
            String listjson = JSON.toJSONString(map);
            //layui前端要求是要封装成json数据，才可以解析，所以要将list集合中的数据解析成json才可以
            String json = "{\"code\":0,\"msg\":\"\",\"count\":"+100+",\"data\":"+listjson+"}";
            response.getWriter().append(json);
            response.sendRedirect("ysresult.jsp");


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

    }
}
