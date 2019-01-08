package com.iotek.model;

import java.io.Serializable;

public class TrainAndEmp implements Serializable {
    private Integer id;

    private Integer eid;

    private Integer teaTid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getTeaTid() {
        return teaTid;
    }

    public void setTeaTid(Integer teaTid) {
        this.teaTid = teaTid;
    }
}