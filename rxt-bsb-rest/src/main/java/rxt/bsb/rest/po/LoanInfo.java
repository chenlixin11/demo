package rxt.bsb.rest.po;

import java.util.Date;

public class LoanInfo {
    private Integer id;

    private Integer loanApplyId;

    private Integer agentInfoId;

    private String debitNo;

    private String stat;

    private String loanAcct;

    private String loanAmt;

    private String loanBegDate;

    private String loanEndDte;

    private String dueDay;

    private String extRate;

    private String balance;

    private String repayType;

    private String totalRepayTerms;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDebitNo() {
        return debitNo;
    }

    public void setDebitNo(String debitNo) {
        this.debitNo = debitNo == null ? null : debitNo.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public String getLoanAcct() {
        return loanAcct;
    }

    public void setLoanAcct(String loanAcct) {
        this.loanAcct = loanAcct == null ? null : loanAcct.trim();
    }

    public String getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(String loanAmt) {
        this.loanAmt = loanAmt == null ? null : loanAmt.trim();
    }

    public String getLoanBegDate() {
        return loanBegDate;
    }

    public void setLoanBegDate(String loanBegDate) {
        this.loanBegDate = loanBegDate == null ? null : loanBegDate.trim();
    }

    public String getLoanEndDte() {
        return loanEndDte;
    }

    public void setLoanEndDte(String loanEndDte) {
        this.loanEndDte = loanEndDte == null ? null : loanEndDte.trim();
    }

    public String getDueDay() {
        return dueDay;
    }

    public void setDueDay(String dueDay) {
        this.dueDay = dueDay == null ? null : dueDay.trim();
    }

    public String getExtRate() {
        return extRate;
    }

    public void setExtRate(String extRate) {
        this.extRate = extRate == null ? null : extRate.trim();
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance == null ? null : balance.trim();
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType == null ? null : repayType.trim();
    }

    public String getTotalRepayTerms() {
        return totalRepayTerms;
    }

    public void setTotalRepayTerms(String totalRepayTerms) {
        this.totalRepayTerms = totalRepayTerms == null ? null : totalRepayTerms.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}