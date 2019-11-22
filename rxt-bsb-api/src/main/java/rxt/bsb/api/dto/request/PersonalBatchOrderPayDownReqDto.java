package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import rxt.bsb.api.dto.request.entity.BatchOrderFee;
import rxt.bsb.api.dto.request.entity.BatchOrderGood;
import rxt.bsb.api.dto.request.entity.PersonalBatchColInfoList;

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
 * @Description:	个人订单批量即时支付
 */
public class PersonalBatchOrderPayDownReqDto implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = -8924481060134302312L;
	@Size(max=32,message="付款资金账号长度不能超过{max}位")
	private String PaySubAcctNo;//付款资金账号
	private BigDecimal TotalAmt;//订单总额
	private BigDecimal RealPayAmt;//实付金额
	@Valid
	private List<PersonalBatchColInfoList> BatchColInfoList;//收款方集合
	@Valid
	private List<BatchOrderFee> FeeList;
	@Valid
	private List<BatchOrderGood> GoodList;
	
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
	@JSONField(name="BatchColInfoList")
	public List<PersonalBatchColInfoList> getBatchColInfoList() {
		return BatchColInfoList;
	}
	public void setBatchColInfoList(List<PersonalBatchColInfoList> batchColInfoList) {
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
