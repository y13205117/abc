package com.iotek.service.impl;

import com.iotek.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User queryUser(User user) {
        if(user==null){
            return null;
        }
        return userMapper.queryUser(user);
    }

    @Override
    public boolean saveUser(User user) {
        if(user==null){
            return false;
        }
        return userMapper.saveUser(user);
    }
}
