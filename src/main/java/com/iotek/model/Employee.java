package com.iotek.model;


import java.io.Serializable;

public class Employee implements Serializable {
    private Integer id;

    private Double salary;

    private Integer state;

    private Integer type;

    private Integer jid;

    private Integer performance;

    private Integer vid;

    private Integer did;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
}