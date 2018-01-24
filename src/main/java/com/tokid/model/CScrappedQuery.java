package com.tokid.model;
/*
* @Description: 报废查询表
* @author king
* @date 2018/1/24 16:46
*/

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Table(name = "dbo.dtr_baof")
public class CScrappedQuery implements Serializable{


    @Column(name = "id_wanch_b")
    private String bId;//id_wanch_b

    @Column(name = "id_wanch_m")
    private String mId;//id_wanch_m

    @Column(name = "keh_j")
    private String clientName;//客户名称

    @Column(name = "date_wch")
    private Timestamp date;//date_wch

    @Column(name = "pingm_bh")
    private String productCode;//产品编号

    @Column(name = "pingm")
    private String productName;//产品名称

    @Column(name = "liaoh")
    private String itemCode;//物料编号

    @Column(name = "gongxm")
    private String gongxm;//gongxm

    @Column(name = "bum_j")
    private String procedure;//工序

    @Column(name = "shul")
    private BigDecimal raxRate;//shul

    @Column(name = "dw")
    private String unit;//单位

    @Column(name = "qued_j")
    private String qued_j;//qued_j

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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

    public String getGongxm() {
        return gongxm;
    }

    public void setGongxm(String gongxm) {
        this.gongxm = gongxm;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public BigDecimal getRaxRate() {
        return raxRate;
    }

    public void setRaxRate(BigDecimal raxRate) {
        this.raxRate = raxRate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getQued_j() {
        return qued_j;
    }

    public void setQued_j(String qued_j) {
        this.qued_j = qued_j;
    }
}
