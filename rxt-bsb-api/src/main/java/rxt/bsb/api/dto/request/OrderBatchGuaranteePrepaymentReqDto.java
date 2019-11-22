package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;
import rxt.bsb.api.dto.request.entity.BatchGuaranteePrepaymentList;

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
 * @createTime  2019年1月30日 上午10:17:44	
 *
 * @Description:	会员订单批量担保支付预付  会员订单加强型批量担保支付预付
 */
public class OrderBatchGuaranteePrepaymentReqDto implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = 6965723896979419117L;
	
	@Size(max=32,message="付款资金账号长度不能超过{max}位")
	private String SubAcctNo;//付款资金账号
	@Size(max = 32, message = "银行卡号长度不能超过{max}位")
	private String OppAcctNo;  //银行卡号
	@Size(max = 32, message = "支付类型长度不能超过{max}位")
	private String PayType; //支付类型 1、虚账户支付 2、银行卡支付
	private BigDecimal TotalAmt;//订单总额
	@Valid
	private List<BatchGuaranteePrepaymentList> BatchColTransList;

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
	@JSONField(name="SubAcctNo")
	public String getSubAcctNo() {
		return SubAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
	}
	@JSONField(name="TotalAmt")
	public BigDecimal getTotalAmt() {
		return TotalAmt;
	}
	public void setTotalAmt(BigDecimal totalAmt) {
		TotalAmt = totalAmt;
	}
	@JSONField(name="BatchColTransList")
	public List<BatchGuaranteePrepaymentList> getBatchColTransList() {
		return BatchColTransList;
	}
	public void setBatchColTransList(List<BatchGuaranteePrepaymentList> batchColTransList) {
		BatchColTransList = batchColTransList;
	}
}
