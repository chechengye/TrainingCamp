package com.weichuang.dao;

import com.weichuang.pojo.User;
import com.weichuang.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    private QueryRunner qr;
    public UserDao(){
        qr = new QueryRunner(C3P0Util.getDataSource());
    }

    public int registerUser(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        try {
            int rows = qr.update(sql , user.getUid() , user.getUsername()
                    , user.getPassword() , user.getName() , user.getEmail() , null , user.getBirthday() , user.getSex() , 0 , user.getCode());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public User login(String username, String password) {
        String sql = "select u.uid , u.name from user u where username = ? and password = ?";
        try {
            return qr.query(sql , new BeanHandler<>(User.class) , username , password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
