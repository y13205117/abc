package com.iotek.service.impl;

import com.iotek.dao.VitaeMapper;
import com.iotek.model.Vitae;
import com.iotek.model.VitaeExample;
import com.iotek.service.VitaeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VitaeServiceImpl implements VitaeService {
    @Resource
    private VitaeMapper vitaeMapper;
    @Override
    public Vitae queryByUid(Integer uid) {
        if(uid<=0){
            return null;
        }
        VitaeExample vitaeExample=new VitaeExample();
        vitaeExample.createCriteria().andUidEqualTo(uid);
        List<Vitae> vitaes = vitaeMapper.selectByExample(vitaeExample);
        return vitaes.size()>0?vitaes.get(0):null;
    }
}
