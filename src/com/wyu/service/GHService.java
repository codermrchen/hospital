package com.wyu.service;

import com.wyu.pojo.clb;
import com.wyu.pojo.ghb;

import java.util.List;

public interface GHService {






    List<ghb> selectGHAll(String page, String limit);


    int selecGHBAllCount();

    List<clb> selectCLResultAll();
}
