package rxt.bsb.api.dto.request.notice;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 4.3 合同签署 请求报文
 * Created by ChenLiXin on 2019/9/18 0018 19:09
 */
public class ContractSignReqDto implements Serializable {

    @NotBlank(message = "商户页面回调 URL不能空")
    @Size(max=512,message = "商户页面回调 URL长度不超过{max}位")
    private String RebackURL;//商户页面回调 URL

    @NotBlank(message = "商户通知回调 URL不能空")
    @Size(max=512,message = "商户通知回调 URL长度不超过{max}位")
    private String NotifyURL;//商户通知回调 URL

    @NotBlank(message = "资金账号不能空")
    @Size(max=32,message = "资金账号长度不超过{max}位")
    private String SubAcctNo;//资金账号

    @NotBlank(message = "合同编号不能空")
    @Size(max=64,message = "合同编号长度不超过{max}位")
    private String ContractNo;//合同编号

    @JSONField(name = "RebackURL")
    public String getRebackURL() {
        return RebackURL;
    }

    public void setRebackURL(String rebackURL) {
        RebackURL = rebackURL;
    }

    @JSONField(name = "NotifyURL")
    public String getNotifyURL() {
        return NotifyURL;
    }

    public void setNotifyURL(String notifyURL) {
        NotifyURL = notifyURL;
    }

    @JSONField(name = "SubAcctNo")
    public String getSubAcctNo() {
        return SubAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        SubAcctNo = subAcctNo;
    }

    @JSONField(name = "ContractNo")
    public String getContractNo() {
        return ContractNo;
    }

    public void setContractNo(String contractNo) {
        ContractNo = contractNo;
    }
}
