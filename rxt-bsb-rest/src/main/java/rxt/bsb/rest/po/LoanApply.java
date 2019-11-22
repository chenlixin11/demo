package rxt.bsb.rest.po;

import java.util.Date;

public class LoanApply {
    private Integer id;

    private Integer agentInfoId;

    private String dwmAplyNo;

    private String crgAplyNp;

    private String loanAmt;

    private String ccy;

    private Integer loanTrm;

    private String loanTrmUnit;

    private String pyMd;

    private String repyDy;

    private Integer repyItrv;

    private String repyCyc;

    private String rpMd;

    private String modeNumber;

    private String accNo;

    private String repaymentAccount;

    private String applyStatus;

    private String handleStatus;

    private String failReason;

    private String debtNo;

    private String contractPath;

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

    public String getDwmAplyNo() {
        return dwmAplyNo;
    }

    public void setDwmAplyNo(String dwmAplyNo) {
        this.dwmAplyNo = dwmAplyNo == null ? null : dwmAplyNo.trim();
    }

    public String getCrgAplyNp() {
        return crgAplyNp;
    }

    public void setCrgAplyNp(String crgAplyNp) {
        this.crgAplyNp = crgAplyNp == null ? null : crgAplyNp.trim();
    }

    public String getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(String loanAmt) {
        this.loanAmt = loanAmt == null ? null : loanAmt.trim();
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy == null ? null : ccy.trim();
    }

    public Integer getLoanTrm() {
        return loanTrm;
    }

    public void setLoanTrm(Integer loanTrm) {
        this.loanTrm = loanTrm;
    }

    public String getLoanTrmUnit() {
        return loanTrmUnit;
    }

    public void setLoanTrmUnit(String loanTrmUnit) {
        this.loanTrmUnit = loanTrmUnit == null ? null : loanTrmUnit.trim();
    }

    public String getPyMd() {
        return pyMd;
    }

    public void setPyMd(String pyMd) {
        this.pyMd = pyMd == null ? null : pyMd.trim();
    }

    public String getRepyDy() {
        return repyDy;
    }

    public void setRepyDy(String repyDy) {
        this.repyDy = repyDy == null ? null : repyDy.trim();
    }

    public Integer getRepyItrv() {
        return repyItrv;
    }

    public void setRepyItrv(Integer repyItrv) {
        this.repyItrv = repyItrv;
    }

    public String getRepyCyc() {
        return repyCyc;
    }

    public void setRepyCyc(String repyCyc) {
        this.repyCyc = repyCyc == null ? null : repyCyc.trim();
    }

    public String getRpMd() {
        return rpMd;
    }

    public void setRpMd(String rpMd) {
        this.rpMd = rpMd == null ? null : rpMd.trim();
    }

    public String getModeNumber() {
        return modeNumber;
    }

    public void setModeNumber(String modeNumber) {
        this.modeNumber = modeNumber == null ? null : modeNumber.trim();
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo == null ? null : accNo.trim();
    }

    public String getRepaymentAccount() {
        return repaymentAccount;
    }

    public void setRepaymentAccount(String repaymentAccount) {
        this.repaymentAccount = repaymentAccount == null ? null : repaymentAccount.trim();
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }

    public String getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus == null ? null : handleStatus.trim();
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    public String getDebtNo() {
        return debtNo;
    }

    public void setDebtNo(String debtNo) {
        this.debtNo = debtNo == null ? null : debtNo.trim();
    }

    public String getContractPath() {
        return contractPath;
    }

    public void setContractPath(String contractPath) {
        this.contractPath = contractPath == null ? null : contractPath.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}