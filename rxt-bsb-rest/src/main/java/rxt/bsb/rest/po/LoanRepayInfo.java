package rxt.bsb.rest.po;

import java.util.Date;

public class LoanRepayInfo {
    private Integer id;

    private Integer loanInfoId;

    private Integer loanApplyId;

    private Integer agentInfoId;

    private String loanApplyNo;

    private String unRepayPrin;

    private String loanAmt;

    private String repayType;

    private String repayAssetNo;

    private String repayAmt;

    private String repayPrinAmt;

    private String repayAccrual;

    private String totalReapyAmount;

    private String amount;

    private String currentInterest;

    private String overdueAmt;

    private String overdueInterest;

    private String overdueTotal;

    private String status;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanInfoId() {
        return loanInfoId;
    }

    public void setLoanInfoId(Integer loanInfoId) {
        this.loanInfoId = loanInfoId;
    }

    public Integer getLoanApplyId() {
        return loanApplyId;
    }

    public void setLoanApplyId(Integer loanApplyId) {
        this.loanApplyId = loanApplyId;
    }

    public Integer getAgentInfoId() {
        return agentInfoId;
    }

    public void setAgentInfoId(Integer agentInfoId) {
        this.agentInfoId = agentInfoId;
    }

    public String getLoanApplyNo() {
        return loanApplyNo;
    }

    public void setLoanApplyNo(String loanApplyNo) {
        this.loanApplyNo = loanApplyNo == null ? null : loanApplyNo.trim();
    }

    public String getUnRepayPrin() {
        return unRepayPrin;
    }

    public void setUnRepayPrin(String unRepayPrin) {
        this.unRepayPrin = unRepayPrin == null ? null : unRepayPrin.trim();
    }

    public String getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(String loanAmt) {
        this.loanAmt = loanAmt == null ? null : loanAmt.trim();
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType == null ? null : repayType.trim();
    }

    public String getRepayAssetNo() {
        return repayAssetNo;
    }

    public void setRepayAssetNo(String repayAssetNo) {
        this.repayAssetNo = repayAssetNo == null ? null : repayAssetNo.trim();
    }

    public String getRepayAmt() {
        return repayAmt;
    }

    public void setRepayAmt(String repayAmt) {
        this.repayAmt = repayAmt == null ? null : repayAmt.trim();
    }

    public String getRepayPrinAmt() {
        return repayPrinAmt;
    }

    public void setRepayPrinAmt(String repayPrinAmt) {
        this.repayPrinAmt = repayPrinAmt == null ? null : repayPrinAmt.trim();
    }

    public String getRepayAccrual() {
        return repayAccrual;
    }

    public void setRepayAccrual(String repayAccrual) {
        this.repayAccrual = repayAccrual == null ? null : repayAccrual.trim();
    }

    public String getTotalReapyAmount() {
        return totalReapyAmount;
    }

    public void setTotalReapyAmount(String totalReapyAmount) {
        this.totalReapyAmount = totalReapyAmount == null ? null : totalReapyAmount.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getCurrentInterest() {
        return currentInterest;
    }

    public void setCurrentInterest(String currentInterest) {
        this.currentInterest = currentInterest == null ? null : currentInterest.trim();
    }

    public String getOverdueAmt() {
        return overdueAmt;
    }

    public void setOverdueAmt(String overdueAmt) {
        this.overdueAmt = overdueAmt == null ? null : overdueAmt.trim();
    }

    public String getOverdueInterest() {
        return overdueInterest;
    }

    public void setOverdueInterest(String overdueInterest) {
        this.overdueInterest = overdueInterest == null ? null : overdueInterest.trim();
    }

    public String getOverdueTotal() {
        return overdueTotal;
    }

    public void setOverdueTotal(String overdueTotal) {
        this.overdueTotal = overdueTotal == null ? null : overdueTotal.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}