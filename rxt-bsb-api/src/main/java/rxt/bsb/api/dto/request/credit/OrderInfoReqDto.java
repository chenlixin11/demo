package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by ChenLiXin on 2019/9/17 0017 20:30
 */
public class OrderInfoReqDto implements Serializable {

    @Size(max=32,message="订单编号长度不能超过{max}位")
    private String  OrderNo;//订单编号

    @JSONField(name = "OrderNo")
    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }
}
