package com.iotek.controller;

import com.iotek.model.Department;
import com.iotek.model.MemberShowCV;
import com.iotek.model.Recruit;
import com.iotek.model.Recruit2;
import com.iotek.service.DepartmentService;
import com.iotek.service.MemberShowCVService;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Resource(name = "departmentServiceImpl")
    private DepartmentService departmentService;
    @Resource(name = "recruitServiceImpl")
    private RecruitService recruitService;
    @Resource(name = "memberShowCVServiceImpl")
    private MemberShowCVService memberShowCVService;
    @RequestMapping("/goAdmin")
    public String goAdmin(HttpSession session)throws Exception{
        List<Recruit2> recruits = recruitService.queryRecruit();
        List<Department> departments = departmentService.queryDepartment();
        session.setAttribute("department",departments);
        session.setAttribute("recruit",recruits);
        return "admin";
    }
    @RequestMapping("/amdinSendRecruit")
    public void sendRecruit(HttpSession session, Recruit recruit, HttpServletResponse response) throws Exception{
        boolean res = recruitService.saveRecruit(recruit);
        if(res){
            List<Recruit2> recruits = recruitService.queryRecruit();
            session.setAttribute("recruit",recruits);
            response.getWriter().print("<script language='javascript'>alert('发布成功');</script>");
            response.sendRedirect("goAdmin");
        }else{
            response.getWriter().print("<script language='javascript'>alert('发布失败');</script>");
        }
    }
    @RequestMapping("queryMCV")
    @ResponseBody
    public List<MemberShowCV> queryMCV(Integer rid)throws Exception{
        System.out.println(rid);
        List<MemberShowCV> memberShowCVS = memberShowCVService.queryByRid(rid);
        System.out.println(memberShowCVS);
        return memberShowCVS;
    }
}
