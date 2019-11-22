package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 3.2.2 订单信息推送 请求报文
 * Created by ChenLiXin on 2019/9/18 0018 11:21
 */
public class OrderPushReqDto implements Serializable {

    private List<OrderListReqDto> OrderList;//订单列表

    @JSONField(name = "OrderList")
    public List<OrderListReqDto> getOrderList() {
        return OrderList;
    }

    public void setOrderList(List<OrderListReqDto> orderList) {
        OrderList = orderList;
    }
}
