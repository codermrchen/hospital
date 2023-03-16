package com.wyu.dao;

import com.wyu.pojo.clb;
import com.wyu.pojo.ghb;

import java.util.List;

public interface GHDao {
    List<ghb> selectByLimit(int start, Integer limit1);

    int selectGHBAllCount();

    List<clb> selectGHResultAll();


}
