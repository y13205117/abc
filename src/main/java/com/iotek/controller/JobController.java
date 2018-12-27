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
    @RequestMapping("queryJob")
    @ResponseBody
    public List<String> queryJob(Integer did)throws Exception{
        List<Job> jobs = jobService.queryJob(did);
        List<String> str=new ArrayList<>();
        if(jobs!=null || jobs.size()>0){
            for (Job job : jobs) {
                str.add(job.getName());
            }
        }
        return str;
    }
    @RequestMapping("/saveJob")
    public String saveJob(Job job, HttpServletResponse response)throws Exception{
        System.out.println(job);
        boolean res =jobService.saveJob(job);
        if(res){
            response.getWriter().write("添加成功");
        }else {
            response.getWriter().write("添加失败");
        }
        return null;
    }
}
