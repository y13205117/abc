package com.iotek.model;

import java.io.Serializable;

public class GateCard implements Serializable {
    private Integer id;

    private String officehours;

    private String afterhours;

    private Integer state;

    private Integer eid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOfficehours() {
        return officehours;
    }

    public void setOfficehours(String officehours) {
        this.officehours = officehours == null ? null : officehours.trim();
    }

    public String getAfterhours() {
        return afterhours;
    }

    public void setAfterhours(String afterhours) {
        this.afterhours = afterhours == null ? null : afterhours.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}