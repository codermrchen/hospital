package com.wyu.test;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.yhb;
import com.wyu.pojo.zyb;
import com.wyu.util.CtUtil;
import com.wyu.web.RegisterServlet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class CRUDTest {
    @Test
    //添加数据
    public void insert(){
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
    //添加数据
            String sql = "INSERT INTO zyb( zym, rs, fdy) VALUES (?,?,?);";

            int i = qr.update(ct, sql, "天道", 90, "麻瓜的烦恼");
            if(i>0){
                System.out.println("成功添加"+i+"条数据");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

    }

    //修改数据
    @Test
    public void updateTest(){
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "update user set password=? where username=?;";

            int i = qr.update(ct, sql, "12345","11");
            if(i>0){
                System.out.println("成功修改"+i+"条数据");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

    }


//删除数据
    @Test
    public void DeleteTest(){
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "delete from zyb where id=?;";

            int i = qr.update(ct, sql, 7);
            if(i>0){
                System.out.println("成功删除"+i+"条数据");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

    }

//查询数据——普通查询一条数据
    @Test
    public void SelectTest(){
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select * from zyb where id=?";
            MapHandler handler = new MapHandler();
            Map<String, Object> map = qr.query(ct, sql, handler, 2);
            map.forEach((k,v)->{
                if(k.equals("zym"))
                    System.out.println("专业名:"+v);
            } );


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

    }


    //查询一条数据，普通查询多条数据
    @Test
    public void SelectTest2(){
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select * from zyb ";
            MapListHandler handler = new MapListHandler();
            List<Map<String, Object>> list = qr.query(ct, sql, handler);
            list.forEach(li-> System.out.println(li));


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

    }


    //查询数据，普通查询单条数据，用对象接收
    @Test
    public void SelectTest3(){
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select * from zyb where username=?";
            BeanHandler<yhb> handler = new BeanHandler(yhb.class);
            yhb yhb = qr.query(ct, sql, handler,"啊东");
            System.out.println("成功查询到"+yhb);



        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

    }


    //查询数据，查询多条数据，用对象接收
    @Test
    public void SelectTest4(){
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select * from zyb ";
            BeanListHandler<zyb> handler = new BeanListHandler(zyb.class);
            List<zyb> list = qr.query(ct, sql, handler);
            list.forEach(li-> System.out.println(li));

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

    }



    //查询数据，查询多条数据，用对象接收
    @Test
    public void SelectTest5(){
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select * from yhb ";
            BeanListHandler<yhb> handler = new BeanListHandler(yhb.class);
            List<yhb> list = qr.query(ct, sql, handler);
            list.forEach(li-> System.out.println(li));




        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

    }

@Test
    public void insert1(){
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "INSERT INTO yhb( username, password) VALUES (?,?);";

            int i = qr.update(ct, sql, "啊东","1234" );
            if(i>0){
                System.out.println("成功添加"+i+"条数据");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

    }




}
