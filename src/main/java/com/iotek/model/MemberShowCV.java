package com.iotek.model;

import java.io.Serializable;

public class MemberShowCV implements Serializable {
    private Integer id;

    private Integer rid;

    private Integer vid;

    private String time;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "MemberShowCV{" +
                "id=" + id +
                ", rid=" + rid +
                ", vid=" + vid +
                ", time='" + time + '\'' +
                ", state=" + state +
                '}';
    }
}