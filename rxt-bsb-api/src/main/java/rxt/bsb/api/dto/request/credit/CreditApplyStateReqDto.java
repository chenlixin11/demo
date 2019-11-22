package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 3.1.2授信申请状态查询请求报文（实时模式）
 * Created by ChenLiXin on 2019/9/17 0017 21:24
 */
public class CreditApplyStateReqDto implements Serializable {

    @NotBlank(message="申请编号不能空")
    @Size(max=32,message="申请编号长度不能超过{max}位")
    private String ApplyNo ;//申请编号

    @JSONField(name = "ApplyNo")
    public String getApplyNo() {
        return ApplyNo;
    }

    public void setApplyNo(String applyNo) {
        ApplyNo = applyNo;
    }
}
