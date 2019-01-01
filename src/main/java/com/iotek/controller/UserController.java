package com.iotek.controller;

import com.iotek.model.Employee;
import com.iotek.model.Recruit;
import com.iotek.model.User;
import com.iotek.service.EmployeeService;
import com.iotek.service.RecruitService;
import com.iotek.service.UserService;
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
    @RequestMapping("/login")
    public String login(User user, HttpSession session,HttpServletResponse response)throws Exception{
        User user1 = userService.queryUser(user);
        if(user1!=null) {
            session.setAttribute("user", user1);
            return "main";
        }
        Employee employee = employeeService.EMPLogin(user.getName(), user.getPass());
        if(employee!=null){
            session.setAttribute("emp",employee);
            return "employee";
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
