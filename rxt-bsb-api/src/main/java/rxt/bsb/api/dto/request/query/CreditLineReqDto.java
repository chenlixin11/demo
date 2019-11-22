package rxt.bsb.api.dto.request.query;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 3.4.6. 授信额度查询（实时模式） 请求报文
 * Created by ChenLiXin on 2019/9/19 0019 14:36
 */
public class CreditLineReqDto implements Serializable {

    @NotBlank(message = "授信申请编号不能空")
    @Size(max = 32,message = "授信申请编号长度不超过{max}位")
    private String  PlatApplyNo;//授信申请编号

    @JSONField(name = "PlatApplyNo")
    public String getPlatApplyNo() {
        return PlatApplyNo;
    }

    public void setPlatApplyNo(String platApplyNo) {
        PlatApplyNo = platApplyNo;
    }
}
