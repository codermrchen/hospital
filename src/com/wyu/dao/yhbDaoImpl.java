package com.wyu.dao;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.yhb;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;

public class yhbDaoImpl implements yhbDao {
    @Override
    public yhb findByMz(String mz) {
        Connection ct = null;
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select * from yhb where username=?";
            BeanHandler<yhb> handler = new BeanHandler(yhb.class);
            yhb yh = qr.query(ct, sql, handler,mz);
            System.out.println("成功查询到"+yh);
            return yh;



        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
        return null;
    }

    @Override
    public int deteleById(String id) {
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "delete from zyb where id=?;";

            int i = qr.update(ct, sql, id);
            return i;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
        return 0;

    }
}
