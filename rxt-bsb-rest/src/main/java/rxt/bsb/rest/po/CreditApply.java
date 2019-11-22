package rxt.bsb.rest.po;

import java.util.Date;

public class CreditApply {
    private Integer id;

    private Integer agentInfoId;

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

    private Date createTime;

    private String auditDatas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgentInfoId() {
        return agentInfoId;
    }

    public void setAgentInfoId(Integer agentInfoId) {
        this.agentInfoId = agentInfoId;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo == null ? null : applyNo.trim();
    }

    public String getCreditAmt() {
        return creditAmt;
    }

    public void setCreditAmt(String creditAmt) {
        this.creditAmt = creditAmt == null ? null : creditAmt.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType == null ? null : repayType.trim();
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
        this.repaySource = repaySource == null ? null : repaySource.trim();
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
        this.assureMeansMain = assureMeansMain == null ? null : assureMeansMain.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse == null ? null : loanUse.trim();
    }

    public String getApplyChannel() {
        return applyChannel;
    }

    public void setApplyChannel(String applyChannel) {
        this.applyChannel = applyChannel == null ? null : applyChannel.trim();
    }

    public String getIsCircle() {
        return isCircle;
    }

    public void setIsCircle(String isCircle) {
        this.isCircle = isCircle == null ? null : isCircle.trim();
    }

    public String getIsMultiLoan() {
        return isMultiLoan;
    }

    public void setIsMultiLoan(String isMultiLoan) {
        this.isMultiLoan = isMultiLoan == null ? null : isMultiLoan.trim();
    }

    public String getFinanceRate() {
        return financeRate;
    }

    public void setFinanceRate(String financeRate) {
        this.financeRate = financeRate == null ? null : financeRate.trim();
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo == null ? null : loanNo.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getContractPath() {
        return contractPath;
    }

    public void setContractPath(String contractPath) {
        this.contractPath = contractPath == null ? null : contractPath.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
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
        this.auditDatas = auditDatas == null ? null : auditDatas.trim();
    }
}