package rxt.bsb.rest.po;

import java.math.BigDecimal;
import java.util.Date;

public class StatLoanBalanceMonth {
    private Integer id;

    private Integer agentInfoId;

    private String yearMonth;

    private BigDecimal monthBalance;

    private BigDecimal eachdayBalance;

    private Integer feeSide;

    private Integer loanDeductWay;

    private Integer calcRateMode;

    private String rate;

    private String platRate;

    private BigDecimal platFee;

    private Integer interestCollectionManner;

    private Integer isCharged;

    private Date deductFinishTime;

    private Integer platFeeOutFlag;

    private Date platFeeOutTime;

    private BigDecimal platCumulativeChargeAmount;

    private BigDecimal platCumulativeFeeoutAmount;

    private String merRate;

    private BigDecimal merFee;

    private Integer isMerCharged;

    private Date merDeductFinishTime;

    private Integer merFeeOutFlag;

    private Date merFeeOutTime;

    private String loanAcctcode;

    private Integer custFeeInStatus;

    private BigDecimal custFeeInSumamount;

    private Date custFeeInTime;

    private Integer merFeeInStatus;

    private BigDecimal merFeeInSumamount;

    private Date merFeeInTime;

    private Integer generation;

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

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth == null ? null : yearMonth.trim();
    }

    public BigDecimal getMonthBalance() {
        return monthBalance;
    }

    public void setMonthBalance(BigDecimal monthBalance) {
        this.monthBalance = monthBalance;
    }

    public BigDecimal getEachdayBalance() {
        return eachdayBalance;
    }

    public void setEachdayBalance(BigDecimal eachdayBalance) {
        this.eachdayBalance = eachdayBalance;
    }

    public Integer getFeeSide() {
        return feeSide;
    }

    public void setFeeSide(Integer feeSide) {
        this.feeSide = feeSide;
    }

    public Integer getLoanDeductWay() {
        return loanDeductWay;
    }

    public void setLoanDeductWay(Integer loanDeductWay) {
        this.loanDeductWay = loanDeductWay;
    }

    public Integer getCalcRateMode() {
        return calcRateMode;
    }

    public void setCalcRateMode(Integer calcRateMode) {
        this.calcRateMode = calcRateMode;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    public String getPlatRate() {
        return platRate;
    }

    public void setPlatRate(String platRate) {
        this.platRate = platRate == null ? null : platRate.trim();
    }

    public BigDecimal getPlatFee() {
        return platFee;
    }

    public void setPlatFee(BigDecimal platFee) {
        this.platFee = platFee;
    }

    public Integer getInterestCollectionManner() {
        return interestCollectionManner;
    }

    public void setInterestCollectionManner(Integer interestCollectionManner) {
        this.interestCollectionManner = interestCollectionManner;
    }

    public Integer getIsCharged() {
        return isCharged;
    }

    public void setIsCharged(Integer isCharged) {
        this.isCharged = isCharged;
    }

    public Date getDeductFinishTime() {
        return deductFinishTime;
    }

    public void setDeductFinishTime(Date deductFinishTime) {
        this.deductFinishTime = deductFinishTime;
    }

    public Integer getPlatFeeOutFlag() {
        return platFeeOutFlag;
    }

    public void setPlatFeeOutFlag(Integer platFeeOutFlag) {
        this.platFeeOutFlag = platFeeOutFlag;
    }

    public Date getPlatFeeOutTime() {
        return platFeeOutTime;
    }

    public void setPlatFeeOutTime(Date platFeeOutTime) {
        this.platFeeOutTime = platFeeOutTime;
    }

    public BigDecimal getPlatCumulativeChargeAmount() {
        return platCumulativeChargeAmount;
    }

    public void setPlatCumulativeChargeAmount(BigDecimal platCumulativeChargeAmount) {
        this.platCumulativeChargeAmount = platCumulativeChargeAmount;
    }

    public BigDecimal getPlatCumulativeFeeoutAmount() {
        return platCumulativeFeeoutAmount;
    }

    public void setPlatCumulativeFeeoutAmount(BigDecimal platCumulativeFeeoutAmount) {
        this.platCumulativeFeeoutAmount = platCumulativeFeeoutAmount;
    }

    public String getMerRate() {
        return merRate;
    }

    public void setMerRate(String merRate) {
        this.merRate = merRate == null ? null : merRate.trim();
    }

    public BigDecimal getMerFee() {
        return merFee;
    }

    public void setMerFee(BigDecimal merFee) {
        this.merFee = merFee;
    }

    public Integer getIsMerCharged() {
        return isMerCharged;
    }

    public void setIsMerCharged(Integer isMerCharged) {
        this.isMerCharged = isMerCharged;
    }

    public Date getMerDeductFinishTime() {
        return merDeductFinishTime;
    }

    public void setMerDeductFinishTime(Date merDeductFinishTime) {
        this.merDeductFinishTime = merDeductFinishTime;
    }

    public Integer getMerFeeOutFlag() {
        return merFeeOutFlag;
    }

    public void setMerFeeOutFlag(Integer merFeeOutFlag) {
        this.merFeeOutFlag = merFeeOutFlag;
    }

    public Date getMerFeeOutTime() {
        return merFeeOutTime;
    }

    public void setMerFeeOutTime(Date merFeeOutTime) {
        this.merFeeOutTime = merFeeOutTime;
    }

    public String getLoanAcctcode() {
        return loanAcctcode;
    }

    public void setLoanAcctcode(String loanAcctcode) {
        this.loanAcctcode = loanAcctcode == null ? null : loanAcctcode.trim();
    }

    public Integer getCustFeeInStatus() {
        return custFeeInStatus;
    }

    public void setCustFeeInStatus(Integer custFeeInStatus) {
        this.custFeeInStatus = custFeeInStatus;
    }

    public BigDecimal getCustFeeInSumamount() {
        return custFeeInSumamount;
    }

    public void setCustFeeInSumamount(BigDecimal custFeeInSumamount) {
        this.custFeeInSumamount = custFeeInSumamount;
    }

    public Date getCustFeeInTime() {
        return custFeeInTime;
    }

    public void setCustFeeInTime(Date custFeeInTime) {
        this.custFeeInTime = custFeeInTime;
    }

    public Integer getMerFeeInStatus() {
        return merFeeInStatus;
    }

    public void setMerFeeInStatus(Integer merFeeInStatus) {
        this.merFeeInStatus = merFeeInStatus;
    }

    public BigDecimal getMerFeeInSumamount() {
        return merFeeInSumamount;
    }

    public void setMerFeeInSumamount(BigDecimal merFeeInSumamount) {
        this.merFeeInSumamount = merFeeInSumamount;
    }

    public Date getMerFeeInTime() {
        return merFeeInTime;
    }

    public void setMerFeeInTime(Date merFeeInTime) {
        this.merFeeInTime = merFeeInTime;
    }

    public Integer getGeneration() {
        return generation;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
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