package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 *
 * @createTime  2019年1月30日 下午5:53:14	
 *
 * @Description:	商户交易结果通知
 */
public class BuinessTransResultNotifyReqDto implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = 5979497305702442480L;
	@Size(max=32,message="商户流水号长度不能超过{max}位")
	private String merchantSerialCode;//商户流水号
	@Size(max=32,message="银行交易流水号长度不能超过{max}位")
	private String platformSerialCode;//银行交易流水号
	@Size(max=8,message="功能代码长度不能超过{max}位")
	private String tradeCode;//功能代码
	@Size(max=6,message="状态码长度不能超过{max}位")
	private String returnCode;//状态码
	@Size(max=32,message="状态描述长度不能超过{max}位")
	private String returnMessage;//状态描述
	@Size(max=32,message="交易返回信息长度不能超过{max}位")
	private String returnInfo;//交易返回信息
	
	@JSONField(name="merchantSerialCode")
	public String getMerchantSerialCode() {
		return merchantSerialCode;
	}
	public void setMerchantSerialCode(String merchantSerialCode) {
		this.merchantSerialCode = merchantSerialCode;
	}
	@JSONField(name="platformSerialCode")
	public String getPlatformSerialCode() {
		return platformSerialCode;
	}
	public void setPlatformSerialCode(String platformSerialCode) {
		this.platformSerialCode = platformSerialCode;
	}
	@JSONField(name="tradeCode")
	public String getTradeCode() {
		return tradeCode;
	}
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	@JSONField(name="returnCode")
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	@JSONField(name="returnMessage")
	public String getReturnMessage() {
		return returnMessage;
	}
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}
	@JSONField(name="returnInfo")
	public String getReturnInfo() {
		return returnInfo;
	}
	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
	}
	

}
