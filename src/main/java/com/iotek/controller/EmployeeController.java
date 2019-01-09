package com.iotek.controller;

import com.iotek.model.AwardRecord;
import com.iotek.model.Employee;
import com.iotek.model.Employee2;
import com.iotek.service.AwardRecordService;
import com.iotek.service.EmployeeService;
import com.iotek.service.GateCardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeController {
    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;
    @Resource(name = "awardRecordServiceImpl")
    private AwardRecordService awardRecordService;
    @Resource(name = "gateCardServiceImpl")
    private GateCardService gateCardService;
    @RequestMapping("/queryEmp")
    @ResponseBody
    public List<Employee2> queryEmp(Employee employee)throws Exception{
        List<Employee2> employees = employeeService.queryEMP(employee);
        return employees;
    }
    @RequestMapping("/goEmployee")
    public String goEmployee(HttpSession session)throws Exception{
        Employee2 employee2= (Employee2) session.getAttribute("emp");
        List<AwardRecord> awardRecords = awardRecordService.queryByEid(employee2.getEmployee().getId());
        session.setAttribute("awardRecord",awardRecords);
        return "employee";
    }
    @RequestMapping("/goOffice")
    public void goOffice(HttpSession session, HttpServletResponse response)throws Exception{
        Employee2 employee2= (Employee2) session.getAttribute("emp");
        boolean res = gateCardService.saveGateCard(employee2.getEmployee().getId());
        if(res){
            response.getWriter().write("打卡成功");
        }else{
            response.getWriter().write("打卡失败");
        }
    }
    @RequestMapping("/goAfter")
    public void goAfter(HttpSession session, HttpServletResponse response)throws Exception{
        Employee2 employee2= (Employee2) session.getAttribute("emp");
        boolean res = gateCardService.updateGateCard(employee2.getEmployee().getId());
        if(res){
            response.getWriter().write("打卡成功");
        }else{
            response.getWriter().write("打卡失败");
        }
    }
}
