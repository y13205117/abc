package com.iotek.controller;

import com.iotek.model.Employee;
import com.iotek.model.Employee2;
import com.iotek.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class EmployeeController {
    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;
    @RequestMapping("/queryEmp")
    @ResponseBody
    public List<Employee2> queryEmp(Employee employee)throws Exception{
        System.out.println(employee);
        List<Employee2> employees = employeeService.queryEMP(employee);
        return employees;
    }
}
