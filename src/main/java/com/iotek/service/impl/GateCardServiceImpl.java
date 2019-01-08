package com.iotek.service.impl;

import com.iotek.dao.GateCardMapper;
import com.iotek.model.GateCard;
import com.iotek.model.GateCardExample;
import com.iotek.service.GateCardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GateCardServiceImpl implements GateCardService {
    @Resource
    private GateCardMapper gateCardMapper;
    @Override
    public List<GateCard> queryAll() {
        GateCardExample gateCardExample=new GateCardExample();
        return gateCardMapper.selectByExample(gateCardExample);
    }
}
