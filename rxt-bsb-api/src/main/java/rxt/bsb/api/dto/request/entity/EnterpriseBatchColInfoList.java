package rxt.bsb.api.dto.request.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 *
 * @createTime  2019年1月29日 下午5:02:49	
 *
 * @Description:	企业订单批量即时支付_收款方集合
 */
public class EnterpriseBatchColInfoList implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = -7344082636208828052L;
	@NotBlank(message="收款账户不能空")
	@Size(max=32,message="收款账户长度不能超过{max}位")
	private String RecFundAcctNo;//收款账户
	private BigDecimal Amt;//子订单交易金额
	@NotBlank(message="商户子订单号不能空")
	@Size(max=32,message="商户子订单号长度不能超过{max}位")
	private String SubOrderNo;//商户子订单号
	@Size(max=128,message="备注长度不能超过{max}位")
	private String PostScript;//备注
	
	@JSONField(name="RecFundAcctNo")
	public String getRecFundAcctNo() {
		return RecFundAcctNo;
	}
	public void setRecFundAcctNo(String recFundAcctNo) {
		RecFundAcctNo = recFundAcctNo;
	}
	@JSONField(name="Amt")
	public BigDecimal getAmt() {
		return Amt;
	}
	public void setAmt(BigDecimal amt) {
		Amt = amt;
	}
	@JSONField(name="SubOrderNo")
	public String getSubOrderNo() {
		return SubOrderNo;
	}
	public void setSubOrderNo(String subOrderNo) {
		SubOrderNo = subOrderNo;
	}
	@JSONField(name="PostScript")
	public String getPostScript() {
		return PostScript;
	}
	public void setPostScript(String postScript) {
		PostScript = postScript;
	}
	
}
