package com.iotek.service;

import com.iotek.model.Train;

import java.util.List;

public interface TrainService {
    boolean saveTrain(Train train);
    List<Train> queryAll();
    boolean deleteTrain(Integer id);
    List<Train> queryById(Integer did,Integer eid);
}
