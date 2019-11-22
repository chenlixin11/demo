package rxt.bsb.api.dto.response;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月25日 下午4:46:47
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description:通知响应报文体
 */
public class NotifyRespondBody {

	private String RetCode;//返回码 商户返回的通知应答码000000000000:
	private String RetInfo;//返回信息

	@JSONField(name="RetCode")
	public String getRetCode() {
		return RetCode;
	}
	public void setRetCode(String retCode) {
		RetCode = retCode;
	}
	@JSONField(name="RetInfo")
	public String getRetInfo() {
		return RetInfo;
	}
	public void setRetInfo(String retInfo) {
		RetInfo = retInfo;
	}
	
}
