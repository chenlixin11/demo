package rxt.bsb.api.dto.response;
/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月25日 下午4:43:41
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description:通知响应报文头
 */
public class NotifyRespondHead {

	private String merchantCode;//商户代码
	private String platformSerialCode;//银行流水号
	
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public String getPlatformSerialCode() {
		return platformSerialCode;
	}
	public void setPlatformSerialCode(String platformSerialCode) {
		this.platformSerialCode = platformSerialCode;
	}
	
}
