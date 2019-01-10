package com.iotek.controller;

import com.iotek.model.Department;
import com.iotek.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DepartmentController {
    @Resource(name = "departmentServiceImpl")
    private DepartmentService departmentService;

    @RequestMapping("/saveDEP")
    public String saveDEP(String name,HttpSession session, HttpServletResponse response)throws Exception{
        boolean res = departmentService.saveDepartment(name);
        if(res){
            List<Department> departments = departmentService.queryDepartment();
            session.setAttribute("department",departments);
            response.getWriter().write("添加成功");
        }else {
            response.getWriter().write("添加失败");
        }
        return null;
    }
    @RequestMapping("/quDep")
    public void quDep(Integer id,HttpServletResponse response)throws Exception{
        Department department = departmentService.queryById(id);
        response.getWriter().write(department.getName());
    }
    @RequestMapping("/upDEP")
    public void upDEP(Department department,HttpServletResponse response)throws Exception{
        boolean res = departmentService.updateByDepartment(department);
        if(res){
            response.getWriter().write("修改成功");
        }else{
            response.getWriter().write("修改失败");
        }
    }
    @RequestMapping("/deDep")
    public void deDep(Integer id,HttpServletResponse response)throws Exception{
        boolean res = departmentService.deleteDepartment(id);
        if(res){
            response.getWriter().write("删除成功");
        }else {
            response.getWriter().write("删除失败");
        }
    }
}
