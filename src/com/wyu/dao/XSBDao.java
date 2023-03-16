package com.wyu.dao;

import com.wyu.pojo.xsb;
import com.wyu.pojo.zyb;

import java.util.List;

public interface XSBDao {
    //删除学生操作
    int deleteByXh(String xh);


    List<xsb> selectXSBAll();
}
