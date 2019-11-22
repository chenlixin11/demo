package rxt.bsb.rest.po;

import java.util.Date;

public class MerchantInfo {
    private Integer id;

    private String merCode;

    private String merName;

    private String merAcctNo;

    private String custCode;

    private String merCurrCode;

    private String chanCode;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMerCode() {
        return merCode;
    }

    public void setMerCode(String merCode) {
        this.merCode = merCode == null ? null : merCode.trim();
    }

    public String getMerName() {
        return merName;
    }

    public void setMerName(String merName) {
        this.merName = merName == null ? null : merName.trim();
    }

    public String getMerAcctNo() {
        return merAcctNo;
    }

    public void setMerAcctNo(String merAcctNo) {
        this.merAcctNo = merAcctNo == null ? null : merAcctNo.trim();
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode == null ? null : custCode.trim();
    }

    public String getMerCurrCode() {
        return merCurrCode;
    }

    public void setMerCurrCode(String merCurrCode) {
        this.merCurrCode = merCurrCode == null ? null : merCurrCode.trim();
    }

    public String getChanCode() {
        return chanCode;
    }

    public void setChanCode(String chanCode) {
        this.chanCode = chanCode == null ? null : chanCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}