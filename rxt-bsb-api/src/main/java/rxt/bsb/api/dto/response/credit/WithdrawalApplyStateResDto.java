package rxt.bsb.api.dto.response.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 提款申请状态查询应答（实时模式）
 * Created by ChenLiXin on 2019/9/18 0018 10:22
 */
public class WithdrawalApplyStateResDto implements Serializable {

    private String  ApplyStat;  //申请状态

    private String  DealStat;  //处理状态

    @JSONField(name = "ApplyStat")
    public String getApplyStat() {
        return ApplyStat;
    }

    public void setApplyStat(String applyStat) {
        ApplyStat = applyStat;
    }

    @JSONField(name = "DealStat")
    public String getDealStat() {
        return DealStat;
    }

    public void setDealStat(String dealStat) {
        DealStat = dealStat;
    }
}
