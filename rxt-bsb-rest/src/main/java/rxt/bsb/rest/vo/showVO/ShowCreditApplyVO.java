package rxt.bsb.rest.vo.showVO;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ShowCreditApplyVO  implements Serializable {

    private String id;

    private String custName;

    private String custNo;

    private String applyNo;

    private String creditAmt;

    private String product;

    private String repayType;

    private Integer applyTerm;

    private String repaySource;

    private Integer payDay;

    private Integer payDistance;

    private String assureMeansMain;

    private String payType;

    private String loanUse;

    private String applyChannel;

    private String isCircle;

    private String isMultiLoan;

    private String financeRate;

    private String loanNo;

    private String contractNo;

    private String contractPath;

    private String status;


    private String failReason;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String auditDatas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getCreditAmt() {
        return creditAmt;
    }

    public void setCreditAmt(String creditAmt) {
        this.creditAmt = creditAmt;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public Integer getApplyTerm() {
        return applyTerm;
    }

    public void setApplyTerm(Integer applyTerm) {
        this.applyTerm = applyTerm;
    }

    public String getRepaySource() {
        return repaySource;
    }

    public void setRepaySource(String repaySource) {
        this.repaySource = repaySource;
    }

    public Integer getPayDay() {
        return payDay;
    }

    public void setPayDay(Integer payDay) {
        this.payDay = payDay;
    }

    public Integer getPayDistance() {
        return payDistance;
    }

    public void setPayDistance(Integer payDistance) {
        this.payDistance = payDistance;
    }

    public String getAssureMeansMain() {
        return assureMeansMain;
    }

    public void setAssureMeansMain(String assureMeansMain) {
        this.assureMeansMain = assureMeansMain;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse;
    }

    public String getApplyChannel() {
        return applyChannel;
    }

    public void setApplyChannel(String applyChannel) {
        this.applyChannel = applyChannel;
    }

    public String getIsCircle() {
        return isCircle;
    }

    public void setIsCircle(String isCircle) {
        this.isCircle = isCircle;
    }

    public String getIsMultiLoan() {
        return isMultiLoan;
    }

    public void setIsMultiLoan(String isMultiLoan) {
        this.isMultiLoan = isMultiLoan;
    }

    public String getFinanceRate() {
        return financeRate;
    }

    public void setFinanceRate(String financeRate) {
        this.financeRate = financeRate;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractPath() {
        return contractPath;
    }

    public void setContractPath(String contractPath) {
        this.contractPath = contractPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAuditDatas() {
        return auditDatas;
    }

    public void setAuditDatas(String auditDatas) {
        this.auditDatas = auditDatas;
    }
}
