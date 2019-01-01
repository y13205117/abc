package com.iotek.service;

import com.iotek.model.Recruit;

import java.util.List;

public interface RecruitService {
    //查询招聘
    List<Recruit> queryRecruit();
    //查找内容
    Recruit queryRecruitById(Integer id);
}
