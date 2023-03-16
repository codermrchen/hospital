package com.wyu.service;

import com.wyu.dao.yhbDao;
import com.wyu.dao.yhbDaoImpl;
import com.wyu.pojo.yhb;

public class YhbserviceImpl implements Yhbservice {
    @Override
    public yhb login(String mz, String mm) {
        //用dao方法操纵数据库
        yhbDao dao = new yhbDaoImpl();
        //通过学号查询用户名
        yhb yh = dao.findByMz(mz);
        if(yh !=null){
            return yh;
        }else {
            return null;
        }

    }

    @Override
    public int deteleById(String id) {
        yhbDao yhbDao = new yhbDaoImpl();
        return  yhbDao.deteleById(id);
    }
}
