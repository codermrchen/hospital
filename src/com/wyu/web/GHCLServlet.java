package com.wyu.web;

import com.alibaba.druid.util.JdbcUtils;
import com.alibaba.fastjson.JSON;
import com.wyu.pojo.clb;
import com.wyu.pojo.xsb;
import com.wyu.service.GHService;
import com.wyu.service.GHServiceImpl;
import com.wyu.service.XSBService;
import com.wyu.service.XSBServiceImpl;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/GHCLServlet")
public class GHCLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String result = request.getParameter("result");
        HttpSession session = request.getSession(true);

        System.out.println("处理医生"+username+"处理结果"+result);

        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "INSERT INTO clb( username, result) VALUES (?,?);";

            int i = qr.update(ct, sql, username,result);
            if(i>0){
                System.out.println("成功添加"+i+"条数据到clb中");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

        //用service调用数据
        GHService service = new GHServiceImpl();
        //查询所有专业的方法
        List<clb> clb= service.selectCLResultAll();
        session.setAttribute("clb",clb);


        if(clb!=null){
            /*
            String listjson = JSON.toJSONString(clb);
            //layui前端要求是要封装成json数据，才可以解析，所以要将list集合中的数据解析成json才可以
            String json = "{\"code\":0,\"msg\":\"\",\"count\":"+15+",\"data\":"+listjson+"}";
            response.getWriter().append(json); */
            request.getRequestDispatcher("Success.jsp").forward(request, response);
        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
