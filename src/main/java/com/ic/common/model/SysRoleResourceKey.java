package com.ic.common.model;

public class SysRoleResourceKey {
    private Long roleId;

    private Long resId;

    public SysRoleResourceKey() {
    }

    public SysRoleResourceKey(Long roleId, Long resId) {
        this.roleId = roleId;
        this.resId = resId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }
}