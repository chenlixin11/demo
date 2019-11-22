package rxt.bsb.rest.po;

import java.math.BigDecimal;
import java.util.Date;

public class OrderPay {
    private Integer id;

    private Integer agentInfoId;

    private BigDecimal payAmount;

    private BigDecimal ownAmount;

    private BigDecimal loanAmount;

    private BigDecimal spanBankPayFee;

    private Date payTime;

    private Integer detailCount;

    private Integer intoAcctCount;

    private Integer status;

    private Integer receiveType;

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

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getOwnAmount() {
        return ownAmount;
    }

    public void setOwnAmount(BigDecimal ownAmount) {
        this.ownAmount = ownAmount;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getSpanBankPayFee() {
        return spanBankPayFee;
    }

    public void setSpanBankPayFee(BigDecimal spanBankPayFee) {
        this.spanBankPayFee = spanBankPayFee;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getDetailCount() {
        return detailCount;
    }

    public void setDetailCount(Integer detailCount) {
        this.detailCount = detailCount;
    }

    public Integer getIntoAcctCount() {
        return intoAcctCount;
    }

    public void setIntoAcctCount(Integer intoAcctCount) {
        this.intoAcctCount = intoAcctCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReceiveType() {
        return receiveType;
    }

    public void setReceiveType(Integer receiveType) {
        this.receiveType = receiveType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}