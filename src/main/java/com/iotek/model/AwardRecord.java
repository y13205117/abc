package com.iotek.model;

import java.io.Serializable;

public class AwardRecord implements Serializable {
    private Integer id;

    private String cause;

    private Integer money;

    private String time;

    private Integer eid;

    private Double cid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Double getCid() {
        return cid;
    }

    public void setCid(Double cid) {
        this.cid = cid;
    }
}