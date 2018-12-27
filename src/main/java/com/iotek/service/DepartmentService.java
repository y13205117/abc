package com.iotek.service;

import com.iotek.model.Department;

import java.util.List;

public interface DepartmentService {
    //查询所有
    List<Department> queryDepartment();
    //增加
    boolean saveDepartment(String name);
    //删除
    boolean deleteDepartment(Integer id);
}
