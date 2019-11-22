package rxt.bsb.api.dto.request.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 *
 * @createTime  2019年1月29日 下午5:45:10	
 *
 * @Description:	个人订单批量即时支付_商品信息
 */
public class BatchOrderGood implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = -4614586429923301584L;
	@Size(max=64,message="商品编号长度不能超过{max}位")
	private String GoodsID;//商品编号
	@Size(max=128,message="商品名称长度不能超过{max}位")
	private String GoodsName;//商品名称
	@Size(max=100,message="商品规格长度不能超过{max}位")
	private String GoodsSpec;//商品规格
	private String GoodsNum;//商品数量
	private BigDecimal GoodsPrice;//商品单价
	private BigDecimal GoodsAmt;//商品金额= 商品单价*商品数量
	@Size(max = 128, message = "商品备注长度不能超过{max}位")
	private String GoodsRemark;//商品备注
	
	@JSONField(name="GoodsID")
	public String getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(String goodsID) {
		GoodsID = goodsID;
	}
	@JSONField(name="GoodsName")
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	@JSONField(name="GoodsSpec")
	public String getGoodsSpec() {
		return GoodsSpec;
	}
	public void setGoodsSpec(String goodsSpec) {
		GoodsSpec = goodsSpec;
	}
	@JSONField(name="GoodsNum")
	public String getGoodsNum() {
		return GoodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		GoodsNum = goodsNum;
	}
	@JSONField(name="GoodsPrice")
	public BigDecimal getGoodsPrice() {
		return GoodsPrice;
	}
	public void setGoodsPrice(BigDecimal goodsPrice) {
		GoodsPrice = goodsPrice;
	}
	@JSONField(name="GoodsAmt")
	public BigDecimal getGoodsAmt() {
		return GoodsAmt;
	}
	public void setGoodsAmt(BigDecimal goodsAmt) {
		GoodsAmt = goodsAmt;
	}
	@JSONField(name="GoodsRemark")
	public String getGoodsRemark() {
		return GoodsRemark;
	}
	public void setGoodsRemark(String goodsRemark) {
		GoodsRemark = goodsRemark;
	}
}
