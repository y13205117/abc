package com.iotek.service;

import com.iotek.model.Employee;

public interface EmployeeService {
    //员工登录
    Employee EMPLogin(String name, String pass);
}
