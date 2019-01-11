package com.iotek.service;

import com.iotek.model.TrainAndEmp;

import java.util.List;

public interface TrainAndEmpService {
    //增加员工
    boolean saveEepByEid(TrainAndEmp trainAndEmp);
    //员工id查找
    List<TrainAndEmp> queryTrainAndEmp(TrainAndEmp trainAndEmp);
    //员工部门
    boolean deleteTrainAndEmp(TrainAndEmp trainAndEmp);
}
