package rxt.bsb.api.dto.response.query;

import java.io.Serializable;

/**
 * 3.4.2 还款计划详情查询（实时模式） 应答报文
 * Created by ChenLiXin on 2019/9/18 0018 15:46
 */
public class PaymentInformationResDto implements Serializable {

    private String FinsncApplyNo;//融资申请编号
    private String ApplyDate;//融资申请日期
    private String CustName;//融资申请人
    private String LoanAcctNo;//贷款账号
    private String ApplyFinancAmt;//放款金额
    private String LoanBegDate;//贷款发放日
    private String ExtRate;//执行利率
    private String RepayType;//还款方式
    private String DueDay;//还款日
    private String Balance;//贷款余额
    private String TotalRepayTerms;//总期数

    public String getFinsncApplyNo() {
        return FinsncApplyNo;
    }

    public void setFinsncApplyNo(String finsncApplyNo) {
        FinsncApplyNo = finsncApplyNo;
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

    public String getLoanAcctNo() {
        return LoanAcctNo;
    }

    public void setLoanAcctNo(String loanAcctNo) {
        LoanAcctNo = loanAcctNo;
    }

    public String getApplyFinancAmt() {
        return ApplyFinancAmt;
    }

    public void setApplyFinancAmt(String applyFinancAmt) {
        ApplyFinancAmt = applyFinancAmt;
    }

    public String getLoanBegDate() {
        return LoanBegDate;
    }

    public void setLoanBegDate(String loanBegDate) {
        LoanBegDate = loanBegDate;
    }

    public String getExtRate() {
        return ExtRate;
    }

    public void setExtRate(String extRate) {
        ExtRate = extRate;
    }

    public String getRepayType() {
        return RepayType;
    }

    public void setRepayType(String repayType) {
        RepayType = repayType;
    }

    public String getDueDay() {
        return DueDay;
    }

    public void setDueDay(String dueDay) {
        DueDay = dueDay;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    public String getTotalRepayTerms() {
        return TotalRepayTerms;
    }

    public void setTotalRepayTerms(String totalRepayTerms) {
        TotalRepayTerms = totalRepayTerms;
    }
}
