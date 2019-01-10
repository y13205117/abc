package com.iotek.service.impl;

import com.iotek.dao.*;
import com.iotek.model.*;
import com.iotek.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Resource
    private MemberShowCVMapper memberShowCVMapper;
    @Override
    public boolean saveEmployee(Integer jid, Integer vid,Integer mid) {
        if(jid<=0 || vid<=0){
            return false;
        }
        Job job = jobMapper.selectByPrimaryKey(jid);
        Employee employee=new Employee();
        employee.setDid(job.getDid());
        employee.setJid(jid);
        employee.setEntrytime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        employee.setSalary(4000.00);
        employee.setPerformance(200);
        employee.setState(2);
        employee.setVid(vid);
        //完成入职后，修改状态为-1
        MemberShowCV memberShowCV = memberShowCVMapper.selectByPrimaryKey(mid);
        memberShowCV.setState(-1);
        int i1 = memberShowCVMapper.updateByPrimaryKeySelective(memberShowCV);
        int i = employeeMapper.insertSelective(employee);
        if(i1>0 && i>0){
            return true;
        }
        return false;
    }

    @Override
    public Employee EMPLogin(String name, String pass) {
        if(name==null || pass==null){
            return null;
        }
        int id = 0;
        try {
            //判断name是否是纯数字
            id = Integer.parseInt(name);
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

    @Override
    public List<Employee2> queryEmp2() {
        List<Employee2> employees2=new ArrayList<>();
        Employee2 employee2s=new Employee2();
        EmployeeExample employeeExample=new EmployeeExample();
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        for (Employee employee : employees) {
            Vitae vitae = vitaeMapper.selectByPrimaryKey(employee.getVid());
            Department department = departmentMapper.selectByPrimaryKey(employee.getDid());
            Job job = jobMapper.selectByPrimaryKey(employee.getJid());
            employee2s.setEmployee(employee);
            employee2s.setVitae(vitae);
            employee2s.setDepartment(department);
            employee2s.setJob(job);
            employees2.add(employee2s);
        }
        return employees2;
    }
}
