package com.wyu.service;

import com.wyu.dao.XSBDao;
import com.wyu.dao.XSBDaoImpl;
import com.wyu.dao.ZYBDao;
import com.wyu.dao.ZYBDaoImpl;
import com.wyu.pojo.xsb;
import com.wyu.pojo.zyb;

import java.util.List;

public class XSBServiceImpl implements XSBService {


    @Override
    public List<xsb> selectXSAll() {
        XSBDao dao = new XSBDaoImpl();
        //查询数据
        List<xsb> list = dao.selectXSBAll();
        return list;
    }

    @Override
    public int deteleByXh(String xh) {
        XSBDao xsbDao = new XSBDaoImpl();
        return xsbDao.deleteByXh(xh);
    }
}
