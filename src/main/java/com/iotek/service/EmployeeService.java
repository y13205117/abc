package com.iotek.service;

import com.iotek.model.Employee;
import com.iotek.model.Employee2;

import java.util.List;

public interface EmployeeService {
    //员工登录
    Employee EMPLogin(String name, String pass);
    //根据部门和职位找员工
    List<Employee2> queryEMP(Employee employee);
}
