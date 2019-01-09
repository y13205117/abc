package com.iotek.model;

public class GateCard {
    private Integer id;

    private String officehours;

    private String afterhours;

    private Integer eid;

    private String date;

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

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
}