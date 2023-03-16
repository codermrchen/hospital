package com.wyu.dao;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.clb;
import com.wyu.pojo.ghb;
import com.wyu.pojo.xsb;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class GHDaoImpl implements GHDao {
    @Override
    public List<ghb> selectByLimit(int start, Integer limit1) {
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select * from ghb limit ?,?; ";
            BeanListHandler<ghb> handler = new BeanListHandler(ghb.class);
            List<ghb> list = qr.query(ct, sql, handler,start,limit1);
            list.forEach(li-> System.out.println(li));
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

        return null;
    }

    @Override
    public int selectGHBAllCount() {
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select count(*) count from ghb; ";

            return ((Long) qr.query(ct,sql,new ScalarHandler<>())).intValue();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
        return 0;
    }

    @Override
    public List<clb> selectGHResultAll() {
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select * from clb ";
            BeanListHandler<clb> handler = new BeanListHandler(clb.class);
            List<clb> list = qr.query(ct, sql, handler);
            list.forEach(li-> System.out.println(li));
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

        return null;
    }


}
