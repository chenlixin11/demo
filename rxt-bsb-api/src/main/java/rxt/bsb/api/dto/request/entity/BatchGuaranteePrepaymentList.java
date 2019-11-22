package rxt.bsb.api.dto.request.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 *
 * @createTime  2019年1月30日 上午10:36:43	
 *
 * @Description:	会员订单批量担保支付预付_收款信息
 */
public class BatchGuaranteePrepaymentList implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = -6963922877211329751L;
	@Size(max=32,message="收款资金账号长度不能超过{max}位")
	private String RecFundAcctNo;//收款资金账号
	private BigDecimal BatchAmt;//批次总额
	@Size(max=16,message="商户子订单号长度不能超过{max}位")
	private String SubOrderNo;//商户子订单号

	private  BigDecimal  RealPayAmt;//实付金额
	private  BigDecimal  RedPackAmt;//红包金额
	private  BigDecimal  BPAmt;//积分金额
	private BigDecimal CouponAmt;//卡券金额

	@NotBlank(message="预付方式不能空")
	@Size(max=16,message="预付方式长度不能超过{max}位")
	private String PrepayType;//预付方式,0:付款冻结（圈存）;1:收款冻结（支付并圈存）
	@Valid
	private List<SingleOrderFee> FeeList;
	@Valid
	private List<SingleOrderGood> GoodList;
	
	@JSONField(name="RecFundAcctNo")
	public String getRecFundAcctNo() {
		return RecFundAcctNo;
	}
	public void setRecFundAcctNo(String recFundAcctNo) {
		RecFundAcctNo = recFundAcctNo;
	}
	@JSONField(name="BatchAmt")
	public BigDecimal getBatchAmt() {
		return BatchAmt;
	}
	public void setBatchAmt(BigDecimal batchAmt) {
		BatchAmt = batchAmt;
	}
	@JSONField(name="SubOrderNo")
	public String getSubOrderNo() {
		return SubOrderNo;
	}
	public void setSubOrderNo(String subOrderNo) {
		SubOrderNo = subOrderNo;
	}
	@JSONField(name="RealPayAmt")
	public BigDecimal getRealPayAmt() {
		return RealPayAmt;
	}
	public void setRealPayAmt(BigDecimal realPayAmt) {
		RealPayAmt = realPayAmt;
	}
	@JSONField(name="RedPackAmt")
	public BigDecimal getRedPackAmt() {
		return RedPackAmt;
	}
	public void setRedPackAmt(BigDecimal redPackAmt) {
		RedPackAmt = redPackAmt;
	}
	@JSONField(name="BPAmt")
	public BigDecimal getBPAmt() {
		return BPAmt;
	}
	public void setBPAmt(BigDecimal bPAmt) {
		BPAmt = bPAmt;
	}
	@JSONField(name="CouponAmt")
	public BigDecimal getCouponAmt() {
		return CouponAmt;
	}
	public void setCouponAmt(BigDecimal couponAmt) {
		CouponAmt = couponAmt;
	}
	@JSONField(name="PrepayType")
	public String getPrepayType() {
		return PrepayType;
	}
	public void setPrepayType(String prepayType) {
		PrepayType = prepayType;
	}
	@JSONField(name="FeeList")
	public List<SingleOrderFee> getFeeList() {
		return FeeList;
	}
	public void setFeeList(List<SingleOrderFee> feeList) {
		FeeList = feeList;
	}
	@JSONField(name="GoodList")
	public List<SingleOrderGood> getGoodList() {
		return GoodList;
	}
	public void setGoodList(List<SingleOrderGood> goodList) {
		GoodList = goodList;
	}
}
