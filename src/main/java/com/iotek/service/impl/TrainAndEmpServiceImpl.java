package com.iotek.service.impl;

import com.iotek.dao.TrainAndEmpMapper;
import com.iotek.model.TrainAndEmp;
import com.iotek.model.TrainAndEmpExample;
import com.iotek.service.TrainAndEmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TrainAndEmpServiceImpl implements TrainAndEmpService {
    @Resource
    private TrainAndEmpMapper trainAndEmpMapper;


    @Override
    public boolean saveEepByEid(TrainAndEmp trainAndEmp) {
        if(trainAndEmp==null){
            return false;
        }
        TrainAndEmpExample trainAndEmpExample=new TrainAndEmpExample();
        trainAndEmpExample.createCriteria().andEidEqualTo(trainAndEmp.getEid())
                .andTidEqualTo(trainAndEmp.getTid());
        List<TrainAndEmp> trainAndEmps = trainAndEmpMapper.selectByExample(trainAndEmpExample);
        if(trainAndEmps==null || trainAndEmps.size()==0){
            int i = trainAndEmpMapper.insertSelective(trainAndEmp);
            return i>0?true:false;
        }
        return false;
    }

    @Override
    public List<TrainAndEmp> queryTrainAndEmp(TrainAndEmp trainAndEmp) {
        return null;
    }

    @Override
    public boolean deleteTrainAndEmp(TrainAndEmp trainAndEmp) {
        return false;
    }
}
