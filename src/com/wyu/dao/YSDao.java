package com.wyu.dao;

import com.wyu.pojo.ysb;

import java.util.List;

public interface YSDao {
    List<ysb> selectByLimit(int start, Integer limit1);

    int selectKCBAllCount();


}
