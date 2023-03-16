package com.wyu.dao;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.xsb;
import com.wyu.pojo.zyb;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class XSBDaoImpl implements XSBDao {
    //删除学生信息
    @Override
    public int deleteByXh(String xh) {
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "delete from xsb where xh=?;";

            int i = qr.update(ct, sql, xh);
          return i;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
        return 0;
    }

    @Override
    public List<xsb> selectXSBAll() {
        Connection ct = null;
        //获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            //添加数据
            String sql = "select * from xsb ";
            BeanListHandler<xsb> handler = new BeanListHandler(xsb.class);
            List<xsb> list = qr.query(ct, sql, handler);
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
