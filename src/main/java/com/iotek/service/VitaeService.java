package com.iotek.service;


import com.iotek.model.Vitae;

public interface VitaeService {
    //查看个人简历
    Vitae queryByUid(Integer uid);
}
