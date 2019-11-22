package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 个人会员支付认证（网关模式） 请求报文
 * Created by ChenLiXin on 2019/9/25 0025 11:08
 */
public class PersonPayAuthenticationReqDto implements Serializable {

    @NotBlank(message = "资金账号不能空")
    @Size(max = 32, message = "资金账号长度不能超过{max}位")
    private String SubAcctNo;//资金账号

    @NotBlank(message = "认证卡号不能空")
    @Size(max = 32, message = "认证卡号长度不能超过{max}位")
    private String BindAcctNo;//认证卡号

    @JSONField(name = "SubAcctNo")
    public String getSubAcctNo() {
        return SubAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        SubAcctNo = subAcctNo;
    }
    @JSONField(name = "BindAcctNo")
    public String getBindAcctNo() {
        return BindAcctNo;
    }

    public void setBindAcctNo(String bindAcctNo) {
        BindAcctNo = bindAcctNo;
    }
}
