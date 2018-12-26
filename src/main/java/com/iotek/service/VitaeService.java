package com.iotek.service;


import com.iotek.model.Vitae;

public interface VitaeService {
    //增加简历
    boolean saveVitae(Vitae vitae);
    //查看个人简历
    Vitae queryByUid(Integer uid);
    //修改简历
    boolean updateVitae(Vitae vitae);
    //删除简历
    boolean deleteVitae(Integer id);
    //查询简历
    Vitae queryById(Integer id);
}
