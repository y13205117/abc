package com.iotek.controller;

import com.iotek.model.User;
import com.iotek.model.Vitae;
import com.iotek.service.VitaeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class VitaeController {
    @Resource(name = "vitaeServiceImpl")
    private VitaeService vitaeService;
    @RequestMapping("/goVitae")
    public String goVitae(HttpSession session, HttpServletResponse response)throws Exception{
        User user= (User) session.getAttribute("user");
        if(user!=null){
            Vitae vitae = vitaeService.queryByUid(user.getId());
            session.setAttribute("vitae",vitae);
            return "vitae";
        }
        response.getWriter().print("<script language='javascript'>alert('请先登录');window.location.href='index.jsp';</script>");
        return null;
    }

    @RequestMapping("/saveVitae")
    public String saveVitae(Vitae vitae,HttpSession session)throws Exception{
        User user = (User) session.getAttribute("user");
        vitae.setUid(user.getId());
        boolean res = vitaeService.saveVitae(vitae);
        if(res){
            session.setAttribute("vitae",vitae);
            return "vitae";
        }
        return "main";
    }
}
