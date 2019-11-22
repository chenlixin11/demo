package rxt.bsb.rest.po;

import java.util.Date;

public class ProjectInfo {
    private Integer id;

    private Integer merchantInfoId;

    private String merCode;

    private String projNo;

    private String projName;

    private String projAmt;

    private Integer projAmtDeadline;

    private String projAmtEffdate;

    private String projAmtDuedate;

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

    public String getProjNo() {
        return projNo;
    }

    public void setProjNo(String projNo) {
        this.projNo = projNo == null ? null : projNo.trim();
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName == null ? null : projName.trim();
    }

    public String getProjAmt() {
        return projAmt;
    }

    public void setProjAmt(String projAmt) {
        this.projAmt = projAmt == null ? null : projAmt.trim();
    }

    public Integer getProjAmtDeadline() {
        return projAmtDeadline;
    }

    public void setProjAmtDeadline(Integer projAmtDeadline) {
        this.projAmtDeadline = projAmtDeadline;
    }

    public String getProjAmtEffdate() {
        return projAmtEffdate;
    }

    public void setProjAmtEffdate(String projAmtEffdate) {
        this.projAmtEffdate = projAmtEffdate == null ? null : projAmtEffdate.trim();
    }

    public String getProjAmtDuedate() {
        return projAmtDuedate;
    }

    public void setProjAmtDuedate(String projAmtDuedate) {
        this.projAmtDuedate = projAmtDuedate == null ? null : projAmtDuedate.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}