package rxt.bsb.rest.po;

import java.util.Date;

public class AgentAcctBind {
    private Integer id;

    private Integer agentAcctId;

    private String custNo;

    private String subacctNo;

    private String acctNo;

    private String acctName;

    private String bankNo;

    private String bankName;

    private String isBaoshang;

    private String bindStatus;

    private String isCertified;

    private Date bindTime;

    private Date certifiedTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgentAcctId() {
        return agentAcctId;
    }

    public void setAgentAcctId(Integer agentAcctId) {
        this.agentAcctId = agentAcctId;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    public String getSubacctNo() {
        return subacctNo;
    }

    public void setSubacctNo(String subacctNo) {
        this.subacctNo = subacctNo == null ? null : subacctNo.trim();
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName == null ? null : acctName.trim();
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getIsBaoshang() {
        return isBaoshang;
    }

    public void setIsBaoshang(String isBaoshang) {
        this.isBaoshang = isBaoshang == null ? null : isBaoshang.trim();
    }

    public String getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(String bindStatus) {
        this.bindStatus = bindStatus == null ? null : bindStatus.trim();
    }

    public String getIsCertified() {
        return isCertified;
    }

    public void setIsCertified(String isCertified) {
        this.isCertified = isCertified == null ? null : isCertified.trim();
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public Date getCertifiedTime() {
        return certifiedTime;
    }

    public void setCertifiedTime(Date certifiedTime) {
        this.certifiedTime = certifiedTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}