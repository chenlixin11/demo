package rxt.bsb.rest.po;

import java.util.Date;

public class MerchantAcctBind {
    private Integer id;

    private Integer merchantAcctId;

    private String merCode;

    private String subAcctNo;

    private String acctNo;

    private String acctName;

    private String bankNo;

    private String bankName;

    private String isBaoshang;

    private String bindStatus;

    private String isCertified;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantAcctId() {
        return merchantAcctId;
    }

    public void setMerchantAcctId(Integer merchantAcctId) {
        this.merchantAcctId = merchantAcctId;
    }

    public String getMerCode() {
        return merCode;
    }

    public void setMerCode(String merCode) {
        this.merCode = merCode == null ? null : merCode.trim();
    }

    public String getSubAcctNo() {
        return subAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo == null ? null : subAcctNo.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}