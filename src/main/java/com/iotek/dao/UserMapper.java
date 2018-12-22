package com.iotek.dao;

import com.iotek.model.User;

public interface UserMapper {
    //登录
    User queryUser(User user);
    //注册
    boolean saveUser(User user);
}
