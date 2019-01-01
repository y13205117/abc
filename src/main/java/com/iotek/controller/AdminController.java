package com.iotek.controller;

import com.iotek.model.Department;
import com.iotek.model.Recruit2;
import com.iotek.service.DepartmentService;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Resource(name = "departmentServiceImpl")
    private DepartmentService departmentService;
    @Resource(name = "recruitServiceImpl")
    private RecruitService recruitService;
    @RequestMapping("/goAdmin")
    public String goAdmin(HttpSession session)throws Exception{
        List<Recruit2> recruits = recruitService.queryRecruit();
        List<Department> departments = departmentService.queryDepartment();
        session.setAttribute("department",departments);
        session.setAttribute("recruit",recruits);
        return "admin";
    }

}
