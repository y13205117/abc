package com.iotek.service.impl;

import com.iotek.dao.TrainAndDepMapper;
import com.iotek.model.TrainAndDep;
import com.iotek.model.TrainAndDepExample;
import com.iotek.service.TrainAndDepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TrainAndDepServiceImpl implements TrainAndDepService {
    @Resource
    private TrainAndDepMapper trainAndDepMapper;

    @Override
    public boolean saveDepByDid(TrainAndDep trainAndDep) {
        if(trainAndDep==null){
            return false;
        }
        TrainAndDepExample trainAndDepExample=new TrainAndDepExample();
        trainAndDepExample.createCriteria().andDidEqualTo(trainAndDep.getDid())
                .andTidEqualTo(trainAndDep.getTid());
        List<TrainAndDep> trainAndDeps = trainAndDepMapper.selectByExample(trainAndDepExample);
        if(trainAndDeps==null || trainAndDeps.size()==0){
            int i = trainAndDepMapper.insertSelective(trainAndDep);
            return i>0?true:false;
        }
        return false;
    }

    @Override
    public List<TrainAndDep> queryTrainAndDep(Integer did) {
        if(did<=0){
            return null;
        }
        TrainAndDepExample trainAndDepExample=new TrainAndDepExample();
        trainAndDepExample.createCriteria().andDidEqualTo(did);
        return trainAndDepMapper.selectByExample(trainAndDepExample);
    }

    @Override
    public boolean deleteTrainAndDep(TrainAndDep trainAndDep) {
        return false;
    }
}
