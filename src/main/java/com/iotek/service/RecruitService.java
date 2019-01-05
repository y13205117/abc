package com.iotek.service;

import com.iotek.model.Recruit;
import com.iotek.model.Recruit2;

import java.util.List;

public interface RecruitService {
    //发布招聘
    boolean saveRecruit(Recruit recruit);
    //查询招聘
    List<Recruit2> queryRecruit();
    //查找内容
    Recruit2 queryRecruitById(Integer id);
    //查找内容
    Recruit queryById(Integer id);
    //根据部门id查询
    List<Recruit2> queryByJidAndDid(Integer jid,Integer did);
}
