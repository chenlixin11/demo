package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 商品列表
 * Created by ChenLiXin on 2019/9/18 0018 13:28
 */
public class GoodsListDto implements Serializable {

    @NotBlank(message = "商品编号不能空")
    @Size(max = 32, message = "商品编号长度不超过{max}位")
    private String GoodsCode; //商品编号

    @NotBlank(message = "商品名称不能空")
    @Size(max = 200, message = "商品名称长度不超过{max}位")
    private String GoodsName; //商品名称

    @NotBlank(message = "商品单价不能空")
    @Size(max = 18, message = "商品单价长度不超过{max}位")
    private String GoodsPrice; //商品单价

    @NotBlank(message = "商品数量不能空")
    @Size(max = 18, message = "商品数量长度不超过{max}位")
    private String GoodsQuantity; //商品数量

    @NotBlank(message = "商品单位不能空")
    @Size(max = 2, message = "商品单位长度不超过{max}位")
    private String GoodsUnit; //商品单位

    @NotBlank(message = "商品总价不能空")
    @Size(max = 18, message = "商品总价长度不超过{max}位")
    private String GoodsTotalMoney; //商品总价

    @NotBlank(message = "摘要不能空")
    @Size(max = 1000, message = "摘要长度不超过{max}位")
    private String GoodsSummary; //摘要

    private GoodsJsonStr GoodsJson; //商品额外参数

    @JSONField(name = "GoodsCode")
    public String getGoodsCode() {
        return GoodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        GoodsCode = goodsCode;
    }

    @JSONField(name = "GoodsName")
    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    @JSONField(name = "GoodsPrice")
    public String getGoodsPrice() {
        return GoodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        GoodsPrice = goodsPrice;
    }

    @JSONField(name = "GoodsQuantity")
    public String getGoodsQuantity() {
        return GoodsQuantity;
    }

    public void setGoodsQuantity(String goodsQuantity) {
        GoodsQuantity = goodsQuantity;
    }

    @JSONField(name = "GoodsUnit")
    public String getGoodsUnit() {
        return GoodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        GoodsUnit = goodsUnit;
    }

    @JSONField(name = "GoodsTotalMoney")
    public String getGoodsTotalMoney() {
        return GoodsTotalMoney;
    }

    public void setGoodsTotalMoney(String goodsTotalMoney) {
        GoodsTotalMoney = goodsTotalMoney;
    }

    @JSONField(name = "GoodsSummary")
    public String getGoodsSummary() {
        return GoodsSummary;
    }

    public void setGoodsSummary(String goodsSummary) {
        GoodsSummary = goodsSummary;
    }

    @JSONField(name = "GoodsJson")
    public GoodsJsonStr getGoodsJson() {
        return GoodsJson;
    }

    public void setGoodsJson(GoodsJsonStr goodsJson) {
        GoodsJson = goodsJson;
    }
}
