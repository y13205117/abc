package com.iotek.service;

import com.iotek.model.Job;

import java.util.List;

public interface JobService {
    //查询职位
    List<Job> queryJob(Integer did);
    //增加
    boolean saveJob(Job job);
    //删除
    boolean deleteJob(Integer id);
    //查找
    Job queryById(Integer id);
    //修改名字
    boolean updateJob(Job job);
}
