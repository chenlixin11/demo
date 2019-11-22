package rxt.bsb.api.dto.response.query;

import java.io.Serializable;

/**
 * Created by ChenLiXin on 2019/9/18 0018 16:56
 */
public class ScfRepayResultQueryDtoList implements Serializable {


    /**
     * RepayType : 0
     * RepayStat : 02
     * RepayDate : 20190101
     * FinsncApplyNo : abcd20190101123457
     * FinsncApplyAmt : 1000
     * RepayAssetNo : 9956700001012345679
     * NormalAmt : 1000
     * NormalAccrual : 100
     * ApplyDate : 20191212
     * SerialNo : 2315646578978934
     */

    private String RepayType;//还款范围
    private String RepayStat;//还款状态
    private String RepayDate;//开始日期
    private String FinsncApplyNo;//融资申请编号
    private String FinsncApplyAmt;//融资申请金额
    private String RepayAssetNo;//还款账号
    private String NormalAmt;//正常归还本金
    private String NormalAccrual;//正常归还利息
    private String ApplyDate;//还款申请日期
    private String SerialNo;//流水号

    public String getRepayType() {
        return RepayType;
    }

    public void setRepayType(String RepayType) {
        this.RepayType = RepayType;
    }

    public String getRepayStat() {
        return RepayStat;
    }

    public void setRepayStat(String RepayStat) {
        this.RepayStat = RepayStat;
    }

    public String getRepayDate() {
        return RepayDate;
    }

    public void setRepayDate(String RepayDate) {
        this.RepayDate = RepayDate;
    }

    public String getFinsncApplyNo() {
        return FinsncApplyNo;
    }

    public void setFinsncApplyNo(String FinsncApplyNo) {
        this.FinsncApplyNo = FinsncApplyNo;
    }

    public String getFinsncApplyAmt() {
        return FinsncApplyAmt;
    }

    public void setFinsncApplyAmt(String FinsncApplyAmt) {
        this.FinsncApplyAmt = FinsncApplyAmt;
    }

    public String getRepayAssetNo() {
        return RepayAssetNo;
    }

    public void setRepayAssetNo(String RepayAssetNo) {
        this.RepayAssetNo = RepayAssetNo;
    }

    public String getNormalAmt() {
        return NormalAmt;
    }

    public void setNormalAmt(String NormalAmt) {
        this.NormalAmt = NormalAmt;
    }

    public String getNormalAccrual() {
        return NormalAccrual;
    }

    public void setNormalAccrual(String NormalAccrual) {
        this.NormalAccrual = NormalAccrual;
    }

    public String getApplyDate() {
        return ApplyDate;
    }

    public void setApplyDate(String ApplyDate) {
        this.ApplyDate = ApplyDate;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String SerialNo) {
        this.SerialNo = SerialNo;
    }
}
