package rxt.bsb.api.dto.request.query;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 3.4.5. 合同协议详情查询（实时模式） 请求报文
 * Created by ChenLiXin on 2019/9/19 0019 14:33
 */
public class ContractAgreementDetailReqDto implements Serializable {

    @JsonProperty(value = "ContractNo")
    @NotBlank(message = "合同编号不能空")
    @Size(max = 32,message = "合同编号长度不超过{max}位")
    private String  ContractNo;//合同编号

    @JSONField(name = "ContractNo")
    public String getContractNo() {
        return ContractNo;
    }

    public void setContractNo(String contractNo) {
        ContractNo = contractNo;
    }
}
