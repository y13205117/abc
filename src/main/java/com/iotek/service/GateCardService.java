package com.iotek.service;

import com.iotek.model.GateCard;

import java.util.List;

public interface GateCardService {
    List<GateCard> queryAll();
    //上班打卡
    boolean saveGateCard(Integer eid);
    //下班打卡
    boolean updateGateCard(Integer eid);
}
