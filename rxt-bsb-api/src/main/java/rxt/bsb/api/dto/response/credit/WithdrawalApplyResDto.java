package rxt.bsb.api.dto.response.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 提款申请（实时模式）应答报文
 * Created by ChenLiXin on 2019/9/18 0018 10:06
 */
public class WithdrawalApplyResDto implements Serializable {

    private String DebtNo;  //借据编号

    @JSONField(name = "DebtNo")
    public String getDebtNo() {
        return DebtNo;
    }

    public void setDebtNo(String debtNo) {
        DebtNo = debtNo;
    }
}
