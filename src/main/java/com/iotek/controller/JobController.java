package com.iotek.controller;

import com.iotek.dao.JobMapper;
import com.iotek.model.Job;
import com.iotek.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JobController {
    @Resource(name = "jobServiceImpl")
    private JobService jobService;
    @RequestMapping("/queryJob")
    @ResponseBody
    public List<Job> queryJob(Integer did)throws Exception{
        List<Job> jobs = jobService.queryJob(did);
        return jobs;
    }
    @RequestMapping("/saveJob")
    public String saveJob(Job job, HttpServletResponse response)throws Exception{
        boolean res =jobService.saveJob(job);
        if(res){
            response.getWriter().write("添加成功");
        }else {
            response.getWriter().write("添加失败");
        }
        return null;
    }
    @RequestMapping("/quJob")
    public void quJob(Integer id,HttpServletResponse response)throws Exception{
        Job job = jobService.queryById(id);
        response.getWriter().write(job.getName());
    }
    @RequestMapping("/upJob")
    public void upDEP(Job job,HttpServletResponse response)throws Exception{
        boolean res = jobService.updateJob(job);
        if(res){
            response.getWriter().write("修改成功");
        }else{
            response.getWriter().write("修改失败");
        }
    }
    @RequestMapping("/deJob")
    public void deJob(Integer id,HttpServletResponse response)throws Exception{
        boolean res = jobService.deleteJob(id);
        if(res){
            response.getWriter().write("删除成功");
        }else{
            response.getWriter().write("删除失败");
        }
    }
}
