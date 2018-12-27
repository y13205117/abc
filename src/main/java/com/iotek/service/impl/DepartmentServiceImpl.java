package com.iotek.service.impl;

import com.iotek.dao.DepartmentMapper;
import com.iotek.dao.EmployeeMapper;
import com.iotek.model.Department;
import com.iotek.model.DepartmentExample;
import com.iotek.model.Employee;
import com.iotek.model.EmployeeExample;
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
            int i = departmentMapper.deleteByPrimaryKey(id);
            return i>0?true:false;
        }
        return false;
    }
}
