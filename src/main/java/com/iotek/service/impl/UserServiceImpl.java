package com.iotek.service.impl;

import com.iotek.dao.UserMapper;
import com.iotek.model.User;
import com.iotek.model.UserExample;
import com.iotek.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User queryUser(User user) {
        if(user==null){
            return null;
        }
        UserExample userExample=new UserExample();
        userExample.createCriteria().andNameEqualTo(user.getName()).andPassEqualTo(user.getPass());
        List<User> users = userMapper.selectByExample(userExample);
        return users.size()>0?users.get(0):null;
    }

    @Override
    public boolean saveUser(User user) {
        if(user==null){
            return false;
        }
        int i = userMapper.insertSelective(user);
        return i>0?true:false;
    }
}
