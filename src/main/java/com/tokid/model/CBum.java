package com.tokid.model;/*
* @Description: 工序
* @author king
* @date 2018/4/14  13:59
*/

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Table(name = "dbo.dtr_chanl")
public class CBum implements Serializable {

    @Column(name = "date_tj")
    private Timestamp date_tj;

    @Column(name = "bum_j")
    private String bum_j;

    @Column(name = "bensh")
    private BigDecimal bensh;

    @Column(name = "mianj")
    private BigDecimal mianj;

    public Timestamp getDate_tj() {
        return date_tj;
    }

    public void setDate_tj(Timestamp date_tj) {
        this.date_tj = date_tj;
    }

    public String getBum_j() {
        return bum_j;
    }

    public void setBum_j(String bum_j) {
        this.bum_j = bum_j;
    }

    public BigDecimal getBensh() {
        return bensh;
    }

    public void setBensh(BigDecimal bensh) {
        this.bensh = bensh;
    }

    public BigDecimal getMianj() {
        return mianj;
    }

    public void setMianj(BigDecimal mianj) {
        this.mianj = mianj;
    }
}
