package com.iotek.service.impl;

import com.iotek.dao.EmployeeMapper;
import com.iotek.dao.LeaveMapper;
import com.iotek.model.Employee;
import com.iotek.model.EmployeeExample;
import com.iotek.model.Leave;
import com.iotek.model.LeaveExample;
import com.iotek.service.LeaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Resource
    private LeaveMapper leaveMapper;
    @Resource
    private EmployeeMapper employeeMapper;
    @Override
    public boolean saveLeave(String cause,Integer eid) {
        if(cause==null ||eid<=0){
            return false;
        }
        Leave leave=new Leave();
        leave.setCause(cause);
        leave.setEid(eid);
        leave.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        leave.setState(0);
        int i = leaveMapper.insertSelective(leave);
        return i>0?true:false;
    }

    @Override
    public List<Leave> queryByState() {
        LeaveExample leaveExample=new LeaveExample();
        leaveExample.createCriteria().andStateEqualTo(0);
        List<Leave> leaves = leaveMapper.selectByExample(leaveExample);
        if(leaves==null || leaves.size()==0){
            return null;
        }
        return leaves;
    }

    @Override
    public boolean updateLeave(Integer eid) {
        if(eid<=0){
            return false;
        }
        LeaveExample leaveExample=new LeaveExample();
        leaveExample.createCriteria().andEidEqualTo(eid);
        List<Leave> leaves = leaveMapper.selectByExample(leaveExample);
        Leave leave=leaves.get(0);
        leave.setState(1);
        int i = leaveMapper.updateByPrimaryKeySelective(leave);
        int i1 = employeeMapper.deleteByPrimaryKey(eid);
        if(i>0 && i1>0){
            return true;
        }
        return false;
    }
}
