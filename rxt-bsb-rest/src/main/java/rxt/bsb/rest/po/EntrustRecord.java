package rxt.bsb.rest.po;

import java.math.BigDecimal;
import java.util.Date;

public class EntrustRecord {
    private Integer id;

    private Integer agentInfoId;

    private Integer loanApplyId;

    private Integer entrustAccountId;

    private BigDecimal entrustAmt;

    private BigDecimal entrustFee;

    private String remarks;

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

    public Integer getLoanApplyId() {
        return loanApplyId;
    }

    public void setLoanApplyId(Integer loanApplyId) {
        this.loanApplyId = loanApplyId;
    }

    public Integer getEntrustAccountId() {
        return entrustAccountId;
    }

    public void setEntrustAccountId(Integer entrustAccountId) {
        this.entrustAccountId = entrustAccountId;
    }

    public BigDecimal getEntrustAmt() {
        return entrustAmt;
    }

    public void setEntrustAmt(BigDecimal entrustAmt) {
        this.entrustAmt = entrustAmt;
    }

    public BigDecimal getEntrustFee() {
        return entrustFee;
    }

    public void setEntrustFee(BigDecimal entrustFee) {
        this.entrustFee = entrustFee;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}