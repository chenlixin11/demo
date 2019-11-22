package rxt.bsb.api.dto.request.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 *
 * @createTime  2019年1月29日 下午5:01:32	
 *
 * @Description:	订单单笔即时支付_商品信息
 */
public class SingleOrderGood implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = 5275369761870588372L;
	@Size(max=64,message="商品编号长度不能超过{max}位")
	private String GoodsID;//商品编号
	@Size(max=200,message="商品名称长度不能超过{max}位")
	private String GoodsName;//商品名称
	@Size(max=100,message="商品规格长度不能超过{max}位")
	private String GoodsSpec;//商品规格

	@Size(max=10,message="商品数量长度不能超过{max}位")
	private String GoodsNum;//商品数量
	@Size(max=16,message="商品单价长度不能超过{max}位")
	private String GoodsPrice;//商品单价
	@Size(max=16,message="商品金额长度不能超过{max}位")
	private String GoodsAmt;//商品金额= 商品单价*商品数量

	@Size(max=255,message="商品备注长度不能超过{max}位")
	private String GoodsRemark;//商品备注
	@Size(max=255,message="交易附言长度不能超过{max}位")
	private String PostScript;//交易附言
	
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
	public String getGoodsPrice() {
		return GoodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		GoodsPrice = goodsPrice;
	}
	@JSONField(name="GoodsAmt")
	public String getGoodsAmt() {
		return GoodsAmt;
	}
	public void setGoodsAmt(String goodsAmt) {
		GoodsAmt = goodsAmt;
	}
	@JSONField(name="GoodsRemark")
	public String getGoodsRemark() {
		return GoodsRemark;
	}
	public void setGoodsRemark(String goodsRemark) {
		GoodsRemark = goodsRemark;
	}
	@JSONField(name="PostScript")
	public String getPostScript() {
		return PostScript;
	}
	public void setPostScript(String postScript) {
		PostScript = postScript;
	}
	
}
