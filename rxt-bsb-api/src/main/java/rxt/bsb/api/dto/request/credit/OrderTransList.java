package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 订单统计月交易统计  1 月到 24 月
 * Created by ChenLiXin on 2019/9/18 0018 13:08
 */
public class OrderTransList implements Serializable {

    @Size(max = 18, message = "统计金额长度不超过{max}位")
    private String transAmt;//统计金额

    @Size(max = 18, message = "统计数量长度不超过{max}位")
    private String transCount;//统计数量

    @Size(max = 5, message = "统计月份长度不超过{max}位")
    private String transMonth;//统计月份

    @JSONField(name = "transAmt")
    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }

    @JSONField(name = "transCount")
    public String getTransCount() {
        return transCount;
    }

    public void setTransCount(String transCount) {
        this.transCount = transCount;
    }

    @JSONField(name = "transMonth")
    public String getTransMonth() {
        return transMonth;
    }

    public void setTransMonth(String transMonth) {
        this.transMonth = transMonth;
    }
}
