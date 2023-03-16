package com.wyu.dao;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.zyb;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class ZYBDaoImpl implements ZYBDao {


    @Override
    public List<zyb> selectZYBAll() {
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
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }

        return null;
    }
}
