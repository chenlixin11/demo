package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 商品额外参数
 * Created by ChenLiXin on 2019/9/18 0018 13:55
 */
public class GoodsJsonStr implements Serializable {

    @Size(max = 10, message = "商品类型长度不超过{max}位")
    private String goodsType;//商品类型

    @Size(max = 10, message = "商品规格长度不超过{max}位")
    private String goodsSpec;//商品规格
/*
    @Size(max = 18, message = "交易笔数长度不超过{max}位")
    private String transNum;//交易笔数

    @Size(max = 18, message = "交易金额长度不超过{max}位")
    private String transAmt;//交易金额

    @Size(max = 18, message = "交易额占比长度不超过{max}位")
    private String transPrp;//交易额占比
*/
    @JSONField(name = "goodsType")
    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    @JSONField(name = "goodsSpec")
    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec;
    }
/*
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

 */
}
