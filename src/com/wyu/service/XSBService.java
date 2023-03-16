package com.wyu.service;

import com.wyu.pojo.xsb;

import java.util.List;

public interface XSBService {

    List<xsb> selectXSAll();

    int deteleByXh(String xh);
}
