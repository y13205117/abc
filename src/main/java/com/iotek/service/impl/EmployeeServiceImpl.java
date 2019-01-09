package com.iotek.service.impl;

import com.iotek.dao.DepartmentMapper;
import com.iotek.dao.EmployeeMapper;
import com.iotek.dao.JobMapper;
import com.iotek.dao.VitaeMapper;
import com.iotek.model.*;
import com.iotek.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private VitaeMapper vitaeMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private JobMapper jobMapper;
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

    @Override
    public List<Employee2> queryEMP(Employee employee) {
        List<Employee2> employee2s=new ArrayList<>();
        if(employee==null){
            return null;
        }
        EmployeeExample employeeExample=new EmployeeExample();
        employeeExample.createCriteria().andDidEqualTo(employee.getDid()).andJidEqualTo(employee.getJid());
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        if(employees!=null || employees.size()>0){
            for (Employee employee1 : employees) {
                Vitae vitae = vitaeMapper.selectByPrimaryKey(employee1.getVid());
                Department department = departmentMapper.selectByPrimaryKey(employee1.getDid());
                Job job = jobMapper.selectByPrimaryKey(employee1.getJid());
                Employee2 employee2=new Employee2();
                employee2.setEmployee(employee1);
                employee2.setVitae(vitae);
                employee2.setDepartment(department);
                employee2.setJob(job);
                employee2s.add(employee2);
            }
            return employee2s;
        }
        return null;
    }

    @Override
    public Employee2 queryEmpById(Integer id) {
        Employee2 employee2s=new Employee2();
        if(id<=0){
            return null;
        }
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        if(employee!=null){
            Vitae vitae = vitaeMapper.selectByPrimaryKey(employee.getVid());
            Department department = departmentMapper.selectByPrimaryKey(employee.getDid());
            Job job = jobMapper.selectByPrimaryKey(employee.getJid());
            employee2s.setEmployee(employee);
            employee2s.setVitae(vitae);
            employee2s.setDepartment(department);
            employee2s.setJob(job);
            return employee2s;
        }
        return null;
    }
}
