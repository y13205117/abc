package com.iotek.service.impl;

import com.iotek.dao.InformationMapper;
import com.iotek.model.Information;
import com.iotek.service.InformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InformationServiceImpl implements InformationService {
    @Resource
    private InformationMapper informationMapper;
    @Override
    public boolean saveInformation(Information information) {
        if(information==null){
            return false;
        }
        return informationMapper.saveInformation(information);
    }

    @Override
    public boolean updateInformation(Information information) {
        if(information==null){
            return false;
        }
        return informationMapper.updateInformation(information);
    }

    @Override
    public boolean delInformation(int iid) {
        if(iid<=0){
            return false;
        }
        return informationMapper.delInformation(iid);
    }

    @Override
    public Information queryByUid(int uid) {
        if(uid<=0){
            return null;
        }
        return informationMapper.queryByUid(uid);
    }
}
