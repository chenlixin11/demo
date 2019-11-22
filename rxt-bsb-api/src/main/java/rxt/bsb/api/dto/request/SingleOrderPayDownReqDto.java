package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import rxt.bsb.api.dto.request.entity.SingleOrderFee;
import rxt.bsb.api.dto.request.entity.SingleOrderGood;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 * @Copyright (c)</   b> 2012融信通-版权所有<br/>
 * @createTime 2019年1月25日 下午4:42:40
 * @Description: 个人订单单笔即时支付  个人订单加强型单笔即时支付
 */
public class SingleOrderPayDownReqDto implements Serializable {
    /**
     * 序列化标记
     */
    private static final long serialVersionUID = -7391225867100071598L;
    @Size(max = 32, message = "付款资金账号长度不能超过{max}位")
    private String PaySubAcctNo;//付款资金账号
    @Size(max = 32, message = "收款资金账号长度不能超过{max}位")
    private String RcvSubAcctNo;//收款资金账号
    @Size(max = 32, message = "银行卡号长度不能超过{max}位")
    private String OppAcctNo;  //银行卡号
    @Size(max = 32, message = "支付类型长度不能超过{max}位")
    private String PayType; //支付类型 1、虚账户支付 2、银行卡支付）
    @Size(max = 16, message = "订单总额长度不能超过{max}位")
    private String TotalAmt;//订单总额
    @Size(max = 16, message = "实付金额长度不能超过{max}位")
    private String RealPayAmt;//实付金额
    @Size(max = 16, message = "积分抵扣金额长度不能超过{max}位")
    private String BPAmt;//积分抵扣金额
    @Size(max = 16, message = "红包抵扣金额长度不能超过{max}位")
    private String RedPackAmt;//红包抵扣金额
    @Size(max = 16, message = "卡券抵扣金额长度不能超过{max}位")
    private String CouponAmt;//卡券抵扣金额
    @Valid
    private List<SingleOrderFee> FeeList;
    @Valid
    private List<SingleOrderGood> GoodList;

    @JSONField(name = "OppAcctNo")
    public String getOppAcctNo() {
        return OppAcctNo;
    }

    public void setOppAcctNo(String oppAcctNo) {
        OppAcctNo = oppAcctNo;
    }

    @JSONField(name = "PayType")
    public String getPayType() {
        return PayType;
    }

    public void setPayType(String payType) {
        PayType = payType;
    }

    @JSONField(name = "PaySubAcctNo")
    public String getPaySubAcctNo() {
        return PaySubAcctNo;
    }

    public void setPaySubAcctNo(String paySubAcctNo) {
        PaySubAcctNo = paySubAcctNo;
    }

    @JSONField(name = "RcvSubAcctNo")
    public String getRcvSubAcctNo() {
        return RcvSubAcctNo;
    }

    public void setRcvSubAcctNo(String rcvSubAcctNo) {
        RcvSubAcctNo = rcvSubAcctNo;
    }

    @JSONField(name = "TotalAmt")
    public String getTotalAmt() {
        return TotalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        TotalAmt = totalAmt;
    }

    @JSONField(name = "RealPayAmt")
    public String getRealPayAmt() {
        return RealPayAmt;
    }

    public void setRealPayAmt(String realPayAmt) {
        RealPayAmt = realPayAmt;
    }

    @JSONField(name = "BPAmt")
    public String getBPAmt() {
        return BPAmt;
    }

    public void setBPAmt(String bPAmt) {
        BPAmt = bPAmt;
    }

    @JSONField(name = "RedPackAmt")
    public String getRedPackAmt() {
        return RedPackAmt;
    }

    public void setRedPackAmt(String redPackAmt) {
        RedPackAmt = redPackAmt;
    }

    @JSONField(name = "CouponAmt")
    public String getCouponAmt() {
        return CouponAmt;
    }

    public void setCouponAmt(String couponAmt) {
        CouponAmt = couponAmt;
    }

    @JSONField(name = "FeeList")
    public List<SingleOrderFee> getFeeList() {
        return FeeList;
    }

    public void setFeeList(List<SingleOrderFee> feeList) {
        FeeList = feeList;
    }

    @JSONField(name = "GoodList")
    public List<SingleOrderGood> getGoodList() {
        return GoodList;
    }

    public void setGoodList(List<SingleOrderGood> goodList) {
        GoodList = goodList;
    }
}
