package com.wyu.dao;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.KCB;
import com.wyu.pojo.zyb;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class KCBDaoImpl implements KCBDao {
    @Override
    public int deleteById(String id) {
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "delete from xsb where id=?;";

            int i = qr.update(ct, sql, id);
            return i;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
        return 0;

    }

    @Override
    public List<KCB> selectByKCBLimit(int start, Integer limit1) {


        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select * from kcb limit ?,?; ";
            BeanListHandler<KCB> handler = new BeanListHandler(KCB.class);
            List<KCB> list = qr.query(ct, sql, handler,start,limit1);
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
    public int selectKCBAllCount() {

        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select count(*) count from kcb; ";

            return ((Long) qr.query(ct,sql,new ScalarHandler<>())).intValue();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
        return 0;
    }
}
