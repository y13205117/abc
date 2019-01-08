package com.iotek.service.impl;

import com.iotek.dao.TrainMapper;
import com.iotek.model.Train;
import com.iotek.model.TrainExample;
import com.iotek.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainMapper trainMapper;
    @Override
    public List<Train> queryAll() {
        TrainExample trainExample=new TrainExample();
        return trainMapper.selectByExample(trainExample);
    }
}
