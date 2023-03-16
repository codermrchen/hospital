package com.wyu.dao;

import com.wyu.pojo.yhb;

public interface yhbDao {


    yhb findByMz(String mz);

    int deteleById(String id);
}
