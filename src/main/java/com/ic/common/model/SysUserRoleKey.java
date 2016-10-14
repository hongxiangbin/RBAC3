package com.ic.common.model;

public class SysUserRoleKey {
    private Long uid;

    private Long rid;

    public SysUserRoleKey() {
    }

    public SysUserRoleKey(Long uid, Long rid) {

        this.uid = uid;
        this.rid = rid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}