package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;
import rxt.bsb.api.dto.request.entity.BatchOrderFee;
import rxt.bsb.api.dto.request.entity.BatchOrderGood;
import rxt.bsb.api.dto.request.entity.EnterpriseBatchColInfoList;

import javax.validation.Valid;
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
 * @createTime  2019年1月25日 下午4:38:26	
 *
 * @Description:	企业订单批量即时支付 会员订单加强型即时支付
 */
public class EnterpriseBatchOrderPayDownReqDto implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = 1L;
	@Size(max=32,message="付款资金账号长度不能超过{max}位")
	private String PaySubAcctNo;//付款资金账号

	private BigDecimal TotalAmt;//订单总额
	private BigDecimal RealPayAmt;//实付金额
	private BigDecimal BPAmt;//积分金额
	private BigDecimal RedPackAmt;//红包金额
	private BigDecimal CouponAmt;//卡券金额

	@Size(max = 32, message = "银行卡号长度不能超过{max}位")
	private String OppAcctNo;  //银行卡号
	@Size(max = 32, message = "支付类型长度不能超过{max}位")
	private String PayType; //支付类型 1、虚账户支付 2、银行卡支付）

	@Valid
	private List<EnterpriseBatchColInfoList> BatchColInfoList;//收款方集合
	@Valid
	private List<BatchOrderFee> FeeList;
	@Valid
	private List<BatchOrderGood> GoodList;

	@JSONField(name = "OppAcctNo")
	public String getOppAcctNo() {
		return OppAcctNo;
	}

	public void setOppAcctNo(String oppAcctNo) {
		OppAcctNo = oppAcctNo;
	}

	@JSONField(name = "PayType")
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String payType) {
		PayType = payType;
	}
	
	@JSONField(name="PaySubAcctNo")
	public String getPaySubAcctNo() {
		return PaySubAcctNo;
	}
	public void setPaySubAcctNo(String paySubAcctNo) {
		PaySubAcctNo = paySubAcctNo;
	}
	@JSONField(name="TotalAmt")
	public BigDecimal getTotalAmt() {
		return TotalAmt;
	}
	public void setTotalAmt(BigDecimal totalAmt) {
		TotalAmt = totalAmt;
	}
	@JSONField(name="RealPayAmt")
	public BigDecimal getRealPayAmt() {
		return RealPayAmt;
	}
	public void setRealPayAmt(BigDecimal realPayAmt) {
		RealPayAmt = realPayAmt;
	}
	@JSONField(name="BPAmt")
	public BigDecimal getBPAmt() {
		return BPAmt;
	}
	public void setBPAmt(BigDecimal bPAmt) {
		BPAmt = bPAmt;
	}
	@JSONField(name="RedPackAmt")
	public BigDecimal getRedPackAmt() {
		return RedPackAmt;
	}
	public void setRedPackAmt(BigDecimal redPackAmt) {
		RedPackAmt = redPackAmt;
	}
	@JSONField(name="CouponAmt")
	public BigDecimal getCouponAmt() {
		return CouponAmt;
	}
	public void setCouponAmt(BigDecimal couponAmt) {
		CouponAmt = couponAmt;
	}
	@JSONField(name="BatchColInfoList")
	public List<EnterpriseBatchColInfoList> getBatchColInfoList() {
		return BatchColInfoList;
	}
	public void setBatchColInfoList(List<EnterpriseBatchColInfoList> batchColInfoList) {
		BatchColInfoList = batchColInfoList;
	}
	@JSONField(name="FeeList")
	public List<BatchOrderFee> getFeeList() {
		return FeeList;
	}
	public void setFeeList(List<BatchOrderFee> feeList) {
		FeeList = feeList;
	}
	@JSONField(name="GoodList")
	public List<BatchOrderGood> getGoodList() {
		return GoodList;
	}

	public void setGoodList(List<BatchOrderGood> goodList) {
		GoodList = goodList;
	}
}
