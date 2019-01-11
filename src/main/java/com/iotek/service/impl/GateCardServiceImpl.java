package com.iotek.service.impl;

import com.iotek.dao.AwardRecordMapper;
import com.iotek.dao.GateCardMapper;
import com.iotek.model.AwardRecord;
import com.iotek.model.GateCard;
import com.iotek.model.GateCardExample;
import com.iotek.service.GateCardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class GateCardServiceImpl implements GateCardService {
    @Resource
    private GateCardMapper gateCardMapper;
    @Resource
    private AwardRecordMapper awardRecordMapper;
    @Override
    public List<GateCard> queryAll() {
        GateCardExample gateCardExample=new GateCardExample();
        return gateCardMapper.selectByExample(gateCardExample);
    }

    @Override
    public boolean saveGateCard(Integer eid) {
        if(eid<=0){
            return false;
        }
        //查询是否重复打卡
        GateCardExample gateCardExample=new GateCardExample();
        gateCardExample.createCriteria().andDateEqualTo(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .andEidEqualTo(eid);
        List<GateCard> gateCards = gateCardMapper.selectByExample(gateCardExample);
        if(gateCards==null || gateCards.size()==0){
            GateCard gateCard=new GateCard();
            gateCard.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            gateCard.setOfficehours(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            gateCard.setEid(eid);
            int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            if(hour>=9){
                //迟到奖惩
                AwardRecord awardRecord=new AwardRecord();
                awardRecord.setCause("迟到");
                awardRecord.setMoney(-50);
                awardRecord.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                awardRecord.setEid(eid);
                awardRecordMapper.insertSelective(awardRecord);
            }
            int i = gateCardMapper.insertSelective(gateCard);
            return i>0?true:false;
        }
        return false;
    }

    @Override
    public boolean updateGateCard(Integer eid) {
        if(eid<=0){
            return false;
        }
        GateCardExample gateCardExample=new GateCardExample();
        gateCardExample.createCriteria().andDateEqualTo(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .andEidEqualTo(eid);
        List<GateCard> gateCards = gateCardMapper.selectByExample(gateCardExample);
        if(gateCards==null || gateCards.size()==0){
            //判断是否无效打卡
            return false;
        }else if(gateCards.get(0).getAfterhours()!=null){
            //判断是否重复打卡
            return false;
        }
        GateCard gateCard = gateCards.get(0);
        gateCard.setAfterhours(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if(hour<18){
            //早退奖惩
            AwardRecord awardRecord=new AwardRecord();
            awardRecord.setCause("早退");
            awardRecord.setMoney(-50);
            awardRecord.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            awardRecord.setEid(eid);
            awardRecordMapper.insertSelective(awardRecord);
        }
        int i = gateCardMapper.updateByPrimaryKeySelective(gateCard);
        return i>0?true:false;
    }
}
