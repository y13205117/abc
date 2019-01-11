package com.iotek.controller;

import com.iotek.model.User;
import com.iotek.model.Vitae;
import com.iotek.service.VitaeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @RequestMapping("/updateVitae")
    public String updateVitae(Vitae vitae,HttpSession session)throws Exception{
        boolean res = vitaeService.updateVitae(vitae);
        if(res){
            Vitae vitae1 = vitaeService.queryById(vitae.getId());
            session.setAttribute("vitae",vitae1);
            return "vitae";
        }
        return "main";
    }
    @RequestMapping("deleteVitae")
    public void deleteVitae(Integer id,HttpSession session,HttpServletResponse response)throws Exception{
        boolean res = vitaeService.deleteVitae(id);
        if(res){
            session.setAttribute("vitae",null);
            response.getWriter().write("删除成功");
        }else{
            response.getWriter().write("删除失败");
        }
    }
    @RequestMapping("/quVitae")
    @ResponseBody
    public Vitae quVitae(Integer id)throws Exception{
        return vitaeService.queryById(id);
    }
}
