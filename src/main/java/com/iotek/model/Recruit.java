package com.iotek.model;

import java.io.Serializable;

public class Recruit implements Serializable {
    private Integer id;

    private String theme;

    private String content;

    private String require;

    private Integer count;

    private String releasetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require == null ? null : require.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime == null ? null : releasetime.trim();
    }
}