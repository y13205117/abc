package com.iotek.controller;

import com.iotek.model.Department;
import com.iotek.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DepartmentController {
    @Resource(name = "departmentServiceImpl")
    private DepartmentService departmentService;
    @RequestMapping("/goAdmin")
    public String goAdmin(HttpSession session)throws Exception{
        List<Department> departments = departmentService.queryDepartment();
        session.setAttribute("department",departments);
        return "admin";
    }
}
