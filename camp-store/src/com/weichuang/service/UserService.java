package com.weichuang.service;

import com.weichuang.pojo.User;

public interface UserService {
    int registerUser(User user);

    User login(String username, String password);
}
