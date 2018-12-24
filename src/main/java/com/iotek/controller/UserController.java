package com.iotek.controller;

import com.iotek.model.User;
import com.iotek.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;
    @RequestMapping("/login")
    public String login(User user, HttpSession session)throws Exception{
        User user1 = userService.queryUser(user);
        if(user1!=null) {
            session.setAttribute("user", user1);
        }
        return "main";
    }
    @RequestMapping("/myUnique")
    public String myUnique(String name, HttpServletResponse response)throws Exception{
        User user = userService.queryUserBy(name);
        if(user==null){
            response.getWriter().write("true");
        }else{
            response.getWriter().write("false");
        }
        return null;
    }
    @RequestMapping("/register")
    public String register(User user,HttpServletResponse response)throws Exception{
        System.out.println(user);
        boolean res = userService.saveUser(user);
        if(res){
            response.getWriter().print("<script language='javascript'>alert('注册成功');window.location.href='index.jsp';</script>");
        }else{
            response.getWriter().print("<script language='javascript'>alert('注册失败');window.location.href='index.jsp';</script>");
        }
        return null;
    }
    @RequestMapping("/goRegister")
    public String goRegister()throws Exception{
        return "register";
    }
}