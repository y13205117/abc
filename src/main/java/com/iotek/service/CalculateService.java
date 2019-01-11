package com.iotek.service;

import com.iotek.model.Calculate;

import java.util.List;

public interface CalculateService {
    boolean saveCalculate(Integer eid);
    List<Calculate> queryByEid(Integer eid);
}
