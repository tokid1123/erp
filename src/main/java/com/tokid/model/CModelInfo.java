package com.tokid.model;
/*
* @Description: 型号信息表
* @author king
* @date 2018/1/24 15:28
*/


import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;


@Table(name = "dbo.bmt_pingm")
public class CModelInfo implements Serializable {

    @Column(name = "id_pingm")
    private String id;//型号id

    @Column(name = "pingm_bh")
    private String productCode;//产品编号

    @Column(name = "pingm")
    private String name;//产品名称

    @Column(name = "liaoh")
    private String itemCode;//物料编码

    @Column(name = "keh_j")
    private String clientName;//客户名称

    @Column(name = "cengsh")
    private Short num;//层数

    @Column(name = "caizh")
    private String  quality;//材质

    @Column(name = "tunbh")
    private String cooper;//铜箔

    @Column(name = "banh")
    private String slabThick;//板厚

    @Column(name = "yans")
    private String color;//颜色

    @Column(name = "gongy")
    private String  technics;//工艺

    @Column(name = "id_chsh1")
    private String brandOne;//厂牌1

    @Column(name = "id_chsh2")
    private String brandTwo;//厂牌2

    @Column(name = "pcs_ch")
    private BigDecimal PCSLength;//pcs长

    @Column(name = "pcs_k")
    private BigDecimal PCSWidth;//pcs宽

    @Column(name = "dw")
    private String unit;//单位

    @Column(name = "shu_mq")
    private Integer currentStock;//目前库存

    @Column(name = "linp_mq")
    private Integer currentElement;//目前零件

    @Column(name = "pcs_lpsh")
    private Integer serialNumber;//连片数

    @Column(name = "lp_ch")
    private BigDecimal serialLength;//连片长

    @Column(name = "lp_k")
    private BigDecimal serialWidth;//连片宽

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getCooper() {
        return cooper;
    }

    public void setCooper(String cooper) {
        this.cooper = cooper;
    }

    public String getSlabThick() {
        return slabThick;
    }

    public void setSlabThick(String slabThick) {
        this.slabThick = slabThick;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTechnics() {
        return technics;
    }

    public void setTechnics(String technics) {
        this.technics = technics;
    }

    public String getBrandOne() {
        return brandOne;
    }

    public void setBrandOne(String brandOne) {
        this.brandOne = brandOne;
    }

    public String getBrandTwo() {
        return brandTwo;
    }

    public void setBrandTwo(String brandTwo) {
        this.brandTwo = brandTwo;
    }

    public BigDecimal getPCSLength() {
        return PCSLength;
    }

    public void setPCSLength(BigDecimal PCSLength) {
        this.PCSLength = PCSLength;
    }

    public BigDecimal getPCSWidth() {
        return PCSWidth;
    }

    public void setPCSWidth(BigDecimal PCSWidth) {
        this.PCSWidth = PCSWidth;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Integer getCurrentElement() {
        return currentElement;
    }

    public void setCurrentElement(Integer currentElement) {
        this.currentElement = currentElement;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getSerialLength() {
        return serialLength;
    }

    public void setSerialLength(BigDecimal serialLength) {
        this.serialLength = serialLength;
    }

    public BigDecimal getSerialWidth() {
        return serialWidth;
    }

    public void setSerialWidth(BigDecimal serialWidth) {
        this.serialWidth = serialWidth;
    }
}
