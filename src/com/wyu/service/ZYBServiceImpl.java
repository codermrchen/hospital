package com.wyu.service;

import com.wyu.dao.YSDao;
import com.wyu.dao.YSDaoImpl;
import com.wyu.dao.ZYBDao;
import com.wyu.dao.ZYBDaoImpl;
import com.wyu.pojo.zyb;

import java.util.List;

public class ZYBServiceImpl implements ZYBService {
    @Override
    public List<zyb> selectZyAll() {
        //到dao层查询数据
        ZYBDao dao = new ZYBDaoImpl();
        //查询数据
       List<zyb> list = dao.selectZYBAll();
        return list;
    }




}
