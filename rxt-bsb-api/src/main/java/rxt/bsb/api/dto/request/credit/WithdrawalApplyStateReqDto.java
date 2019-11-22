package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 3.1.4提款申请状态查询请求（实时模式） 请求报文
 * Created by ChenLiXin on 2019/9/18 0018 10:19
 */
public class WithdrawalApplyStateReqDto implements Serializable {

    @NotBlank(message = "提款申请编号不能空")
    @Size(max = 32,message = "提款申请编号长度不超过{max}位")
    private String  ApplyNo;//提款申请编号

    @JSONField(name = "ApplyNo")
    public String getApplyNo() {
        return ApplyNo;
    }

    public void setApplyNo(String applyNo) {
        ApplyNo = applyNo;
    }
}
