package com.weichuang.service.impl;

import com.weichuang.dao.UserDao;
import com.weichuang.pojo.User;
import com.weichuang.service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDao();
    }

    /**
     * 注册用户的方法
     * @param user
     * @return
     */
    @Override
    public int registerUser(User user) {
        user.setUid(UUID.randomUUID().toString().replace("-",""));
        return userDao.registerUser(user);
    }
}
