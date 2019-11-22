package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by ChenLiXin on 2019/9/17 0017 20:31
 */
public class FileReqDto implements Serializable {

    @Size(max=32,message="业务流水长度不能超过{max}位")
    private String  SerialNo;//业务流水

    @Size(max=8,message="业务时间长度不能超过{max}位")
    private String  BussTime;//业务时间

    @JSONField(name = "SerialNo")
    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String serialNo) {
        SerialNo = serialNo;
    }

    @JSONField(name = "BussTime")
    public String getBussTime() {
        return BussTime;
    }

    public void setBussTime(String bussTime) {
        BussTime = bussTime;
    }
}
