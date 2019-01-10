package com.iotek.service.impl;

import com.iotek.dao.EmployeeMapper;
import com.iotek.dao.JobMapper;
import com.iotek.model.Employee;
import com.iotek.model.EmployeeExample;
import com.iotek.model.Job;
import com.iotek.model.JobExample;
import com.iotek.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class JobServiceImpl implements JobService {
    @Resource
    private JobMapper jobMapper;
    @Resource
    private EmployeeMapper employeeMapper;
    @Override
    public List<Job> queryJob(Integer did) {
        JobExample jobExample=new JobExample();
        jobExample.createCriteria().andDidEqualTo(did);
        return jobMapper.selectByExample(jobExample);
    }

    @Override
    public boolean saveJob(Job job) {
        if(job==null){
            return false;
        }
        JobExample jobExample=new JobExample();
        jobExample.createCriteria().andDidEqualTo(job.getDid()).andNameEqualTo(job.getName());
        List<Job> jobs = jobMapper.selectByExample(jobExample);
        if(jobs==null || jobs.size()==0){
            job.setCreationtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            int i = jobMapper.insertSelective(job);
            return i>0?true:false;
        }
        return false;
    }

    @Override
    public boolean deleteJob(Integer id) {
        if(id<=0){
            return false;
        }
        EmployeeExample employeeExample=new EmployeeExample();
        employeeExample.createCriteria().andJidEqualTo(id);
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        if(employees==null || employees.size()==0){
            int i = jobMapper.deleteByPrimaryKey(id);
            return i>0?true:false;
        }
        return false;
    }

    @Override
    public Job queryById(Integer id) {
        if(id<=0){
            return null;
        }
        return jobMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateJob(Job job) {
        if(job==null){
            return false;
        }
        int i = jobMapper.updateByPrimaryKeySelective(job);
        return i>0?true:false;
    }
}
