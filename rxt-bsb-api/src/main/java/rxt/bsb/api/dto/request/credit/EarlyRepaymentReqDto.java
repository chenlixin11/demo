package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 3.1.6提前还款（实时模式）请求报文
 * Created by ChenLiXin on 2019/9/18 0018 10:41
 */
public class EarlyRepaymentReqDto implements Serializable {

    @NotBlank(message="渠道编号不能空")
    @Size(max=20,message="渠道编号长度不能超过{max}位")
    private String ChannelNo;//渠道编号

    @NotBlank(message="融资申请编号不能空")
    @Size(max=32,message="融资申请编号长度不能超过{max}位")
    private String  FinancApplyNo;//融资申请编号

    @NotBlank(message="还款范围不能空")
    @Size(max=10,message="还款范围长度不能超过{max}位")
    private String  RepayType;//还款范围

    @NotBlank(message="还款账号不能空")
    @Size(max=64,message="还款账号长度不能超过{max}位")
    private String  RepayAssetNo;//还款账号

    private String RepayAmt;//还款金额

    private String UnRepayPrin;//未归还本金

    private String LoanAmt;//贷款金额  融资申请时的贷款金额

    private String  RepayPrinAmt;//还款本金  还款本金！ 指定本金时此为必输项

    private String MerMemberNo;  //平台会员号

    @JSONField(name = "MerMemberNo")
    public String getMerMemberNo() {
        return MerMemberNo;
    }

    public void setMerMemberNo(String merMemberNo) {
        MerMemberNo = merMemberNo;
    }

    @JSONField(name = "ChannelNo")
    public String getChannelNo() {
        return ChannelNo;
    }

    public void setChannelNo(String channelNo) {
        ChannelNo = channelNo;
    }

    @JSONField(name = "FinancApplyNo")
    public String getFinancApplyNo() {
        return FinancApplyNo;
    }

    public void setFinancApplyNo(String financApplyNo) {
        FinancApplyNo = financApplyNo;
    }

    @JSONField(name = "RepayType")
    public String getRepayType() {
        return RepayType;
    }

    public void setRepayType(String repayType) {
        RepayType = repayType;
    }

    @JSONField(name = "RepayAssetNo")
    public String getRepayAssetNo() {
        return RepayAssetNo;
    }

    public void setRepayAssetNo(String repayAssetNo) {
        RepayAssetNo = repayAssetNo;
    }

    @JSONField(name = "RepayAmt")
    public String getRepayAmt() {
        return RepayAmt;
    }

    public void setRepayAmt(String repayAmt) {
        RepayAmt = repayAmt;
    }

    @JSONField(name = "UnRepayPrin")
    public String getUnRepayPrin() {
        return UnRepayPrin;
    }

    public void setUnRepayPrin(String unRepayPrin) {
        UnRepayPrin = unRepayPrin;
    }

    @JSONField(name = "LoanAmt")
    public String getLoanAmt() {
        return LoanAmt;
    }

    public void setLoanAmt(String loanAmt) {
        LoanAmt = loanAmt;
    }

    @JSONField(name = "RepayPrinAmt")
    public String getRepayPrinAmt() {
        return RepayPrinAmt;
    }

    public void setRepayPrinAmt(String repayPrinAmt) {
        RepayPrinAmt = repayPrinAmt;
    }
}
