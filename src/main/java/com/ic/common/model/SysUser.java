package com.ic.common.model;

import net.sf.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable {

    //0:禁止登录
    public static final Short _0 = 0;
    //1:有效
    public static final Short _1 = 1;

    private Long id;

    private String nickname;

    private String email;

    private String password;

    private Date createTime;

    private Date lastLoginTime;

    private Short status;

    private Integer age;

    private Short gender;

    private Short isdefault;

    private Long organizationId;

    public SysUser() {
    }

    public SysUser(Long id, String nickname, String email, String password, Date createTime, Date lastLoginTime, Short status, Integer age, Short gender, Short isdefault, Long organizationId) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.status = status;
        this.age = age;
        this.gender = gender;
        this.isdefault = isdefault;
        this.organizationId = organizationId;
    }

    public SysUser(SysUser user) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Short getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Short isdefault) {
        this.isdefault = isdefault;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
}