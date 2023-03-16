package com.wyu.dao;

import com.wyu.pojo.KCB;

import java.util.List;

public interface KCBDao {
 
    
    
    List<KCB> selectByKCBLimit(int start, Integer limit1);


    //查询总记录数
    int selectKCBAllCount();

    int deleteById(String id);
}
