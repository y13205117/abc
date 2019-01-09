package com.iotek.model;

import java.io.Serializable;

public class Employee2 implements Serializable {
    private Employee employee;
    private Vitae vitae;
    private Department department;
    private Job job;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Vitae getVitae() {
        return vitae;
    }

    public void setVitae(Vitae vitae) {
        this.vitae = vitae;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
