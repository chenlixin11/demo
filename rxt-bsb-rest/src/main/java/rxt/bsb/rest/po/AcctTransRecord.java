package rxt.bsb.rest.po;

import java.math.BigDecimal;
import java.util.Date;

public class AcctTransRecord {
    private Integer id;

    private Integer agentInfoId;

    private String transCode;

    private Integer transType;

    private BigDecimal transAmount;

    private String inAcctNo;

    private String inAcctName;

    private String outAcctNo;

    private String outAcctName;

    private Date transTime;

    private String bankTransType;

    private String bankTransNo;

    private Date transDate;

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

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode == null ? null : transCode.trim();
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getInAcctNo() {
        return inAcctNo;
    }

    public void setInAcctNo(String inAcctNo) {
        this.inAcctNo = inAcctNo == null ? null : inAcctNo.trim();
    }

    public String getInAcctName() {
        return inAcctName;
    }

    public void setInAcctName(String inAcctName) {
        this.inAcctName = inAcctName == null ? null : inAcctName.trim();
    }

    public String getOutAcctNo() {
        return outAcctNo;
    }

    public void setOutAcctNo(String outAcctNo) {
        this.outAcctNo = outAcctNo == null ? null : outAcctNo.trim();
    }

    public String getOutAcctName() {
        return outAcctName;
    }

    public void setOutAcctName(String outAcctName) {
        this.outAcctName = outAcctName == null ? null : outAcctName.trim();
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public String getBankTransType() {
        return bankTransType;
    }

    public void setBankTransType(String bankTransType) {
        this.bankTransType = bankTransType == null ? null : bankTransType.trim();
    }

    public String getBankTransNo() {
        return bankTransNo;
    }

    public void setBankTransNo(String bankTransNo) {
        this.bankTransNo = bankTransNo == null ? null : bankTransNo.trim();
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
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