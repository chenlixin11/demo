package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 商户交易流水对账
 * 商户资金账户余额对账
 * 商户资金账户明细对账
 */
public class BusinessTransactionReqDto implements Serializable {

    @Size(max = 8,message = "对帐日期长度不能超过{max}位")
    @NotBlank(message = "对账日期不能空")
    private String CheckDate;

    @JSONField(name = "CheckDate")
    public String getCheckDate() {
        return CheckDate;
    }

    public void setCheckDate(String checkDate) {
        CheckDate = checkDate;
    }
}
