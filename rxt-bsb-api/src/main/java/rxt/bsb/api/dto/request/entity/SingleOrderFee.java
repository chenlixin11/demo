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
 * @createTime  2019年1月29日 下午5:02:24	
 *
 * @Description:	订单单笔即时支付_收费信息
 */
public class SingleOrderFee implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = 7961319362569959942L;
	@Size(max=6,message="费用编号长度不能超过{max}位")
	private String FeeCode;//费用编号
	@Size(max=16,message="费用金额长度不能超过{max}位")
	private String FeeAmt;//费用金额
	
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
}
