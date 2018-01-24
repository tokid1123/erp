package com.tokid.model;
/*
* @Description: 进度查询表
* @author king
* @date 2018/1/24 16:24
*/

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Table(name = "dbo.dtr_shchwip")
public class CProgressQuery implements Serializable{

    @Column(name = "id_shch_b")
    private String id;

    @Column(name = "id_bum")
    private String bumId;//bum_ID

    @Column(name = "chn1_wf2")
    private Short factoryOut;//本厂或者外发

    @Column(name = "date_wip")
    private Timestamp onLineDate;//在线日期

    @Column(name = "keh_j")
    private String clientName;//客户名称

    @Column(name = "shch_bh")
    private String instructionNum;//指令号

    @Column(name = "bum_j")
    private String procedure;//工序

    @Column(name = "pingm_bh")
    private String productCode;//产品编号

    @Column(name = "pingm")
    private String productName;//产品名称

    @Column(name = "liaoh")
    private String itemCode;//物料编号

    @Column(name = "dw")
    private String unit;//单位

    @Column(name = "shul_wip")
    private BigDecimal onLineNum;//在线数量

    @Column(name = "pnl14_set5")
    private String onLineUnit;//在线单位


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBumId() {
        return bumId;
    }

    public void setBumId(String bumId) {
        this.bumId = bumId;
    }

    public Short getFactoryOut() {
        return factoryOut;
    }

    public void setFactoryOut(Short factoryOut) {
        this.factoryOut = factoryOut;
    }

    public Timestamp getOnLineDate() {
        return onLineDate;
    }

    public void setOnLineDate(Timestamp onLineDate) {
        this.onLineDate = onLineDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getInstructionNum() {
        return instructionNum;
    }

    public void setInstructionNum(String instructionNum) {
        this.instructionNum = instructionNum;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getOnLineNum() {
        return onLineNum;
    }

    public void setOnLineNum(BigDecimal onLineNum) {
        this.onLineNum = onLineNum;
    }

    public String getOnLineUnit() {
        return onLineUnit;
    }

    public void setOnLineUnit(String onLineUnit) {
        this.onLineUnit = onLineUnit;
    }
}
