package com.tokid.model;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 13:20
*/

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "dbo.bmt_keh")
public class CClient implements Serializable {

    @Column(name = "id_keh")
   private String id;//客户id

    @Column(name = "id_group")
    private String groupId;

    @Column(name = "group_cn")
    private String groupName;//分组名称

    @Column(name = "keh_bh")
    private String code;//客户代码

    @Column(name = "keh_j")
    private String name;//客户名称

    @Column(name = "yewy")
    private String salesman;//业务员

    @Column(name = "tel")
    private String tel;

    @Column(name = "fax")
    private String fax;

    @Column(name = "bb")
    private String bb;//交易币别

    @Column(name = "fuk")
    private String payment;//付款方式

    @Column(name = "yuej_dt")
    private Short monthly;//月结日

    @Column(name = "keh_q_qs")
    private String wholeName;//客户全程

    @Column(name = "keh_dzh_gs")
    private String address;//客户地址

    @Column(name = "xianl")
    private String deliveryLine;//送货线路

    @Column(name = "weny")
    private String clerk;//文员

    @Column(name = "shuil1")
    private BigDecimal taxRate;//税率

    @Column(name = "hezuo_lb")
    private String cooperation;//合作方式

    @Column(name = "keh_j_2")
    private String forShort;//客户简称2


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Short getMonthly() {
        return monthly;
    }

    public void setMonthly(Short monthly) {
        this.monthly = monthly;
    }

    public String getWholeName() {
        return wholeName;
    }

    public void setWholeName(String wholeName) {
        this.wholeName = wholeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryLine() {
        return deliveryLine;
    }

    public void setDeliveryLine(String deliveryLine) {
        this.deliveryLine = deliveryLine;
    }

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getCooperation() {
        return cooperation;
    }

    public void setCooperation(String cooperation) {
        this.cooperation = cooperation;
    }

    public String getForShort() {
        return forShort;
    }

    public void setForShort(String forShort) {
        this.forShort = forShort;
    }
}
