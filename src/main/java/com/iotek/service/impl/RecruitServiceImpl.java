package com.iotek.service.impl;

import com.iotek.dao.RecruitMapper;
import com.iotek.model.Recruit;
import com.iotek.model.RecruitExample;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitMapper recruitMapper;
    @Override
    public List<Recruit> queryRecruit() {
        RecruitExample recruitExample=new RecruitExample();
        return recruitMapper.selectByExample(recruitExample);
    }

    @Override
    public Recruit queryRecruitById(Integer id) {
        if(id<=0){
            return null;
        }
        return recruitMapper.selectByPrimaryKey(id);
    }
}
