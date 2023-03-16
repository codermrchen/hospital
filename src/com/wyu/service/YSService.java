package com.wyu.service;

import com.wyu.pojo.ghb;
import com.wyu.pojo.ysb;

import java.util.List;

public interface YSService {




    List<ysb> selectYSAll(String page, String limit);

    int selectKCBAllCount();


}
