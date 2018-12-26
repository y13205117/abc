package com.iotek.service;


import com.iotek.model.Vitae;

public interface VitaeService {
    //增加简历
    boolean saveVitae(Vitae vitae);
    //查看个人简历
    Vitae queryByUid(Integer uid);
}
