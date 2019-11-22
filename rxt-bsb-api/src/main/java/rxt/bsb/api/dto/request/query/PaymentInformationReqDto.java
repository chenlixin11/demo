package rxt.bsb.api.dto.request.query;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 3.4.2 还款计划详情查询（实时模式） 请求报文
 * Created by ChenLiXin on 2019/9/18 0018 15:43
 */
public class PaymentInformationReqDto implements Serializable {

    @NotBlank(message = "融资申请编号不能空")
    @Size(max = 32,message = "融资申请编号长度不超过{max}位")
    private String  FinancApplyNo; //融资申请编号 提款申请时的提款申请编号

    @JSONField(name = "FinancApplyNo")
    public String getFinancApplyNo() {
        return FinancApplyNo;
    }

    public void setFinancApplyNo(String financApplyNo) {
        FinancApplyNo = financApplyNo;
    }
}
