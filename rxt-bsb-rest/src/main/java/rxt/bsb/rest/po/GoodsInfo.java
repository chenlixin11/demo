package rxt.bsb.rest.po;

import java.util.Date;

public class GoodsInfo {
    private Integer id;

    private Integer ordersInfoId;

    private String goodsCode;

    private String goodsName;

    private String goodsSpec;

    private String goodsQuantity;

    private String goodsPrice;

    private String goodsTotalMoney;

    private String goodsUnit;

    private String goodsSummary;

    private String goodsType;

    private String transNum;

    private String transAmt;

    private String transPrp;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdersInfoId() {
        return ordersInfoId;
    }

    public void setOrdersInfoId(Integer ordersInfoId) {
        this.ordersInfoId = ordersInfoId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec == null ? null : goodsSpec.trim();
    }

    public String getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(String goodsQuantity) {
        this.goodsQuantity = goodsQuantity == null ? null : goodsQuantity.trim();
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice == null ? null : goodsPrice.trim();
    }

    public String getGoodsTotalMoney() {
        return goodsTotalMoney;
    }

    public void setGoodsTotalMoney(String goodsTotalMoney) {
        this.goodsTotalMoney = goodsTotalMoney == null ? null : goodsTotalMoney.trim();
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit == null ? null : goodsUnit.trim();
    }

    public String getGoodsSummary() {
        return goodsSummary;
    }

    public void setGoodsSummary(String goodsSummary) {
        this.goodsSummary = goodsSummary == null ? null : goodsSummary.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public String getTransNum() {
        return transNum;
    }

    public void setTransNum(String transNum) {
        this.transNum = transNum == null ? null : transNum.trim();
    }

    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt == null ? null : transAmt.trim();
    }

    public String getTransPrp() {
        return transPrp;
    }

    public void setTransPrp(String transPrp) {
        this.transPrp = transPrp == null ? null : transPrp.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}