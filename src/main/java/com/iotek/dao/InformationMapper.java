package com.iotek.dao;

import com.iotek.model.Information;

import java.util.List;

public interface InformationMapper {
    boolean saveInformation(Information information);
    boolean updateInformation(Information information);
    boolean delInformation(int iid);
    Information queryByUid(int uid);
}
