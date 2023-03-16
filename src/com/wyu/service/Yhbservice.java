package com.wyu.service;

import com.wyu.pojo.yhb;

public interface   Yhbservice {


    //登录的抽象方法
    yhb login(String mz, String mm);
//删除课程通过课程id
    int deteleById(String id);
}
