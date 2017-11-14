package com.tokid.base.model;

import java.util.Date;

public class BaseModel<T> {

    private Long id;

    private String name;

    private Date createTime;

    private Date updateTime;

    private T code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }
}
