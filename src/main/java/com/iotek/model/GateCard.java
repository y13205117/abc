package com.iotek.model;

import java.io.Serializable;

public class GateCard implements Serializable {
    private Integer id;

    private Double column2;

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

    public Double getColumn2() {
        return column2;
    }

    public void setColumn2(Double column2) {
        this.column2 = column2;
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