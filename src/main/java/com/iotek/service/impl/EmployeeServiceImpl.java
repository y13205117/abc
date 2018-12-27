package com.iotek.service.impl;

import com.iotek.dao.EmployeeMapper;
import com.iotek.dao.VitaeMapper;
import com.iotek.model.Employee;
import com.iotek.model.Vitae;
import com.iotek.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private VitaeMapper vitaeMapper;
    @Override
    public Employee EMPLogin(String name, String pass) {
        if(name==null || pass==null){
            return null;
        }
        int id = 0;
        try {
            //判断name是否是纯数字
            id = Integer.parseInt("name");
        } catch (NumberFormatException e) {
            return null;
        }
        //通过员工编号登录
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        if(employee!=null){
            //编号存在，则去找对应的简历编号
            Vitae vitae = vitaeMapper.selectByPrimaryKey(employee.getVid());
            if(vitae!=null){
                //判断密码是否与简历出生日期一致
                if(vitae.getBirth().equals(pass)){
                    return employee;
                }
            }
        }
        return null;
    }
}
