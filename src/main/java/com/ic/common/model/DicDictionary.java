package com.ic.common.model;

import net.sf.json.JSONObject;

public class DicDictionary {
    private Long id;

    private String code;

    private String text;

    private Long dictypeId;

    private Integer seq;

    private Short status;

    private Short isdefault;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Long getDictypeId() {
        return dictypeId;
    }

    public void setDictypeId(Long dictypeId) {
        this.dictypeId = dictypeId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Short isdefault) {
        this.isdefault = isdefault;
    }

    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
}