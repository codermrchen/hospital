package com.wyu.service;

import com.wyu.pojo.KCB;

import java.util.List;

public interface KCBService {
    List<KCB> selectKCAll(String page, String limit);

    int selectKCBAllCount();
//删除课程
    int deleteById(String id);
}
