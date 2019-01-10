package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.EmployeeService;
import com.iotek.service.MemberShowCVService;
import com.iotek.service.UserService;
import com.iotek.service.VitaeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;
    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;
    @Resource(name = "vitaeServiceImpl")
    private VitaeService vitaeService;
    @Resource(name = "memberShowCVServiceImpl")
    private MemberShowCVService memberShowCVService;
    @RequestMapping("/login")
    public String login(User user, HttpSession session,HttpServletResponse response)throws Exception{
        User user1 = userService.queryUser(user);
        System.out.println(user1);
        if(user1!=null) {
            session.setAttribute("user", user1);
            Vitae vitae = vitaeService.queryByUid(user1.getId());
            List<MemberShowCV> memberShowCVS = memberShowCVService.queryByUser(user1);
            session.setAttribute("memberShowCV",memberShowCVS);
            session.setAttribute("vitae",vitae);
            return "main";
        }
        Employee employee = employeeService.EMPLogin(user.getName(), user.getPass());
        if(employee!=null){
            Employee2 employee2 = employeeService.queryEmpById(employee.getId());
            session.setAttribute("emp",employee2);
            response.sendRedirect("goEmployee");
            return null;
        }
        if(user.getName().equals("admin") && user.getPass().equals("123456")){
            response.sendRedirect("goAdmin");
            return null;
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
    @RequestMapping("/goShowMC")
    public String goShowMC(HttpSession session,HttpServletResponse response)throws Exception{
        User user= (User) session.getAttribute("user");
        if(user==null){
            response.getWriter().write("<script language='javascript'>alert('请先登录');window.location.href='index.jsp';</script>");
            return null;
        }
        return "showMC";
    }
    @RequestMapping("/goMCV")
    public void goMCV(Integer mid,HttpSession session,HttpServletResponse response)throws Exception{
        boolean res = memberShowCVService.updateState(mid);
        User user= (User) session.getAttribute("user");
        if(res){
            List<MemberShowCV> memberShowCVS = memberShowCVService.queryByUser(user);
            session.setAttribute("memberShowCV",memberShowCVS);
            response.getWriter().write("祝您面试成功");
        }else{
            response.getWriter().write("操作失败，请刷新页面");
        }
    }
    @RequestMapping("/notGoMCV")
    public void notGoMCV(Integer mid,HttpSession session,HttpServletResponse response)throws Exception{
        boolean res = memberShowCVService.updateNotState(mid);
        User user= (User) session.getAttribute("user");
        if(res){
            List<MemberShowCV> memberShowCVS = memberShowCVService.queryByUser(user);
            session.setAttribute("memberShowCV",memberShowCVS);
            response.getWriter().write("您放弃一次好机会");
        }else{
            response.getWriter().write("操作失败，请刷新页面");
        }
    }
    @RequestMapping("/goOut")
    public String goOut(HttpSession session)throws Exception{
        session.invalidate();
        return "../../index";
    }
}
