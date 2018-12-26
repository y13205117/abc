package com.iotek.service.impl;

import com.iotek.dao.EmployeeMapper;
import com.iotek.dao.VitaeMapper;
import com.iotek.model.Employee;
import com.iotek.model.EmployeeExample;
import com.iotek.model.Vitae;
import com.iotek.model.VitaeExample;
import com.iotek.service.VitaeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VitaeServiceImpl implements VitaeService {
    @Resource
    private VitaeMapper vitaeMapper;
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public boolean saveVitae(Vitae vitae) {
        if(vitae==null){
            return false;
        }
        int i = vitaeMapper.insertSelective(vitae);
        return i>0?true:false;
    }

    @Override
    public Vitae queryByUid(Integer uid) {
        if(uid<=0){
            return null;
        }
        VitaeExample vitaeExample=new VitaeExample();
        vitaeExample.createCriteria().andUidEqualTo(uid);
        List<Vitae> vitaes = vitaeMapper.selectByExample(vitaeExample);
        return vitaes.size()>0?vitaes.get(0):null;
    }

    @Override
    public boolean updateVitae(Vitae vitae) {
        if(vitae==null){
            return false;
        }
        EmployeeExample employeeExample=new EmployeeExample();
        employeeExample.createCriteria().andVidEqualTo(vitae.getId());
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        if(employees!=null){
            return false;
        }
        int i =vitaeMapper.updateByPrimaryKey(vitae);
        return i>0?true:false;
    }

    @Override
    public boolean deleteVitae(Integer id) {
        if(id<=0){
            return false;
        }
        EmployeeExample employeeExample=new EmployeeExample();
        employeeExample.createCriteria().andVidEqualTo(id);
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        if(employees!=null){
            return false;
        }
        int i = vitaeMapper.deleteByPrimaryKey(id);
        return i>0?true:false;
    }

    @Override
    public Vitae queryById(Integer id) {
        if(id<=0){
            return null;
        }
        return vitaeMapper.selectByPrimaryKey(id);
    }
}
