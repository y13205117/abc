package com.iotek.service.impl;

import com.iotek.dao.MemberShowCVMapper;
import com.iotek.dao.RecruitMapper;
import com.iotek.dao.VitaeMapper;
import com.iotek.model.*;
import com.iotek.service.MemberShowCVService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MemberShowCVServiceImpl implements MemberShowCVService {
    @Resource
    private MemberShowCVMapper memberShowCVMapper;
    @Resource
    private VitaeMapper vitaeMapper;
    @Resource
    private RecruitMapper recruitMapper;
    @Override
    public boolean saveMemberShowCV(Integer rid, Integer vid) {
        if(rid<=0 || vid<=0){
            return false;
        }
        //判重
        MemberShowCVExample memberShowCVExample=new MemberShowCVExample();
        memberShowCVExample.createCriteria().andRidEqualTo(rid).andVidEqualTo(vid);
        List<MemberShowCV> memberShowCVS = memberShowCVMapper.selectByExample(memberShowCVExample);
        if(memberShowCVS==null || memberShowCVS.size()==0){
            //投递简历
            MemberShowCV memberShowCV=new MemberShowCV();
            memberShowCV.setRid(rid);
            memberShowCV.setVid(vid);
            memberShowCV.setState(0);
            memberShowCV.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            int i = memberShowCVMapper.insertSelective(memberShowCV);
            return i>0?true:false;
        }
        return false;
    }

    @Override
    public List<MemberShowCV> queryByRid(Integer mid) {
        if(mid<=0){
            return null;
        }
        MemberShowCVExample memberShowCVExample=new MemberShowCVExample();
        memberShowCVExample.createCriteria().andRidEqualTo(mid);
        return memberShowCVMapper.selectByExample(memberShowCVExample);
    }

    @Override
    public boolean updateMemberShowCV(Integer mid) {
        if(mid<=0){
            return false;
        }
        MemberShowCV memberShowCV = memberShowCVMapper.selectByPrimaryKey(mid);
        if(memberShowCV.getState()==1){
            return false;
        }else if(memberShowCV.getState()==2){
            return false;
        }
        //已读状态
        memberShowCV.setState(1);
        int i = memberShowCVMapper.updateByPrimaryKeySelective(memberShowCV);
        return i>0?true:false;
    }

    @Override
    public int updateInv(Integer mid) {
        if(mid<=0){
            return 0;
        }
        MemberShowCV memberShowCV = memberShowCVMapper.selectByPrimaryKey(mid);
        if(memberShowCV.getState()==2){
            return 1;
        }
        memberShowCV.setState(2);
        int i = memberShowCVMapper.updateByPrimaryKeySelective(memberShowCV);
        return i>0?2:3;
    }

    @Override
    public List<MemberShowCV> queryByUser(User user) {
        if(user==null){
            return null;
        }
        VitaeExample vitaeExample=new VitaeExample();
        vitaeExample.createCriteria().andUidEqualTo(user.getId());
        List<Vitae> vitaes = vitaeMapper.selectByExample(vitaeExample);
        if(vitaes==null ||vitaes.size()==0){
            return null;
        }
        Vitae vitae=vitaes.get(0);
        MemberShowCVExample memberShowCVExample=new MemberShowCVExample();
        //2位邀请面试
        memberShowCVExample.createCriteria().andVidEqualTo(vitae.getId()).andStateEqualTo(2);
        return memberShowCVMapper.selectByExample(memberShowCVExample);
    }

    @Override
    public boolean updateState(Integer mid) {
        if(mid<=0){
            return false;
        }
        MemberShowCV memberShowCV = memberShowCVMapper.selectByPrimaryKey(mid);
        //3为用户去面试
        memberShowCV.setState(3);
        int i = memberShowCVMapper.updateByPrimaryKeySelective(memberShowCV);
        return i>0?true:false;
    }

    @Override
    public boolean updateNotState(Integer mid) {
        if(mid<=0){
            return false;
        }
        MemberShowCV memberShowCV = memberShowCVMapper.selectByPrimaryKey(mid);
        //4为用户不去面试
        memberShowCV.setState(4);
        int i = memberShowCVMapper.updateByPrimaryKeySelective(memberShowCV);
        return i>0?true:false;
    }

    @Override
    public List<MemberShowCV> queryByJid(Integer jid) {
        if(jid<=0){
            return null;
        }
        RecruitExample recruitExample=new RecruitExample();
        recruitExample.createCriteria().andJidEqualTo(jid);
        //通过职位Id找招聘
        List<Recruit> recruits = recruitMapper.selectByExample(recruitExample);
        if(recruits==null || recruits.size()==0){
            return null;
        }
        Recruit recruit=recruits.get(0);
        MemberShowCVExample memberShowCVExample=new MemberShowCVExample();
        memberShowCVExample.createCriteria().andRidEqualTo(recruit.getId()).andStateEqualTo(3);
        return memberShowCVMapper.selectByExample(memberShowCVExample);
    }
}
