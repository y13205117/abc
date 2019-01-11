package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.*;
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
    @Resource(name = "leaveServiceImpl")
    private LeaveService leaveService;
    @Resource(name = "calculateServiceImpl")
    private CalculateService calculateService;
    @Resource(name = "trainServiceImpl")
    private TrainService trainService;
    @RequestMapping("/queryEmp")
    @ResponseBody
    public List<Employee2> queryEmp(Employee employee)throws Exception{
        List<Employee2> employees = employeeService.queryEMP(employee);
        return employees;
    }
    @RequestMapping("/goEmployee")
    public String goEmployee(HttpSession session)throws Exception{
        Employee2 employee2= (Employee2) session.getAttribute("emp");
        List<Train> trains = trainService.queryById(employee2.getEmployee().getDid(), employee2.getEmployee().getId());
        session.setAttribute("train",trains);
        List<Employee2> employee2s = employeeService.queryEmp2();
        session.setAttribute("employee",employee2s);
        List<AwardRecord> awardRecords = awardRecordService.queryByEid(employee2.getEmployee().getId());
        session.setAttribute("awardRecord",awardRecords);
        List<Calculate> calculates = calculateService.queryByEid(employee2.getEmployee().getId());
        session.setAttribute("calculate",calculates);
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
    @RequestMapping("/actEmp")
    public void actEmp(Integer jid,Integer vid,Integer mid,HttpServletResponse response)throws Exception{
        boolean res = employeeService.saveEmployee(jid, vid,mid);
        if(res){
            response.getWriter().write("入职成功");
        }else{
            response.getWriter().write("入职失败");
        }
    }
    @RequestMapping("/addlea")
    public void addlea(String cause,HttpSession session,HttpServletResponse response)throws Exception{
        Employee2 employee2= (Employee2) session.getAttribute("emp");
        boolean res = leaveService.saveLeave(cause, employee2.getEmployee().getId());
        if(res){
            response.getWriter().print("<script language='javascript'>alert('提交成功');</script>");
        }else{
            response.getWriter().print("<script language='javascript'>alert('提交失败');</script>");
        }
        response.sendRedirect("goE");
    }
    @RequestMapping("/goE")
    public String goE()throws Exception{
        return "employee";
    }
}
