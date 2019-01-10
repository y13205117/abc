package com.iotek.service;

import com.iotek.model.Leave;

import java.util.List;

public interface LeaveService {
    //申请离职
    boolean saveLeave(String cause,Integer eid);
    List<Leave> queryByState();
    //修改状态
    boolean updateLeave(Integer eid);
}
