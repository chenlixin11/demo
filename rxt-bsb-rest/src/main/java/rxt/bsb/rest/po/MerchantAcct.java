package rxt.bsb.rest.po;

import java.util.Date;

public class MerchantAcct {
    private Integer id;

    private Integer merchantInfoId;

    private String merCode;

    private String subAcctNo;

    private String subAcctName;

    private String subAcctType;

    private String bankNo;

    private String bankName;

    private String openDate;

    private String acctStatus;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantInfoId() {
        return merchantInfoId;
    }

    public void setMerchantInfoId(Integer merchantInfoId) {
        this.merchantInfoId = merchantInfoId;
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

    public String getSubAcctName() {
        return subAcctName;
    }

    public void setSubAcctName(String subAcctName) {
        this.subAcctName = subAcctName == null ? null : subAcctName.trim();
    }

    public String getSubAcctType() {
        return subAcctType;
    }

    public void setSubAcctType(String subAcctType) {
        this.subAcctType = subAcctType == null ? null : subAcctType.trim();
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

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate == null ? null : openDate.trim();
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus == null ? null : acctStatus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}