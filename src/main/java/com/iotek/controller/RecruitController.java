package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.DepartmentService;
import com.iotek.service.MemberShowCVService;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RecruitController {
    @Resource(name = "departmentServiceImpl")
    private DepartmentService departmentService;
    @Resource(name = "recruitServiceImpl")
    private RecruitService recruitService;
    @Resource(name = "memberShowCVServiceImpl")
    private MemberShowCVService memberShowCVService;
    @RequestMapping("/goRecruit")
    public String goRecruit(HttpSession session)throws Exception{
        List<Department> departments = departmentService.queryDepartment();
        session.setAttribute("department",departments);
        List<Recruit2> recruits = recruitService.queryRecruit();
        session.setAttribute("recruit",recruits);
        return "recruit";
    }
    @RequestMapping("/quRecruit")
    public void quRecruit(Integer id, HttpServletResponse response)throws Exception{
        Recruit recruit = recruitService.queryById(id);
        response.getWriter().write(recruit.getContent());
    }
    @RequestMapping("/sendRecruit")
    public String sendRecruit(Integer id, HttpSession session,HttpServletResponse response)throws Exception{
        User user= (User) session.getAttribute("user");
        if(user==null){
            response.getWriter().write("抱歉你还没有登录");
            return null;
        }
        Vitae vitae= (Vitae) session.getAttribute("vitae");
        if(vitae==null){
            response.getWriter().write("抱歉你还没有简历");
            return null;
        }
        boolean res = memberShowCVService.saveMemberShowCV(id, vitae.getId());
        if(res){
            response.getWriter().write("投递成功");
        }else{
            response.getWriter().write("您已经投递过了，请不要重复投递");
        }
        return null;
    }
    @RequestMapping("/queryRecruit")
    public void queryRecruit(Integer jid,Integer did,HttpSession session,HttpServletResponse response)throws Exception{
        List<Recruit2> recruit2s = recruitService.queryByJidAndDid(jid, did);
        session.removeAttribute("recruit");
        session.setAttribute("recruit",recruit2s);
        response.getWriter().write("ok");
    }
}
