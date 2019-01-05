package com.iotek.service.impl;

import com.iotek.dao.MemberShowCVMapper;
import com.iotek.model.MemberShowCV;
import com.iotek.model.MemberShowCVExample;
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
    public List<MemberShowCV> queryByRid(Integer rid) {
        if(rid<=0){
            return null;
        }
        MemberShowCVExample memberShowCVExample=new MemberShowCVExample();
        memberShowCVExample.createCriteria().andRidEqualTo(rid);
        return memberShowCVMapper.selectByExample(memberShowCVExample);
    }
}
