package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * 订单额外参数 Json
 * Created by ChenLiXin on 2019/9/18 0018 11:50
 */
public class OrderAdditionalParam implements Serializable {

    @Size(max = 10, message = "订单状态长度不超过{max}位")
    private String orderStatus;//订单状态

    @Size(max = 8, message = "下单时间长度不超过{max}位")
    private String orderTime;//下单时间

    @Size(max = 20, message = "买方手机号长度不超过{max}位")
    private String buyerMobile;//买方手机号

    @Size(max = 8, message = "买方付款日长度不超过{max}位")
    private String buyerDate;//买方付款日

    @Size(max = 100, message = "买方收货地址长度不超过{max}位")
    private String buyerAddress;//买方收货地址

    @Size(max = 20, message = "卖方手机号长度不超过{max}位")
    private String sellerMobile;//卖方手机号

    @Size(max = 8, message = "卖方发货日期长度不超过{max}位")
    private String sellerDate;//卖方发货日期

    @Size(max = 100, message = "卖方地址长度不超过{max}位")
    private String sellerAddress;//卖方地址

    @NotBlank(message = "合同号不能空")
    @Size(max = 32, message = "合同号长度不超过{max}位")
    private String contractNo;//合同号

    @Size(max = 32, message = "物流单号长度不超过{max}位")
    private String shipOrderNo;//物流单号

    @Size(max = 10, message = "支付状态长度不超过{max}位")
    private String payStatus;//支付状态

    @Size(max = 8, message = "审核时间长度不超过{max}位")
    private String checkTime;// 审核时间

    @Size(max = 8, message = "支付时间长度不超过{max}位")
    private String payTime;//支付时间

    @Size(max = 8, message = "确认收货时间长度不超过{max}位")
    private String confirmRecTime;//确认收货时间

    @Size(max = 500, message = "订单备注长度不超过{max}位")
    private String orderRemarks;//订单备注

    @NotBlank(message = "订单到期时间不能空")
    @Size(max = 8, message = "订单到期时间长度不超过{max}位")
    private String dueDate; //订单到期时间

    /*@Size(max = 5, message = "与平台合作时间长度不超过{max}位")
    private String cooperateTime;//与平台合作时间  单位月

    @Size(max = 5, message = "最近 24 个月交易月份长度不超过{max}位")
    private String lastTwoYearsMonths;//最近 24 个月交易月份

    @Size(max = 18, message = "最近 24 个月交易金额长度不超过{max}位")
    private String lastTwoYearsAmt;//最近 24 个月交易金额

    @Size(max = 18, message = "最近 24 个月交易订单数长度不超过{max}位")
    private String lastTwoYearsOrderNum;//最近 24 个月交易订单数

    @Size(max = 5, message = "最近 12 个月交易月份长度不超过{max}位")
    private String lastYearMonths;//最近 12 个月交易月份

    @Size(max = 18, message = "最近 12 个月交易金额长度不超过{max}位")
    private String lastYearAmt;//最近 12 个月交易金额

    @Size(max = 18, message = "最近 12 个月交易订单数长度不超过{max}位")
    private String lastYearOrderNum;//最近 12 个月交易订单数

    @Size(max = 5, message = "最近 6 个月交易月份长度不超过{max}位")
    private String lastSixMonths;//最近 6 个月交易月份

    @Size(max = 18, message = "最近 6 个月交易金额长度不超过{max}位")
    private String lastSixMonthsAmt;//最近 6个月交易金额

    @Size(max = 18, message = "最近 6 个月交易订单数长度不超过{max}位")
    private String lastSixMonthsOrderNum;//最近 6个月交易订单数

    @Size(max = 5, message = "最近 3 个月交易月份长度不超过{max}位")
    private String lastThreeMonths;//最近 3个月交易月份

    @Size(max = 18, message = "最近 3 个月交易金额长度不超过{max}位")
    private String lastThreeMonthsAmt;//最近 3个月交易金额

    @Size(max = 18, message = "最近 3 个月交易订单数长度不超过{max}位")
    private String lastThreeMonthsOrderNum;//最近 3个月交易订单数

    @Size(max = 5, message = "与平台金融合作时间长度不超过{max}位")
    private String cooperateFSPTime;//与平台金融合作时间 单位月

    @Size(max = 18, message = "在平台金融结算金额长度不超过{max}位")
    private String cooperateFSPAmt;//在平台金融结算金额

    @Size(max = 18, message = "在平台金融结算笔数长度不超过{max}位")
    private String cooperateFSPTimeNum;//在平台金融结算笔数

    @Size(max = 18, message = "最近 12 个月联系人变更次数长度不超过{max}位")
    private String lastYearContactChangeNum;//最近 12 个月联系人变更次数

    @Size(max = 18, message = "最近 12 个月联系方式变更次数长度不超过{max}位")
    private String lastYearContactInfoChangeNum;//最近 12 个月联系方式变更次数

    @Size(max = 18, message = "最近 12 个月收货地址更次数长度不超过{max}位")
    private String lastYearRecAddressChangeNum;//最近 12 个月收货地址更次数

    @Size(max = 18, message = "最近 12 个月收货信息更次数长度不超过{max}位")
    private String lastYearRecInfoChangeNum;//最近 12 个月收货信息更次数

    @Size(max = 18, message = "最近 12 个月供应商数量长度不超过{max}位")
    private String lastYearSupplierNum;//最近 12 个月供应商数量

    @Size(max = 18, message = "最近 12 个月前十大供应商交易额长度不超过{max}位")
    private String lastYearTopTenSupplierTransAmt;//最近 12 个月前十大供应商交易额

    @Size(max = 18, message = "前十大供应商交易额占比长度不超过{max}位")
    private String lastYearTopTenSupplierTransPrp;//前十大供应商交易额占比

    @Size(max = 18, message = "最近 12 个月采购商品数量长度不超过{max}位")
    private String lastYearGoodsNum;//最近 12 个月采购商品数量

    @Size(max = 18, message = "最近 12 个月前十大商品交易额长度不超过{max}位")
    private String lastYearTopTenGoodsTransAmt;//最近 12 个月前十大商品交易额

    @Size(max = 18, message = "前十大商品交易额占比长度不超过{max}位")
    private String lastYearTopTenGoodsTransPrp;//前十大商品交易额占比

    private List<OrderTransList> orderTransList;//订单统计月交易统计 1 月到 24 月

    private List<OrderSupplierList> orderSupplierList;//订单统计供应商统计

    private List<ReceiptList> receiptList; //收货信息统计
*/
    @JSONField(name = "orderStatus")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @JSONField(name = "orderTime")
    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    @JSONField(name = "buyerMobile")
    public String getBuyerMobile() {
        return buyerMobile;
    }

    public void setBuyerMobile(String buyerMobile) {
        this.buyerMobile = buyerMobile;
    }

    @JSONField(name = "buyerDate")
    public String getBuyerDate() {
        return buyerDate;
    }

    public void setBuyerDate(String buyerDate) {
        this.buyerDate = buyerDate;
    }

    @JSONField(name = "buyerAddress")
    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    @JSONField(name = "sellerMobile")
    public String getSellerMobile() {
        return sellerMobile;
    }

    public void setSellerMobile(String sellerMobile) {
        this.sellerMobile = sellerMobile;
    }

    @JSONField(name = "sellerDate")
    public String getSellerDate() {
        return sellerDate;
    }

    public void setSellerDate(String sellerDate) {
        this.sellerDate = sellerDate;
    }

    @JSONField(name = "sellerAddress")
    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    @JSONField(name = "contractNo")
    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @JSONField(name = "shipOrderNo")
    public String getShipOrderNo() {
        return shipOrderNo;
    }

    public void setShipOrderNo(String shipOrderNo) {
        this.shipOrderNo = shipOrderNo;
    }

    @JSONField(name = "payStatus")
    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    @JSONField(name = "checkTime")
    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    @JSONField(name = "payTime")
    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    @JSONField(name = "confirmRecTime")
    public String getConfirmRecTime() {
        return confirmRecTime;
    }

    public void setConfirmRecTime(String confirmRecTime) {
        this.confirmRecTime = confirmRecTime;
    }

    @JSONField(name = "orderRemarks")
    public String getOrderRemarks() {
        return orderRemarks;
    }

    public void setOrderRemarks(String orderRemarks) {
        this.orderRemarks = orderRemarks;
    }

    @JSONField(name = "dueDate")
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
/*
    @JSONField(name = "cooperateTime")
    public String getCooperateTime() {
        return cooperateTime;
    }

    public void setCooperateTime(String cooperateTime) {
        this.cooperateTime = cooperateTime;
    }

    @JSONField(name = "lastTwoYearsMonths")
    public String getLastTwoYearsMonths() {
        return lastTwoYearsMonths;
    }

    public void setLastTwoYearsMonths(String lastTwoYearsMonths) {
        this.lastTwoYearsMonths = lastTwoYearsMonths;
    }

    @JSONField(name = "lastTwoYearsAmt")
    public String getLastTwoYearsAmt() {
        return lastTwoYearsAmt;
    }

    public void setLastTwoYearsAmt(String lastTwoYearsAmt) {
        this.lastTwoYearsAmt = lastTwoYearsAmt;
    }

    @JSONField(name = "lastTwoYearsOrderNum")
    public String getLastTwoYearsOrderNum() {
        return lastTwoYearsOrderNum;
    }

    public void setLastTwoYearsOrderNum(String lastTwoYearsOrderNum) {
        this.lastTwoYearsOrderNum = lastTwoYearsOrderNum;
    }

    @JSONField(name = "lastYearMonths")
    public String getLastYearMonths() {
        return lastYearMonths;
    }

    public void setLastYearMonths(String lastYearMonths) {
        this.lastYearMonths = lastYearMonths;
    }

    @JSONField(name = "lastYearAmt")
    public String getLastYearAmt() {
        return lastYearAmt;
    }

    public void setLastYearAmt(String lastYearAmt) {
        this.lastYearAmt = lastYearAmt;
    }

    @JSONField(name = "lastYearOrderNum")
    public String getLastYearOrderNum() {
        return lastYearOrderNum;
    }

    public void setLastYearOrderNum(String lastYearOrderNum) {
        this.lastYearOrderNum = lastYearOrderNum;
    }

    @JSONField(name = "lastSixMonths")
    public String getLastSixMonths() {
        return lastSixMonths;
    }

    public void setLastSixMonths(String lastSixMonths) {
        this.lastSixMonths = lastSixMonths;
    }

    @JSONField(name = "lastSixMonthsAmt")
    public String getLastSixMonthsAmt() {
        return lastSixMonthsAmt;
    }

    public void setLastSixMonthsAmt(String lastSixMonthsAmt) {
        this.lastSixMonthsAmt = lastSixMonthsAmt;
    }

    @JSONField(name = "lastSixMonthsOrderNum")
    public String getLastSixMonthsOrderNum() {
        return lastSixMonthsOrderNum;
    }

    public void setLastSixMonthsOrderNum(String lastSixMonthsOrderNum) {
        this.lastSixMonthsOrderNum = lastSixMonthsOrderNum;
    }

    @JSONField(name = "lastThreeMonths")
    public String getLastThreeMonths() {
        return lastThreeMonths;
    }

    public void setLastThreeMonths(String lastThreeMonths) {
        this.lastThreeMonths = lastThreeMonths;
    }

    @JSONField(name = "lastThreeMonthsAmt")
    public String getLastThreeMonthsAmt() {
        return lastThreeMonthsAmt;
    }

    public void setLastThreeMonthsAmt(String lastThreeMonthsAmt) {
        this.lastThreeMonthsAmt = lastThreeMonthsAmt;
    }

    @JSONField(name = "lastThreeMonthsOrderNum")
    public String getLastThreeMonthsOrderNum() {
        return lastThreeMonthsOrderNum;
    }

    public void setLastThreeMonthsOrderNum(String lastThreeMonthsOrderNum) {
        this.lastThreeMonthsOrderNum = lastThreeMonthsOrderNum;
    }

    @JSONField(name = "cooperateFSPTime")
    public String getCooperateFSPTime() {
        return cooperateFSPTime;
    }

    public void setCooperateFSPTime(String cooperateFSPTime) {
        this.cooperateFSPTime = cooperateFSPTime;
    }

    @JSONField(name = "cooperateFSPAmt")
    public String getCooperateFSPAmt() {
        return cooperateFSPAmt;
    }

    public void setCooperateFSPAmt(String cooperateFSPAmt) {
        this.cooperateFSPAmt = cooperateFSPAmt;
    }

    @JSONField(name = "cooperateFSPTimeNum")
    public String getCooperateFSPTimeNum() {
        return cooperateFSPTimeNum;
    }

    public void setCooperateFSPTimeNum(String cooperateFSPTimeNum) {
        this.cooperateFSPTimeNum = cooperateFSPTimeNum;
    }

    @JSONField(name = "lastYearContactChangeNum")
    public String getLastYearContactChangeNum() {
        return lastYearContactChangeNum;
    }

    public void setLastYearContactChangeNum(String lastYearContactChangeNum) {
        this.lastYearContactChangeNum = lastYearContactChangeNum;
    }

    @JSONField(name = "lastYearContactInfoChangeNum")
    public String getLastYearContactInfoChangeNum() {
        return lastYearContactInfoChangeNum;
    }

    public void setLastYearContactInfoChangeNum(String lastYearContactInfoChangeNum) {
        this.lastYearContactInfoChangeNum = lastYearContactInfoChangeNum;
    }

    @JSONField(name = "lastYearRecAddressChangeNum")
    public String getLastYearRecAddressChangeNum() {
        return lastYearRecAddressChangeNum;
    }

    public void setLastYearRecAddressChangeNum(String lastYearRecAddressChangeNum) {
        this.lastYearRecAddressChangeNum = lastYearRecAddressChangeNum;
    }

    @JSONField(name = "lastYearRecInfoChangeNum")
    public String getLastYearRecInfoChangeNum() {
        return lastYearRecInfoChangeNum;
    }

    public void setLastYearRecInfoChangeNum(String lastYearRecInfoChangeNum) {
        this.lastYearRecInfoChangeNum = lastYearRecInfoChangeNum;
    }

    @JSONField(name = "lastYearSupplierNum")
    public String getLastYearSupplierNum() {
        return lastYearSupplierNum;
    }

    public void setLastYearSupplierNum(String lastYearSupplierNum) {
        this.lastYearSupplierNum = lastYearSupplierNum;
    }

    @JSONField(name = "lastYearTopTenSupplierTransAmt")
    public String getLastYearTopTenSupplierTransAmt() {
        return lastYearTopTenSupplierTransAmt;
    }

    public void setLastYearTopTenSupplierTransAmt(String lastYearTopTenSupplierTransAmt) {
        this.lastYearTopTenSupplierTransAmt = lastYearTopTenSupplierTransAmt;
    }

    @JSONField(name = "lastYearTopTenSupplierTransPrp")
    public String getLastYearTopTenSupplierTransPrp() {
        return lastYearTopTenSupplierTransPrp;
    }

    public void setLastYearTopTenSupplierTransPrp(String lastYearTopTenSupplierTransPrp) {
        this.lastYearTopTenSupplierTransPrp = lastYearTopTenSupplierTransPrp;
    }

    @JSONField(name = "lastYearGoodsNum")
    public String getLastYearGoodsNum() {
        return lastYearGoodsNum;
    }

    public void setLastYearGoodsNum(String lastYearGoodsNum) {
        this.lastYearGoodsNum = lastYearGoodsNum;
    }

    @JSONField(name = "lastYearTopTenGoodsTransAmt")
    public String getLastYearTopTenGoodsTransAmt() {
        return lastYearTopTenGoodsTransAmt;
    }

    public void setLastYearTopTenGoodsTransAmt(String lastYearTopTenGoodsTransAmt) {
        this.lastYearTopTenGoodsTransAmt = lastYearTopTenGoodsTransAmt;
    }

    @JSONField(name = "lastYearTopTenGoodsTransPrp")
    public String getLastYearTopTenGoodsTransPrp() {
        return lastYearTopTenGoodsTransPrp;
    }

    public void setLastYearTopTenGoodsTransPrp(String lastYearTopTenGoodsTransPrp) {
        this.lastYearTopTenGoodsTransPrp = lastYearTopTenGoodsTransPrp;
    }

    @JSONField(name = "orderTransList")
    public List<OrderTransList> getOrderTransList() {
        return orderTransList;
    }

    public void setOrderTransList(List<OrderTransList> orderTransList) {
        this.orderTransList = orderTransList;
    }

    @JSONField(name = "orderSupplierList")
    public List<OrderSupplierList> getOrderSupplierList() {
        return orderSupplierList;
    }

    public void setOrderSupplierList(List<OrderSupplierList> orderSupplierList) {
        this.orderSupplierList = orderSupplierList;
    }

    @JSONField(name = "receiptList")
    public List<ReceiptList> getReceiptList() {
        return receiptList;
    }

    public void setReceiptList(List<ReceiptList> receiptList) {
        this.receiptList = receiptList;
    }

 */
}
