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
 * @createTime  2019年1月29日 下午5:43:35	
 *
 * @Description:	订单批量即时支付_收费信息
 */
public class BatchOrderFee implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = 558841965575485380L;
	@Size(max = 6, message = "费用编号长度不能超过{max}位")
	private String FeeCode;//费用编号
	private String FeeAmt;//费用金额
	@Size(max = 128, message = "备注长度不能超过{max}位")
	private String PostScript;//备注
	
	@JSONField(name="FeeCode")
	public String getFeeCode() {
		return FeeCode;
	}
	public void setFeeCode(String feeCode) {
		FeeCode = feeCode;
	}
	@JSONField(name="FeeAmt")
	public String getFeeAmt() {
		return FeeAmt;
	}
	public void setFeeAmt(String feeAmt) {
		FeeAmt = feeAmt;
	}
	@JSONField(name="PostScript")
	public String getPostScript() {
		return PostScript;
	}
	public void setPostScript(String postScript) {
		PostScript = postScript;
	}
}
