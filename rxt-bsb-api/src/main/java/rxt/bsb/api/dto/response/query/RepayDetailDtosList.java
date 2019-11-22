package rxt.bsb.api.dto.response.query;

import java.io.Serializable;

/**
 * Created by ChenLiXin on 2019/9/18 0018 15:57
 */
public class RepayDetailDtosList implements Serializable {

    private String DueDate;//到期日期
    private String Period;//期数
    private String ExtRate;//执行利率
    private String Amount;//应还本金
    private String Interest;//应还利息
    private String TotalAmt;//应还本金利息合计
    private String RepayAmt;//已还本金
    private String RepayInterest;//已还利息
    private String State;//状态
    private String LastRepayDay;//上次还款日期
    private String Balance;//本期余额
    private String Days;//结息天数

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getExtRate() {
        return ExtRate;
    }

    public void setExtRate(String extRate) {
        ExtRate = extRate;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getInterest() {
        return Interest;
    }

    public void setInterest(String interest) {
        Interest = interest;
    }

    public String getTotalAmt() {
        return TotalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        TotalAmt = totalAmt;
    }

    public String getRepayAmt() {
        return RepayAmt;
    }

    public void setRepayAmt(String repayAmt) {
        RepayAmt = repayAmt;
    }

    public String getRepayInterest() {
        return RepayInterest;
    }

    public void setRepayInterest(String repayInterest) {
        RepayInterest = repayInterest;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getLastRepayDay() {
        return LastRepayDay;
    }

    public void setLastRepayDay(String lastRepayDay) {
        LastRepayDay = lastRepayDay;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String days) {
        Days = days;
    }
}
