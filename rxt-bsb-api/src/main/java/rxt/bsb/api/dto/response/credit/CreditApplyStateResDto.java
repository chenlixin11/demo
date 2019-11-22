package rxt.bsb.api.dto.response.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 授信申请状态查询应答（实时模式）
 * Created by ChenLiXin on 2019/9/17 0017 21:26
 */
public class CreditApplyStateResDto implements Serializable {

    private String  ApplyNo; //申请编号

    private String ApplyStat;  //申请状态

    private String  FailMsg ;  //失败原因

    @JSONField(name = "ApplyNo")
    public String getApplyNo() {
        return ApplyNo;
    }

    public void setApplyNo(String applyNo) {
        ApplyNo = applyNo;
    }

    @JSONField(name = "ApplyStat")
    public String getApplyStat() {
        return ApplyStat;
    }

    public void setApplyStat(String applyStat) {
        ApplyStat = applyStat;
    }

    @JSONField(name = "FailMsg")
    public String getFailMsg() {
        return FailMsg;
    }

    public void setFailMsg(String failMsg) {
        FailMsg = failMsg;
    }
}
