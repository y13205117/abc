package com.iotek.controller;

import com.iotek.model.Recruit2;
import com.iotek.model.User;
import com.iotek.model.Vitae;
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
    @Resource(name = "recruitServiceImpl")
    private RecruitService recruitService;
    @Resource(name = "memberShowCVServiceImpl")
    private MemberShowCVService memberShowCVService;
    @RequestMapping("/goRecruit")
    public String goRecruit(HttpSession session,HttpServletResponse response)throws Exception{
        User user= (User) session.getAttribute("user");
        if(user==null){
            response.getWriter().print("<script language='javascript'>alert('请先登录');window.location.href='index.jsp';</script>");
            return null;
        }
        List<Recruit2> recruits = recruitService.queryRecruit();
        session.setAttribute("recruit",recruits);
        return "recruit";
    }
    @RequestMapping("/quRecruit")
    public void quRecruit(Integer id, HttpServletResponse response)throws Exception{
        Recruit2 recruit2 = recruitService.queryRecruitById(id);
        response.getWriter().write(recruit2.getRecruit().getContent());
    }
    @RequestMapping("/sendRecruit")
    public void sendRecruit(Integer id, HttpSession session,HttpServletResponse response)throws Exception{
        Vitae vitae= (Vitae) session.getAttribute("vitae");
        if(vitae==null){
            response.getWriter().write("抱歉你还没有简历");
        }
        boolean res = memberShowCVService.saveMemberShowCV(id, vitae.getId());
        if(res){
            response.getWriter().write("投递成功");
        }else{
            response.getWriter().write("投递失败");
        }
    }
}
