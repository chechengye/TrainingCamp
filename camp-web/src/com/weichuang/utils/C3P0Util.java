package com.weichuang.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0连接池工具类
 * 在大量并发下，也有一定的保证
 */
public class C3P0Util {
    private static ComboPooledDataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource();//默认去src根目录下面寻找c3p0-config.xml
    }
    /**
     * 获取数据源
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取连接
     */
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
