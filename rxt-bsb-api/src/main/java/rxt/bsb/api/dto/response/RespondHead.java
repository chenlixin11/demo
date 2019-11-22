package rxt.bsb.api.dto.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月24日 上午10:35:16
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description:应答报文头
 */
public class RespondHead {

	private String  CustCode   ;//客户代码       
	private String  MerCode    ;//商户代码       
	private String  MerAcctNo  ;//商户账号       
	private String  MerCurrCode;//商户币种代码   
	private String  FunCode    ;//功能代码       
	private String  SerialNo   ;//银行流水号     
	private String  TransDate  ;//银行交易日期   
	private String  ChanCode   ;//渠道代码       
	private String  TransTime  ;//银行交易时间   
	private String  RetCode    ;//返回码         
	private String  RetInfo    ;//返回信息       
	private String  AuthTokenID;//网关令牌校验码 
	private String  AuthURL;//网关页面 URL
	@JSONField(name="CustCode")
	public String getCustCode() {
		return CustCode;
	}
	public void setCustCode(String custCode) {
		CustCode = custCode;
	}
	@JSONField(name="MerCode")
	public String getMerCode() {
		return MerCode;
	}
	public void setMerCode(String merCode) {
		MerCode = merCode;
	}
	@JSONField(name="MerAcctNo")
	public String getMerAcctNo() {
		return MerAcctNo;
	}
	public void setMerAcctNo(String merAcctNo) {
		MerAcctNo = merAcctNo;
	}
	@JSONField(name="MerCurrCode")
	public String getMerCurrCode() {
		return MerCurrCode;
	}
	public void setMerCurrCode(String merCurrCode) {
		MerCurrCode = merCurrCode;
	}
	@JSONField(name="FunCode")
	public String getFunCode() {
		return FunCode;
	}
	public void setFunCode(String funCode) {
		FunCode = funCode;
	}
	@JSONField(name="SerialNo")
	public String getSerialNo() {
		return SerialNo;
	}
	public void setSerialNo(String serialNo) {
		SerialNo = serialNo;
	}
	@JSONField(name="TransDate")
	public String getTransDate() {
		return TransDate;
	}
	public void setTransDate(String transDate) {
		TransDate = transDate;
	}
	@JSONField(name="ChanCode")
	public String getChanCode() {
		return ChanCode;
	}
	public void setChanCode(String chanCode) {
		ChanCode = chanCode;
	}
	@JSONField(name="TransTime")
	public String getTransTime() {
		return TransTime;
	}
	public void setTransTime(String transTime) {
		TransTime = transTime;
	}
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
	@JSONField(name="AuthTokenID")
	public String getAuthTokenID() {
		return AuthTokenID;
	}
	public void setAuthTokenID(String authTokenID) {
		AuthTokenID = authTokenID;
	}
	@JSONField(name="AuthURL")
	public String getAuthURL() {
		return AuthURL;
	}
	public void setAuthURL(String authURL) {
		AuthURL = authURL;
	}

}
