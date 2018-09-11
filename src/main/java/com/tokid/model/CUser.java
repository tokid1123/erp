package com.tokid.model;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 10:23
*/

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "dbo.amt_user")
public class CUser implements Serializable {

    @Column(name = "user_en")
    private String username;//用户名

    @Column(name = "user_pw")
    private String password;

    @Column(name = "xingm")
    private String name;//用户姓名

    @Column(name = "date_zc")
    private Date createdTime;//注册日期

    @Column(name = "date_dq")
    private Date expiredTime;//到期日期

    @Column(name = "qx_keh")
    private Integer qx_keh;

    @Column(name = "qx_pingm")
    private Short pingm;

    @Column(name = "qx_dind")
    private Short dind;

    @Column(name = "qx_chpch")
    private Short chpch;

    @Column(name = "qx_shchwip")
    private Short shchwip;

    @Column(name = "qx_baof")
    private Short baof;

    @Column(name = "qx_chanl")
    private Short chanl;

    @Column(name = "db_id")
    private String dbId;

    public String getDbId() {
        return dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Integer getQx_keh() {
        return qx_keh;
    }

    public void setQx_keh(Integer qx_keh) {
        this.qx_keh = qx_keh;
    }

    public Short getPingm() {
        return pingm;
    }

    public void setPingm(Short pingm) {
        this.pingm = pingm;
    }

    public Short getDind() {
        return dind;
    }

    public void setDind(Short dind) {
        this.dind = dind;
    }

    public Short getChpch() {
        return chpch;
    }

    public void setChpch(Short chpch) {
        this.chpch = chpch;
    }

    public Short getShchwip() {
        return shchwip;
    }

    public void setShchwip(Short shchwip) {
        this.shchwip = shchwip;
    }

    public Short getBaof() {
        return baof;
    }

    public void setBaof(Short baof) {
        this.baof = baof;
    }

    public Short getChanl() {
        return chanl;
    }

    public void setChanl(Short chanl) {
        this.chanl = chanl;
    }
}
