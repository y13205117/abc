package com.iotek.model;

import java.io.Serializable;

public class Leave implements Serializable {
    private Integer id;

    private String cause;

    private String time;

    private Integer eid;

    private Integer state;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", cause='" + cause + '\'' +
                ", time='" + time + '\'' +
                ", eid=" + eid +
                ", state=" + state +
                '}';
    }
}