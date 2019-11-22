package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

//回单查询
public class BackOrderQueryReqDto implements Serializable {

    @Size(max = 32,message = "账号长度不超过{max}位")
    @NotBlank(message = "账号不能空")
    private String SubAcctNo;//账号

    @Size(max = 64,message = "商户请求流水号长度不超过{max}位")
    @NotBlank(message = "商户请求流水号不能空")
    private String SerialNo;//商户请求流水号

    @Size(max = 64,message = "商户请求子流水号长度不超过{max}位")
    @NotBlank(message = "商户请求子流水号不能空")
    private String SubSerialNo;//商户请求子流水号

    private String IsPath; //补打标志  Y补打 N非补打

    @JSONField(name = "SubAcctNo")
    public String getSubAcctNo() {
        return SubAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        SubAcctNo = subAcctNo;
    }

    @JSONField(name = "SerialNo")
    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String serialNo) {
        SerialNo = serialNo;
    }

    @JSONField(name = "SubSerialNo")
    public String getSubSerialNo() {
        return SubSerialNo;
    }

    public void setSubSerialNo(String subSerialNo) {
        SubSerialNo = subSerialNo;
    }

    @JSONField(name = "IsPath")
    public String getIsPath() {
        return IsPath;
    }

    public void setIsPath(String isPath) {
        IsPath = isPath;
    }
}
