package rxt.bsb.rest.po;

import java.util.Date;

public class LoanRepayPlan {
    private Integer id;

    private Integer loanInfoId;

    private Integer agentInfoId;

    private String dueDate;

    private String period;

    private String extRate;

    private String amount;

    private String interest;

    private String totalAmt;

    private String repayAmt;

    private String repayInterest;

    private String state;

    private String lastRepayDay;

    private String balance;

    private String days;

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

    public Integer getAgentInfoId() {
        return agentInfoId;
    }

    public void setAgentInfoId(Integer agentInfoId) {
        this.agentInfoId = agentInfoId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate == null ? null : dueDate.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getExtRate() {
        return extRate;
    }

    public void setExtRate(String extRate) {
        this.extRate = extRate == null ? null : extRate.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest == null ? null : interest.trim();
    }

    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt == null ? null : totalAmt.trim();
    }

    public String getRepayAmt() {
        return repayAmt;
    }

    public void setRepayAmt(String repayAmt) {
        this.repayAmt = repayAmt == null ? null : repayAmt.trim();
    }

    public String getRepayInterest() {
        return repayInterest;
    }

    public void setRepayInterest(String repayInterest) {
        this.repayInterest = repayInterest == null ? null : repayInterest.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getLastRepayDay() {
        return lastRepayDay;
    }

    public void setLastRepayDay(String lastRepayDay) {
        this.lastRepayDay = lastRepayDay == null ? null : lastRepayDay.trim();
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance == null ? null : balance.trim();
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days == null ? null : days.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}