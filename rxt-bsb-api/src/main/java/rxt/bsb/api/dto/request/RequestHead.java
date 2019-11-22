package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月23日 下午3:23:25
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description:请求报文头
 */
public class RequestHead implements Serializable{

	private static final long serialVersionUID = -5209823631801567102L;
	@NotBlank(message="客户代码不能空")
	@Size(max=12,message="客户代码长度不能超过{max}位")
	private String CustCode    ;  //客户代码       
	
	@NotBlank(message="商户代码不能空")
	@Size(max=32,message="商户代码长度不能超过{max}位")
	private String MerCode     ;  //商户代码 
	
	@NotBlank(message="商户账号不能空")
	@Size(max=32,message="商户账号长度不能超过{max}位")
	private String MerAcctNo   ;  //商户账号
	
	@Size(max=2,message="商户币种代码长度不能超过{max}位")
	private String MerCurrCode ;  //商户币种代码 
	
	@NotBlank(message="功能代码不能空")
	@Size(max=10,message="功能代码长度不能超过{max}位")
	private String FunCode     ;  //功能代码   
	
	@NotBlank(message="渠道代码不能空")
	@Size(max=2,message="渠道代码长度不能超过{max}位")
	private String ChanCode    ;  //渠道代码  
	
	@NotBlank(message="商户流水号不能空")
	@Size(max=32,message="商户流水号长度不能超过{max}位")
	private String OrderNo     ;  //商户流水号 
	
	@NotBlank(message="商户交易日期不能空")
	@Size(max=8,message="商户交易日期长度不能超过{max}位")
	private String OrderDate   ;  //商户交易日期  
	
	@NotBlank(message="商户交易时间不能空")
	@Size(max=6,message="商户交易时间长度不能超过{max}位")
	private String OrderTime   ;  //商户交易时间   
	
	@Size(max=512,message="商户页面回调URL长度不能超过{max}位")
	private String RebackURL   ;  //商户页面回调URL
	
	@Size(max=512,message="商户通知回调URL长度不能超过{max}位")
	private String NotifyURL   ;  //商户通知回调URL

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
	@JSONField(name="ChanCode")
	public String getChanCode() {
		return ChanCode;
	}
	public void setChanCode(String chanCode) {
		ChanCode = chanCode;
	}
	@JSONField(name="OrderNo")
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	@JSONField(name="OrderDate")
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	@JSONField(name="OrderTime")
	public String getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}
	@JSONField(name="RebackURL")
	public String getRebackURL() {
		return RebackURL;
	}
	public void setRebackURL(String rebackURL) {
		RebackURL = rebackURL;
	}
	@JSONField(name="NotifyURL")
	public String getNotifyURL() {
		return NotifyURL;
	}
	public void setNotifyURL(String notifyURL) {
		NotifyURL = notifyURL;
	}
	
    
}
