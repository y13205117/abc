package com.iotek.service.impl;

import com.iotek.dao.AwardRecordMapper;
import com.iotek.model.AwardRecord;
import com.iotek.model.AwardRecordExample;
import com.iotek.service.AwardRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AwardRecordServiceImpl implements AwardRecordService {
    @Resource
    private AwardRecordMapper awardRecordMapper;
    @Override
    public List<AwardRecord> queryAll() {
        AwardRecordExample awardRecordExample=new AwardRecordExample();
        return awardRecordMapper.selectByExample(awardRecordExample);
    }

    @Override
    public List<AwardRecord> queryByEid(Integer eid) {
        if(eid<=0){
            return null;
        }
        AwardRecordExample awardRecordExample=new AwardRecordExample();
        awardRecordExample.createCriteria().andEidEqualTo(eid);
        return awardRecordMapper.selectByExample(awardRecordExample);
    }
}
