package com.iotek.service.impl;

import com.iotek.dao.DepartmentMapper;
import com.iotek.dao.JobMapper;
import com.iotek.dao.RecruitMapper;
import com.iotek.model.*;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitMapper recruitMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private JobMapper jobMapper;
    @Override
    public boolean saveRecruit(Recruit recruit) {
        if(recruit==null){
            return false;
        }
        RecruitExample recruitExample=new RecruitExample();
        recruitExample.createCriteria().andDidEqualTo(recruit.getDid()).andJidEqualTo(recruit.getJid());
        List<Recruit> recruits = recruitMapper.selectByExample(recruitExample);
        if(recruits==null || recruits.size()==0){
            recruit.setReleasetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            int i = recruitMapper.insertSelective(recruit);
            return i>0?true:false;
        }
        return false;
    }

    @Override
    public List<Recruit2> queryRecruit() {
        List<Recruit2> recruit2s=new ArrayList<>();
        RecruitExample recruitExample=new RecruitExample();
        List<Recruit> recruits = recruitMapper.selectByExample(recruitExample);
        for (Recruit recruit : recruits) {
            Department department = departmentMapper.selectByPrimaryKey(recruit.getDid());
            Job job = jobMapper.selectByPrimaryKey(recruit.getJid());
            Recruit2 recruit2=new Recruit2();
            recruit2.setRecruit(recruit);
            recruit2.setDepartment(department);
            recruit2.setJob(job);
            recruit2s.add(recruit2);
        }
        return recruit2s;
    }

    @Override
    public Recruit2 queryRecruitById(Integer id) {
        if(id<=0){
            return null;
        }
        Recruit recruit = recruitMapper.selectByPrimaryKey(id);
        Department department = departmentMapper.selectByPrimaryKey(recruit.getDid());
        Job job = jobMapper.selectByPrimaryKey(recruit.getJid());
        Recruit2 recruit2=new Recruit2();
        recruit2.setRecruit(recruit);
        recruit2.setDepartment(department);
        recruit2.setJob(job);
        return recruit2;
    }

    @Override
    public Recruit queryById(Integer id) {
        if(id<=0){
            return null;
        }
        return recruitMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Recruit2> queryByJidAndDid(Integer jid, Integer did) {
        if(jid<=0 ||did<=0){
            return null;
        }
        List<Recruit2> recruit2s=new ArrayList<>();
        RecruitExample recruitExample=new RecruitExample();
        recruitExample.createCriteria().andJidEqualTo(jid).andDidEqualTo(did);
        List<Recruit> recruits = recruitMapper.selectByExample(recruitExample);
        if(recruits==null || recruits.size()==0){
            return null;
        }else{
            for (Recruit recruit : recruits) {
                Department department = departmentMapper.selectByPrimaryKey(recruit.getDid());
                Job job = jobMapper.selectByPrimaryKey(recruit.getJid());
                Recruit2 recruit2=new Recruit2();
                recruit2.setRecruit(recruit);
                recruit2.setDepartment(department);
                recruit2.setJob(job);
                recruit2s.add(recruit2);
            }
            return recruit2s;
        }
    }
}
