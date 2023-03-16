package com.wyu.service;

import com.wyu.dao.*;
import com.wyu.pojo.clb;
import com.wyu.pojo.ghb;
import com.wyu.pojo.xsb;
import com.wyu.pojo.ysb;

import java.util.List;

public class GHServiceImpl implements GHService {




    @Override
    public List<ghb> selectGHAll(String page, String limit) {
        GHDao ys = new GHDaoImpl();
        Integer page1 = Integer.parseInt(page);
        Integer limit1 = Integer.parseInt(limit);


        int start = (page1-1)*limit1;

        List<ghb> list = ys.selectByLimit(start,limit1);

        return list;
    }

    @Override
    public int selecGHBAllCount() {
        GHDao ys = new GHDaoImpl();
        return ys.selectGHBAllCount();
    }

    @Override
    public List<clb> selectCLResultAll() {
        GHDao dao = new GHDaoImpl();
        //查询数据
        List<clb> list = dao.selectGHResultAll();
        return list;
    }
}
