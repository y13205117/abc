package com.iotek.service;

public interface UserService {
    //登录
    User queryUser(User user);
    //注册
    boolean saveUser(User user);
}
