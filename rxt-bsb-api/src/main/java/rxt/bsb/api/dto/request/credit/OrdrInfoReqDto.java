package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class OrdrInfoReqDto implements Serializable {
    @Size(max=32,message="订单编号长度不能超过{max}位")
    private String  OrdrNo;//订单编号

    @JSONField(name = "OrdrNo")
    public String getOrdrNo() {
        return OrdrNo;
    }

    public void setOrdrNo(String ordrNo) {
        OrdrNo = ordrNo;
    }
}
