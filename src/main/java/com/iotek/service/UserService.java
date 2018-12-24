package com.iotek.service;

import com.iotek.model.User;

public interface UserService {
    //登录
    User queryUser(User user);
    //注册
    boolean saveUser(User user);
}
