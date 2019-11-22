package rxt.bsb.rest.po;

import java.math.BigDecimal;
import java.util.Date;

public class OrderPayDetail {
    private Integer id;

    private Integer orderPayId;

    private Integer orderInfoId;

    private String orderNo;

    private BigDecimal payAmount;

    private BigDecimal ownAmount;

    private BigDecimal loanAmount;

    private String receiverAcct;

    private String receiverAcctName;

    private Integer isOtherBank;

    private BigDecimal spanBankPayFee;

    private Integer orderPayStatus;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderPayId() {
        return orderPayId;
    }

    public void setOrderPayId(Integer orderPayId) {
        this.orderPayId = orderPayId;
    }

    public Integer getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Integer orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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

    public String getReceiverAcct() {
        return receiverAcct;
    }

    public void setReceiverAcct(String receiverAcct) {
        this.receiverAcct = receiverAcct == null ? null : receiverAcct.trim();
    }

    public String getReceiverAcctName() {
        return receiverAcctName;
    }

    public void setReceiverAcctName(String receiverAcctName) {
        this.receiverAcctName = receiverAcctName == null ? null : receiverAcctName.trim();
    }

    public Integer getIsOtherBank() {
        return isOtherBank;
    }

    public void setIsOtherBank(Integer isOtherBank) {
        this.isOtherBank = isOtherBank;
    }

    public BigDecimal getSpanBankPayFee() {
        return spanBankPayFee;
    }

    public void setSpanBankPayFee(BigDecimal spanBankPayFee) {
        this.spanBankPayFee = spanBankPayFee;
    }

    public Integer getOrderPayStatus() {
        return orderPayStatus;
    }

    public void setOrderPayStatus(Integer orderPayStatus) {
        this.orderPayStatus = orderPayStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}