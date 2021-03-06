package com.iotek.model;

import java.io.Serializable;

public class Job implements Serializable {
    private Integer id;

    private String name;

    private String creationtime;

    private Integer did;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime == null ? null : creationtime.trim();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationtime='" + creationtime + '\'' +
                ", did=" + did +
                '}';
    }
}