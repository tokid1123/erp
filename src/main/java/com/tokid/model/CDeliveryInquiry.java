package com.tokid.model;
/*
* @Description: 发货查询表
* @author king
* @date 2018/1/24 15:53
*/

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Table(name = "dbo.btr_chpch")
public class CDeliveryInquiry implements Serializable {

    @Column(name = "id_chpch_b")
    private String id;

    @Column(name = "id_chpch_m")
    private String modelId;//型号id

    @Column(name = "keh_j")
    private String clientName;//客户名称

    @Column(name = "chpch_bh")
    private String deliveryOrderNum;//送货单号

    @Column(name = "date_chk")
    private Timestamp date;//送货日期

    @Column(name = "pingm_bh")
    private String productCode;//产品编码

    @Column(name = "pingm")
    private String productName;//产品名称

    @Column(name = "liaoh")
    private String itemCode;//物料编号

    @Column(name = "keh_po")
    private String orderPO;//订单PO

    @Column(name = "shul_jh")
    private BigDecimal deliveryNum;//送货数量

    @Column(name = "shul_th")
    private BigDecimal returnNum;//退货数量

    @Column(name = "shul_bp")
    private BigDecimal sparesNum;//备品数量

    @Column(name = "dw")
    private String unit;//单位

    @Column(name = "danj")
    private BigDecimal unitPrice;//单价

    @Column(name = "bb")
    private String bb;//币别

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDeliveryOrderNum() {
        return deliveryOrderNum;
    }

    public void setDeliveryOrderNum(String deliveryOrderNum) {
        this.deliveryOrderNum = deliveryOrderNum;
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

    public String getOrderPO() {
        return orderPO;
    }

    public void setOrderPO(String orderPO) {
        this.orderPO = orderPO;
    }

    public BigDecimal getDeliveryNum() {
        return deliveryNum;
    }

    public void setDeliveryNum(BigDecimal deliveryNum) {
        this.deliveryNum = deliveryNum;
    }

    public BigDecimal getReturnNum() {
        return returnNum;
    }

    public void setReturnNum(BigDecimal returnNum) {
        this.returnNum = returnNum;
    }

    public BigDecimal getSparesNum() {
        return sparesNum;
    }

    public void setSparesNum(BigDecimal sparesNum) {
        this.sparesNum = sparesNum;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }
}
