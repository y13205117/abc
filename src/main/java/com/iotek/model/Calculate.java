package com.iotek.model;

public class Calculate {
    private Integer id;

    private String time;

    private Integer reconsider;

    private String cause;

    private Integer eid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getReconsider() {
        return reconsider;
    }

    public void setReconsider(Integer reconsider) {
        this.reconsider = reconsider;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}