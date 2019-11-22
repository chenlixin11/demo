package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * Created by ChenLiXin on 2019/9/18 0018 11:28
 */
public class OrderListReqDto implements Serializable {

    @NotBlank(message = "单据编号不能空")
    @Size(max = 32, message = "单据编号长度不超过{max}位")
    private String BillCode; //单据编号

    @NotBlank(message = "单据名称不能空")
    @Size(max = 32, message = "单据名称长度不超过{max}位")
    private String BillName; //单据名称

    @NotBlank(message = "单据类型不能空")
    @Size(max = 2, message = "单据类型长度不超过{max}位")
    private String BillType; //单据类型 03 发票 04 应收 05 汇总

    @NotBlank(message = "单据总金额不能空")
    @Size(max = 18, message = "单据总金额长度不超过{max}位")
    private String BillTotalMoney; //单据总金额

    @Size(max = 1000, message = "单据总金额长度不超过{max}位")
    private String BillSummary; //摘要

    @NotBlank(message = "买方名称不能空")
    @Size(max = 32, message = "买方名称长度不超过{max}位")
    private String BuyerName; //买方名称

    @NotBlank(message = "买方编号不能空")
    @Size(max = 32, message = "买方编号长度不超过{max}位")
    private String BuyerNo; //买方编号

    @NotBlank(message = "卖方名称不能空")
    @Size(max = 32, message = "卖方名称长度不超过{max}位")
    private String SellerName; //卖方名称

    @NotBlank(message = "卖方编号不能空")
    @Size(max = 32, message = "卖方编号长度不超过{max}位")
    private String SellerNo; //卖方编号

    @NotBlank(message = "已付金额不能空")
    @Size(max = 18, message = "已付金额长度不超过{max}位")
    private String PaidAmount; //已付金额

    @NotBlank(message = "应付金额不能空")
    @Size(max = 18, message = "应付金额长度不超过{max}位")
    private String PayableAmount; //应付金额

    @NotBlank(message = "尾款金额不能空")
    @Size(max = 18, message = "尾款金额长度不超过{max}位")
    private String TailAmount; //尾款金额

    private OrderAdditionalParam Json; //订单额外参数 订单中的其他信息以json 串形式传送

    @NotBlank(message = "操作标志不能空")
    @Size(max = 2, message = "操作标志长度不超过位{max}")
    private String  OperateFlag   ;//操作标志

    private List<GoodsListDto> GoodsList; //商品列表

    @JSONField(name = "BillCode")
    public String getBillCode() {
        return BillCode;
    }

    public void setBillCode(String billCode) {
        BillCode = billCode;
    }

    @JSONField(name = "BillName")
    public String getBillName() {
        return BillName;
    }

    public void setBillName(String billName) {
        BillName = billName;
    }

    @JSONField(name = "BillType")
    public String getBillType() {
        return BillType;
    }

    public void setBillType(String billType) {
        BillType = billType;
    }

    @JSONField(name = "BillTotalMoney")
    public String getBillTotalMoney() {
        return BillTotalMoney;
    }

    public void setBillTotalMoney(String billTotalMoney) {
        BillTotalMoney = billTotalMoney;
    }

    @JSONField(name = "BillSummary")
    public String getBillSummary() {
        return BillSummary;
    }

    public void setBillSummary(String billSummary) {
        BillSummary = billSummary;
    }

    @JSONField(name = "BuyerName")
    public String getBuyerName() {
        return BuyerName;
    }

    public void setBuyerName(String buyerName) {
        BuyerName = buyerName;
    }

    @JSONField(name = "BuyerNo")
    public String getBuyerNo() {
        return BuyerNo;
    }

    public void setBuyerNo(String buyerNo) {
        BuyerNo = buyerNo;
    }

    @JSONField(name = "SellerName")
    public String getSellerName() {
        return SellerName;
    }

    public void setSellerName(String sellerName) {
        SellerName = sellerName;
    }

    @JSONField(name = "SellerNo")
    public String getSellerNo() {
        return SellerNo;
    }

    public void setSellerNo(String sellerNo) {
        SellerNo = sellerNo;
    }

    @JSONField(name = "PaidAmount")
    public String getPaidAmount() {
        return PaidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        PaidAmount = paidAmount;
    }

    @JSONField(name = "PayableAmount")
    public String getPayableAmount() {
        return PayableAmount;
    }

    public void setPayableAmount(String payableAmount) {
        PayableAmount = payableAmount;
    }

    @JSONField(name = "TailAmount")
    public String getTailAmount() {
        return TailAmount;
    }

    public void setTailAmount(String tailAmount) {
        TailAmount = tailAmount;
    }

    @JSONField(name = "Json")
    public OrderAdditionalParam getJson() {
        return Json;
    }

    public void setJson(OrderAdditionalParam json) {
        Json = json;
    }

    @JSONField(name = "OperateFlag")
    public String getOperateFlag() {
        return OperateFlag;
    }

    public void setOperateFlag(String operateFlag) {
        OperateFlag = operateFlag;
    }

    @JSONField(name = "GoodsList")
    public List<GoodsListDto> getGoodsList() {
        return GoodsList;
    }

    public void setGoodsList(List<GoodsListDto> goodsList) {
        GoodsList = goodsList;
    }
}
