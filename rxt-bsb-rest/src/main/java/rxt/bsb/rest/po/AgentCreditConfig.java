package rxt.bsb.rest.po;

import java.util.Date;

public class AgentCreditConfig {
    private Integer id;

    private Integer agentInfoId;

    private String custNo;

    private String isStopLoan;

    private Date stopLoanTime;

    private String stopLoanReason;

    private Date createTime;

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

    public String getIsStopLoan() {
        return isStopLoan;
    }

    public void setIsStopLoan(String isStopLoan) {
        this.isStopLoan = isStopLoan == null ? null : isStopLoan.trim();
    }

    public Date getStopLoanTime() {
        return stopLoanTime;
    }

    public void setStopLoanTime(Date stopLoanTime) {
        this.stopLoanTime = stopLoanTime;
    }

    public String getStopLoanReason() {
        return stopLoanReason;
    }

    public void setStopLoanReason(String stopLoanReason) {
        this.stopLoanReason = stopLoanReason == null ? null : stopLoanReason.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}