package com.iotek.service;

import com.iotek.model.MemberShowCV;
import com.iotek.model.User;

import java.util.List;

public interface MemberShowCVService {
    //投递简历
    boolean saveMemberShowCV(Integer rid,Integer vid);
    //查看投递简历
    List<MemberShowCV> queryByRid(Integer mid);
    //修改状态
    boolean updateMemberShowCV(Integer mid);
    //邀请面试
    int updateInv(Integer mid);
    //查看面试邀请
    List<MemberShowCV> queryByUser(User user);
    //去面试
    boolean updateState(Integer mid);
    //不去去面试
    boolean updateNotState(Integer mid);
}
