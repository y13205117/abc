package com.iotek.model;

import java.io.Serializable;

public class Employee2 implements Serializable {
    private Employee employee;
    private Vitae vitae;

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
}
