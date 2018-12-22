package com.iotek.model;

import java.io.Serializable;

//个人信息
public class Information implements Serializable {
    private Integer id;
    private String rname;//真实姓名
    private String sex;
    private String birth;//生日
    private String address;
    private Integer phone;
    private String Email;
    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", rname='" + rname + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", Email='" + Email + '\'' +
                ", uid=" + uid +
                '}';
    }
}
