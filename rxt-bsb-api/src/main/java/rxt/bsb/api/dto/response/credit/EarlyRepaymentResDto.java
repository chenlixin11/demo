package rxt.bsb.api.dto.response.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 提前还款（实时模式）应答报文
 * Created by ChenLiXin on 2019/9/18 0018 10:50
 */
public class EarlyRepaymentResDto implements Serializable {

    private String  RepayAccrual; //利息 计算出的利息

    private String RepayPrinAmt; //总额 利息+本金总额

    private String  Amount; //当期应还本金

    private String   CurrentInterest; //当期应还利息

    private String   OverdueAmt ; //逾期应还本金

    private String   OverdueInterest ; //逾期应还利息

    private String  OverdueTotal; //逾期应还总罚息

    @JSONField(name = "RepayAccrual")
    public String getRepayAccrual() {
        return RepayAccrual;
    }

    public void setRepayAccrual(String repayAccrual) {
        RepayAccrual = repayAccrual;
    }

    @JSONField(name = "RepayPrinAmt")
    public String getRepayPrinAmt() {
        return RepayPrinAmt;
    }

    public void setRepayPrinAmt(String repayPrinAmt) {
        RepayPrinAmt = repayPrinAmt;
    }

    @JSONField(name = "Amount")
    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    @JSONField(name = "CurrentInterest")
    public String getCurrentInterest() {
        return CurrentInterest;
    }

    public void setCurrentInterest(String currentInterest) {
        CurrentInterest = currentInterest;
    }

    @JSONField(name = "OverdueAmt")
    public String getOverdueAmt() {
        return OverdueAmt;
    }

    public void setOverdueAmt(String overdueAmt) {
        OverdueAmt = overdueAmt;
    }

    @JSONField(name = "OverdueInterest")
    public String getOverdueInterest() {
        return OverdueInterest;
    }

    public void setOverdueInterest(String overdueInterest) {
        OverdueInterest = overdueInterest;
    }

    @JSONField(name = "OverdueTotal")
    public String getOverdueTotal() {
        return OverdueTotal;
    }

    public void setOverdueTotal(String overdueTotal) {
        OverdueTotal = overdueTotal;
    }
}
