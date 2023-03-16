package com.wyu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
//封装一个获得连接的工具类，此处是配置的数据资源的
public class CtUtil {
    public static Connection getConnection() throws Exception {
        //创建一个Properties类，用来读取配置文件
        Properties per = new Properties();//是map下的一个子集合，是唯一可以持久化的集合
        //得到配置文件的输入流
        InputStream is = CtUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        //将流装载到配置文件类中
        per.load(is);
        //获取DataSource数据资源对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(per);
        //获得数据库连接
        Connection connection = dataSource.getConnection();
        return connection;
    }
}




//jdbc步骤
//1.加载驱动
//2.获得连接
//注意：数据库连接池仅仅是处理数据库jdbc之前的操作，对数据库的增删改查是无关的
//如果要对数据库进行增删改查可以用觉得不错，第三方工具类，框架：mybatis
//这三种方式和配置数据源无关，也就是这三种方式去操作数据库都可以配置数据库连接池


//3获得发送SQL对象
//4发送sql语句
//5获得结果
//6关闭资源

