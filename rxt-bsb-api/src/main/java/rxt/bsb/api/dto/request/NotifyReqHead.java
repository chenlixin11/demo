package rxt.bsb.api.dto.request;
/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月25日 下午3:59:51
 *
 * @author <a href=mailto:changguangwei@rokesoft.com>cgw</a>
 *
 * @Description:通知报文头
 */
public class NotifyReqHead {
	
	private String merchantCode;//商户代码
	private String tradeCode;//功能代码
	private String platformSerialCode;//银行流水号
	private String transDate;//银行交易日期
	
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public String getTradeCode() {
		return tradeCode;
	}
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	public String getPlatformSerialCode() {
		return platformSerialCode;
	}
	public void setPlatformSerialCode(String platformSerialCode) {
		this.platformSerialCode = platformSerialCode;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	
}
