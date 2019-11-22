package rxt.bsb.api.dto.response.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 授信申请应答报文
 * Created by ChenLiXin on 2019/9/17 0017 17:48
 */
public class CreditApplyResDto implements Serializable {

    private String  ApplyNo ;//授信申请编号

    private String  CustNo ;//渠平台会员号

    @JSONField(name="ApplyNo")
    public String getApplyNo() {
        return ApplyNo;
    }

    public void setApplyNo(String applyNo) {
        ApplyNo = applyNo;
    }

    @JSONField(name="CustNo")
    public String getCustNo() {
        return CustNo;
    }

    public void setCustNo(String custNo) {
        CustNo = custNo;
    }
}
