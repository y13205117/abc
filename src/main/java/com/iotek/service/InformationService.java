package com.iotek.service;

import com.iotek.model.Information;

public interface InformationService {
    //添加个人信息
    boolean saveInformation(Information information);
    //修改个人信息
    boolean updateInformation(Information information);
    //删除个人信息
    boolean delInformation(int iid);
    //查询个人信息
    Information queryByUid(int uid);
}
