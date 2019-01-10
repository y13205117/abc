package com.iotek.service.impl;

import com.iotek.dao.DepartmentMapper;
import com.iotek.dao.EmployeeMapper;
import com.iotek.dao.JobMapper;
import com.iotek.model.*;
import com.iotek.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private JobMapper jobMapper;
    @Override
    public List<Department> queryDepartment() {
        DepartmentExample departmentExample=new DepartmentExample();
        return departmentMapper.selectByExample(departmentExample);
    }

    @Override
    public boolean saveDepartment(String name) {
        if(name==null){
            return false;
        }
        //判重名
        DepartmentExample departmentExample=new DepartmentExample();
        departmentExample.createCriteria().andNameEqualTo(name);
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        if(departments==null || departments.size()==0){
            Department department=new Department();
            department.setName(name);
            department.setCreationtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            int i = departmentMapper.insertSelective(department);
            return i>0?true:false;
        }
        return false;
    }

    @Override
    public boolean deleteDepartment(Integer id) {
        if(id<=0){
            return false;
        }
        //判断有没有员工
        EmployeeExample employeeExample=new EmployeeExample();
        employeeExample.createCriteria().andDidEqualTo(id);
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        if(employees==null){
            JobExample jobExample=new JobExample();
            jobExample.createCriteria().andDidEqualTo(id);
            int i1 = jobMapper.deleteByExample(jobExample);
            int i = departmentMapper.deleteByPrimaryKey(id);
            if(i1>0 && i>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public Department queryById(Integer id) {
        if(id<=0){
            return null;
        }
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByDepartment(Department department) {
        if (department==null){
            return false;
        }
        int i = departmentMapper.updateByPrimaryKeySelective(department);
        return i>0?true:false;
    }
}
