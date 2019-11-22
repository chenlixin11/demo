package rxt.bsb.api.dto.response;


/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月24日 上午10:39:38
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description:个人会员资金账户开户相应报文体
 */
public class OpenPersonalAcctRespBody {
	private String RetCode        ;//返回码       
	private String RetInfo      ;//网关页面 URL        
	private String AuthURL      ;//网关页面 URL      
	private String AuthTokenID        ;//网关令牌校验码       
	
	public String getRetCode() {
		return RetCode;
	}
	public void setRetCode(String retCode) {
		RetCode = retCode;
	}
	public String getRetInfo() {
		return RetInfo;
	}
	public void setRetInfo(String retInfo) {
		RetInfo = retInfo;
	}
	public String getAuthURL() {
		return AuthURL;
	}
	public void setAuthURL(String authURL) {
		AuthURL = authURL;
	}
	public String getAuthTokenID() {
		return AuthTokenID;
	}
	public void setAuthTokenID(String authTokenID) {
		AuthTokenID = authTokenID;
	}
	
}
