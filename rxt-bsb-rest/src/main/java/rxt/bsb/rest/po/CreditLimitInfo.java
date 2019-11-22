package rxt.bsb.rest.po;

import java.util.Date;

public class CreditLimitInfo {
    private Integer id;

    private Integer agentInfoId;

    private String creditApplyNo;

    private String confirmFacility;

    private String avaiSum;

    private String effectDate;

    private String availableTerm;

    private String endDate;

    private String occSum;

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

    public String getCreditApplyNo() {
        return creditApplyNo;
    }

    public void setCreditApplyNo(String creditApplyNo) {
        this.creditApplyNo = creditApplyNo == null ? null : creditApplyNo.trim();
    }

    public String getConfirmFacility() {
        return confirmFacility;
    }

    public void setConfirmFacility(String confirmFacility) {
        this.confirmFacility = confirmFacility == null ? null : confirmFacility.trim();
    }

    public String getAvaiSum() {
        return avaiSum;
    }

    public void setAvaiSum(String avaiSum) {
        this.avaiSum = avaiSum == null ? null : avaiSum.trim();
    }

    public String getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(String effectDate) {
        this.effectDate = effectDate == null ? null : effectDate.trim();
    }

    public String getAvailableTerm() {
        return availableTerm;
    }

    public void setAvailableTerm(String availableTerm) {
        this.availableTerm = availableTerm == null ? null : availableTerm.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getOccSum() {
        return occSum;
    }

    public void setOccSum(String occSum) {
        this.occSum = occSum == null ? null : occSum.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}