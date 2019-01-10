package com.iotek.service;

import com.iotek.model.Employee;
import com.iotek.model.Employee2;

import java.util.List;

public interface EmployeeService {
    //添加员工
    boolean saveEmployee(Integer jid,Integer vid,Integer mid);
    //员工登录
    Employee EMPLogin(String name, String pass);
    //根据部门和职位找员工
    List<Employee2> queryEMP(Employee employee);
    //根据id找员工
    Employee2 queryEmpById(Integer id);
    //通讯录
    List<Employee2> queryEmp2();
}
