package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 订单统计供应商统计
 * Created by ChenLiXin on 2019/9/18 0018 13:14
 */
public class OrderSupplierList implements Serializable {

    @Size(max = 32,message = "卖方编码长度不超过{max}位")
    private String sellerNo;//卖方编码

    @Size(max = 50,message = "卖方名称长度不超过{max}位")
    private String sellerName ;//卖方名称

    @Size(max = 18,message = "交易笔数长度不超过{max}位")
    private String transNum  ;//交易笔数

    @Size(max = 18,message = "交易金额长度不超过{max}位")
    private String transAmt  ;//交易金额

    @Size(max = 18,message = "交易占比长度不超过{max}位")
    private String transPrp   ;//交易占比

    @JSONField(name = "sellerNo")
    public String getSellerNo() {
        return sellerNo;
    }

    public void setSellerNo(String sellerNo) {
        this.sellerNo = sellerNo;
    }

    @JSONField(name = "sellerName")
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @JSONField(name = "transNum")
    public String getTransNum() {
        return transNum;
    }

    public void setTransNum(String transNum) {
        this.transNum = transNum;
    }

    @JSONField(name = "transAmt")
    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }

    @JSONField(name = "transPrp")
    public String getTransPrp() {
        return transPrp;
    }

    public void setTransPrp(String transPrp) {
        this.transPrp = transPrp;
    }
}
