package rxt.bsb.api.dto.response.query;

import java.io.Serializable;

/**
 * Created by ChenLiXin on 2019/9/18 0018 15:32
 */
public class ListScfLoanInfoDosDto implements Serializable {

    private String  FinsncApplyNo;//融资申请编号 提款申请时的提款申请编号
    private String  Stat ;//操作状态
    private String  ApplyDate;//申请日期 格式：yyyyMMdd
    private String  CustName;//融资客户
    private String  LoanAcct;//贷款账号
    private String  LoanAmt;//放款金额
    private String  LoanBegDate;//贷款发放日 格式：yyyyMMdd
    private String  LoanEndDte;//贷款到期日 格式：yyyyMMdd
    private String  DueDay;//扣款日（每月）

    public String getFinsncApplyNo() {
        return FinsncApplyNo;
    }

    public void setFinsncApplyNo(String finsncApplyNo) {
        FinsncApplyNo = finsncApplyNo;
    }

    public String getStat() {
        return Stat;
    }

    public void setStat(String stat) {
        Stat = stat;
    }

    public String getApplyDate() {
        return ApplyDate;
    }

    public void setApplyDate(String applyDate) {
        ApplyDate = applyDate;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public String getLoanAcct() {
        return LoanAcct;
    }

    public void setLoanAcct(String loanAcct) {
        LoanAcct = loanAcct;
    }

    public String getLoanAmt() {
        return LoanAmt;
    }

    public void setLoanAmt(String loanAmt) {
        LoanAmt = loanAmt;
    }

    public String getLoanBegDate() {
        return LoanBegDate;
    }

    public void setLoanBegDate(String loanBegDate) {
        LoanBegDate = loanBegDate;
    }

    public String getLoanEndDte() {
        return LoanEndDte;
    }

    public void setLoanEndDte(String loanEndDte) {
        LoanEndDte = loanEndDte;
    }

    public String getDueDay() {
        return DueDay;
    }

    public void setDueDay(String dueDay) {
        DueDay = dueDay;
    }
}
