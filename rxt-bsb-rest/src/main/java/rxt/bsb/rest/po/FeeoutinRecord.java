package rxt.bsb.rest.po;

import java.math.BigDecimal;
import java.util.Date;

public class FeeoutinRecord {
    private Integer id;

    private Integer agentInfoId;

    private String transNo;

    private Date transTime;

    private String subacctNo;

    private String clearAcctNo;

    private BigDecimal transAmount;

    private Integer type;

    private Integer status;

    private String failReason;

    private Integer isBaoshang;

    private Integer spanOutStatus;

    private BigDecimal spanFee;

    private BigDecimal agentFee;

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

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo == null ? null : transNo.trim();
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public String getSubacctNo() {
        return subacctNo;
    }

    public void setSubacctNo(String subacctNo) {
        this.subacctNo = subacctNo == null ? null : subacctNo.trim();
    }

    public String getClearAcctNo() {
        return clearAcctNo;
    }

    public void setClearAcctNo(String clearAcctNo) {
        this.clearAcctNo = clearAcctNo == null ? null : clearAcctNo.trim();
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    public Integer getIsBaoshang() {
        return isBaoshang;
    }

    public void setIsBaoshang(Integer isBaoshang) {
        this.isBaoshang = isBaoshang;
    }

    public Integer getSpanOutStatus() {
        return spanOutStatus;
    }

    public void setSpanOutStatus(Integer spanOutStatus) {
        this.spanOutStatus = spanOutStatus;
    }

    public BigDecimal getSpanFee() {
        return spanFee;
    }

    public void setSpanFee(BigDecimal spanFee) {
        this.spanFee = spanFee;
    }

    public BigDecimal getAgentFee() {
        return agentFee;
    }

    public void setAgentFee(BigDecimal agentFee) {
        this.agentFee = agentFee;
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