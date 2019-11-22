package rxt.bsb.api.dto.request;
/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月25日 下午4:04:57
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description:通知报文体
 */
public class NotifyReqBody {

	 private String merchantSerialCode     ;//商户请求流水
	 private String platformSerialCode     ;//银行交易流水
	 private String tradeCode              ;//功能代码 
	 private String returnCode             ;//状态码  
	 private String returnMessage          ;//状态描述  
	 private String returnInfo             ;//交易返回信息
	 
	public String getMerchantSerialCode() {
		return merchantSerialCode;
	}
	public void setMerchantSerialCode(String merchantSerialCode) {
		this.merchantSerialCode = merchantSerialCode;
	}
	public String getPlatformSerialCode() {
		return platformSerialCode;
	}
	public void setPlatformSerialCode(String platformSerialCode) {
		this.platformSerialCode = platformSerialCode;
	}
	public String getTradeCode() {
		return tradeCode;
	}
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMessage() {
		return returnMessage;
	}
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}
	public String getReturnInfo() {
		return returnInfo;
	}
	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
	}
	
	 
	 
}
