package com.wyu.service;

import com.wyu.dao.KCBDao;
import com.wyu.dao.KCBDaoImpl;
import com.wyu.pojo.KCB;

import java.util.List;

public class KCBServiceImpl implements KCBService {
    @Override
    public List<KCB> selectKCAll(String page, String limit) {
        //page==1,limit==10,应该查询从0到9条数据
        //page==2，limit==10.应该查询11开始到后面10条数据
        KCBDao kd = new KCBDaoImpl();
        Integer page1 = Integer.parseInt(page);
        Integer limit1 = Integer.parseInt(limit);


        int start = (page1-1)*limit1;

        List<KCB> list = kd.selectByKCBLimit(start,limit1);

        return list;
    }

    @Override
    public int selectKCBAllCount() {
        KCBDao kd = new KCBDaoImpl();
        return kd.selectKCBAllCount();
    }

    @Override
    public int deleteById(String id) {
        KCBDao kd = new KCBDaoImpl();
        return kd.deleteById(id);
    }
}
