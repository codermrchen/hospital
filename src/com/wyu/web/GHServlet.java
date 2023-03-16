package com.wyu.web;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.service.XSBService;
import com.wyu.service.XSBServiceImpl;
import com.wyu.service.YSService;
import com.wyu.service.Yhbservice;
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

@WebServlet("/GHServlet")
public class GHServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获得要删除的学生
        String ysbh = request.getParameter("ysbh");//医生编号
        System.out.println("要挂的医生的编号是"+ysbh);

        String gh = "挂号成功，请耐心等待并刷新页面查询结果";

        //


        String username = request.getParameter("username");
        String sj = request.getParameter("sj");
        String hospital = request.getParameter("hospital");
        String office = request.getParameter("office");
        String doctor = request.getParameter("doctor");
        String reason = request.getParameter("reason");



        System.out.println(username+"要挂"+hospital+office+doctor+"的号,问诊时间是"+sj+"病因"+reason);

        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "INSERT INTO ghb( username, sj, hospital,office,doctor,reason) VALUES (?,?,?,?,?,?);";

            int i = qr.update(ct, sql, username,sj,hospital,office,doctor,reason);
            if(i>0){
                System.out.println("成功添加"+i+"条数据");
                request.setAttribute("gh",gh);
                request.getRequestDispatcher("Success.jsp").forward(request, response);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
