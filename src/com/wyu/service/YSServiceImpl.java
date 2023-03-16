package com.wyu.service;

import com.wyu.dao.KCBDao;
import com.wyu.dao.KCBDaoImpl;
import com.wyu.dao.YSDao;
import com.wyu.dao.YSDaoImpl;
import com.wyu.pojo.KCB;
import com.wyu.pojo.ghb;
import com.wyu.pojo.yhb;
import com.wyu.pojo.ysb;

import java.util.List;

public class YSServiceImpl implements YSService {
    //寻找医生




    @Override
    public List<ysb> selectYSAll(String page, String limit) {
        //page==1,limit==10,应该查询从0到9条数据
        //page==2，limit==10.应该查询11开始到后面10条数据
        YSDao ys = new YSDaoImpl();
        Integer page1 = Integer.parseInt(page);
        Integer limit1 = Integer.parseInt(limit);


        int start = (page1-1)*limit1;

        List<ysb> list = ys.selectByLimit(start,limit1);

        return list;
    }

    @Override
    public int selectKCBAllCount() {
        YSDao ys = new YSDaoImpl();
        return ys.selectKCBAllCount();
    }


}
