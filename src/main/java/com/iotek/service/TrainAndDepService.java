package com.iotek.service;

import com.iotek.model.TrainAndDep;

import java.util.List;

public interface TrainAndDepService {
    //增加部门
    boolean saveDepByDid(TrainAndDep trainAndDep);
    //部门id查找
    List<TrainAndDep> queryTrainAndDep(TrainAndDep trainAndDep);
    //删除部门
    boolean deleteTrainAndDep(TrainAndDep trainAndDep);
}
