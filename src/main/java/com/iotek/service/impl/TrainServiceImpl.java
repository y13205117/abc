package com.iotek.service.impl;

import com.iotek.dao.TrainAndDepMapper;
import com.iotek.dao.TrainAndEmpMapper;
import com.iotek.dao.TrainMapper;
import com.iotek.model.*;
import com.iotek.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainMapper trainMapper;
    @Resource
    private TrainAndEmpMapper trainAndEmpMapper;
    @Resource
    private TrainAndDepMapper trainAndDepMapper;
    @Override
    public boolean saveTrain(Train train) {
        if(train==null){
            return false;
        }
        int i = trainMapper.insertSelective(train);
        return i>0?true:false;
    }

    @Override
    public List<Train> queryAll() {
        TrainExample trainExample=new TrainExample();
        return trainMapper.selectByExample(trainExample);
    }

    @Override
    public boolean deleteTrain(Integer id) {
        if(id<=0){
            return false;
        }
        int i = trainMapper.deleteByPrimaryKey(id);
        return i>0?true:false;
    }

    @Override
    public List<Train> queryById(Integer did,Integer eid) {
        List<Train> trains=new ArrayList<>();
        if(did<=0 || eid<=0){
            return null;
        }
        TrainAndDepExample trainAndDepExample=new TrainAndDepExample();
        trainAndDepExample.createCriteria().andDidEqualTo(did);
        List<TrainAndDep> trainAndDeps = trainAndDepMapper.selectByExample(trainAndDepExample);
        TrainAndEmpExample trainAndEmpExample=new TrainAndEmpExample();
        trainAndEmpExample.createCriteria().andEidEqualTo(eid);
        List<TrainAndEmp> trainAndEmps = trainAndEmpMapper.selectByExample(trainAndEmpExample);
        if((trainAndDeps==null || trainAndDeps.size()==0) && (trainAndEmps==null || trainAndEmps.size()==0)){
            return null;
        }else if((trainAndDeps==null || trainAndDeps.size()==0) && (trainAndEmps!=null || trainAndEmps.size()!=0)){
            for (TrainAndEmp trainAndEmp : trainAndEmps) {
                Train train = trainMapper.selectByPrimaryKey(trainAndEmp.getTid());
                trains.add(train);
            }
            return trains;
        }else if((trainAndDeps!=null || trainAndDeps.size()!=0) && (trainAndEmps==null || trainAndEmps.size()==0)){
            for (TrainAndDep trainAndDep : trainAndDeps) {
                Train train = trainMapper.selectByPrimaryKey(trainAndDep.getTid());
                trains.add(train);
            }
            return trains;
        }else{
            for (TrainAndDep trainAndDep : trainAndDeps) {
                for (int i = 0; i <trainAndEmps.size() ; i++) {
                    if(trainAndDep.getTid()==trainAndEmps.get(i).getTid()){
                        trainAndEmps.remove(i);
                    }
                }
                Train train = trainMapper.selectByPrimaryKey(trainAndDep.getTid());
                trains.add(train);
            }
            if(trainAndEmps.size()>0){
                for (TrainAndEmp trainAndEmp : trainAndEmps) {
                    Train train = trainMapper.selectByPrimaryKey(trainAndEmp.getTid());
                    trains.add(train);
                }
                return trains;
            }else{
                return trains;
            }
        }
    }
}
