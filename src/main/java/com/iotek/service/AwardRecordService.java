package com.iotek.service;

import com.iotek.model.AwardRecord;

import java.util.List;

public interface AwardRecordService {
    //所有奖惩记录
    List<AwardRecord> queryAll();
    //通过员工id查奖惩
    List<AwardRecord> queryByEid(Integer eid);
}
