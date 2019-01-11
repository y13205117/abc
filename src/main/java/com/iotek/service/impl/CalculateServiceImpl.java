package com.iotek.service.impl;

import com.iotek.dao.AwardRecordMapper;
import com.iotek.dao.CalculateMapper;
import com.iotek.dao.EmployeeMapper;
import com.iotek.dao.GateCardMapper;
import com.iotek.model.*;
import com.iotek.service.CalculateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Resource
    private AwardRecordMapper awardRecordMapper;
    @Resource
    private CalculateMapper calculateMapper;
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private GateCardMapper gateCardMapper;
    @Override
    public boolean saveCalculate(Integer eid) {
        if(eid<=0){
            return false;
        }
        double sum=0.0;
        Calculate calculate=new Calculate();
        Employee employee = employeeMapper.selectByPrimaryKey(eid);
        GateCardExample gateCardExample=new GateCardExample();
        gateCardExample.createCriteria().andEidEqualTo(eid);
        List<GateCard> gateCards = gateCardMapper.selectByExample(gateCardExample);
        if(gateCards.size()<=0){
            return false;
        }else if(gateCards.size()>22){
            //满出勤
            sum=employee.getSalary()+employee.getPerformance()-400;
        }else if(gateCards.size()>14){
            //大于15天扣社保
            sum=employee.getSalary()/22*gateCards.size()+employee.getPerformance()*gateCards.size()-400;
        }else{
            //小于15天不扣社保
            sum=employee.getSalary()/22*gateCards.size()+employee.getPerformance()*gateCards.size();
        }
        AwardRecordExample awardRecordExample=new AwardRecordExample();
        awardRecordExample.createCriteria().andEidEqualTo(eid);
        List<AwardRecord> awardRecords = awardRecordMapper.selectByExample(awardRecordExample);
        if(awardRecords==null || awardRecords.size()<=0){
            calculate.setRealsalay(sum);
        }else{
            for (AwardRecord awardRecord : awardRecords) {
                sum+=awardRecord.getMoney();
            }
            calculate.setRealsalay(sum);
        }
        calculate.setEid(eid);
        calculate.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        calculate.setReconsider(0);
        int i = calculateMapper.insertSelective(calculate);
        CalculateExample calculateExample=new CalculateExample();
        calculateExample.createCriteria().andEidEqualTo(eid).andTimeEqualTo(calculate.getTime());
        List<Calculate> calculates = calculateMapper.selectByExample(calculateExample);
        if(calculates==null || calculates.size()==0){
            return false;
        }
        for (int j = 0; j <awardRecords.size() ; j++) {
            awardRecords.get(j).setCid(calculates.get(0).getId());
            awardRecordMapper.updateByPrimaryKeySelective(awardRecords.get(j));
        }
        return i>0?true:false;
    }

    @Override
    public List<Calculate> queryByEid(Integer eid) {
        if(eid<=0){
            return null;
        }
        CalculateExample calculateExample=new CalculateExample();
        calculateExample.createCriteria().andEidEqualTo(eid);
        return calculateMapper.selectByExample(calculateExample);
    }
}
