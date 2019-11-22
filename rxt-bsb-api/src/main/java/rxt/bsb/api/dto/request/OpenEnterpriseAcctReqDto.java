package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月24日 上午10:40:04
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description:企业会员资金账户开户
 */
public class OpenEnterpriseAcctReqDto implements Serializable{

	private static final long serialVersionUID = -7014984749331327246L;
	@NotBlank(message="企业代码不能空")
	@Size(max=20,message="企业代码长度不能超过{max}位")
	private String CustNo          ;//企业代码        
	
	@NotBlank(message="企业名称不能空")
	@Size(max=140,message="企业名称长度不能超过{max}位")
	private String CustName        ;//企业名称   
	
	@NotBlank(message="企业证件类型不能空")
	@Size(max=2,message="企业证件类型长度不能超过{max}位")
	private String CertType        ;//企业证件类型    
	
	@NotBlank(message="企业证件号码不能空")
	@Size(max=20,message="企业证件号码长度不能超过{max}位")
	private String CertNo          ;//企业证件号码  
	
	@NotBlank(message="法人代表不能空")
	@Size(max=20,message="法人代表长度不能超过{max}位")
	private String LegalRealName   ;//法人代表        
	
	@NotBlank(message="法人证件类型不能空")
	@Size(max=2,message="法人证件类型长度不能超过{max}位")
	private String LegalCertType   ;//法人证件类型  
	
	@NotBlank(message="法人证件号码不能空")
	@Size(max=20,message="法人证件号码长度不能超过{max}位")
	private String LegalCertNo     ;//法人证件号码   
	
	@NotBlank(message="经办人不能空")
	@Size(max=20,message="经办人长度不能超过{max}位")
	private String AgentName       ;//经办人          
	
	@NotBlank(message="经办人证件类型不能空")
	@Size(max=2,message="经办人证件类型长度不能超过{max}位")
	private String AgentCertType   ;//经办人证件类型  
	
	@NotBlank(message="经办人证件号码不能空")
	@Size(max=20,message="经办人证件号码长度不能超过{max}位")
	private String AgentCertNo     ;//经办人证件号码  
	
	@NotBlank(message="经办人手机号码不能空")
	@Size(max=11,message="经办人手机号码长度不能超过{max}位")
	private String AgentMobileNo   ;//经办人手机号码  
	
	@NotBlank(message="邮箱不能空")
	@Size(max=128,message="邮箱长度不能超过{max}位")
	private String Email           ;//邮箱

	@NotBlank(message = "证件有效期不能空")
	@Size(max = 8, message = "证件有效期不能超过{max}位")
	private String CertValidDate;//证件有效期

	@Size(max = 128, message = "注册地不能超过{max}位")
	private String RegisteredPlace;//注册地

	@Size(max = 128, message = "经营地不能超过{max}位")
	private String BusinessPlace;//经营地

	@NotBlank(message = "国籍不能空")
	@Size(max = 2, message = "国籍不能超过{max}位")
	private String Nationality;//国籍

	@Size(max = 2, message = "经营主体类型不能超过{max}位")
	private String EntityType;//经营主体类型

	@Size(max=1,message="还款账户开立标志长度不能超过{max}位")
	private String RepayAcctFlag   ;//还款账户开立标志

	@Size(max = 2, message = "开户类型长度不能超过{max}位")
	private String AcctType;//开户类型  当开定向支付户时，值为“03” ，不开定向支付户时，默认为空。


	@JSONField(name="CustNo")
	public String getCustNo() {
		return CustNo;
	}
	public void setCustNo(String custNo) {
		CustNo = custNo;
	}
	@JSONField(name="CustName")
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	@JSONField(name="CertType")
	public String getCertType() {
		return CertType;
	}
	public void setCertType(String certType) {
		CertType = certType;
	}
	@JSONField(name="CertNo")
	public String getCertNo() {
		return CertNo;
	}
	public void setCertNo(String certNo) {
		CertNo = certNo;
	}
	@JSONField(name="LegalRealName")
	public String getLegalRealName() {
		return LegalRealName;
	}
	public void setLegalRealName(String legalRealName) {
		LegalRealName = legalRealName;
	}
	@JSONField(name="LegalCertType")
	public String getLegalCertType() {
		return LegalCertType;
	}
	public void setLegalCertType(String legalCertType) {
		LegalCertType = legalCertType;
	}
	@JSONField(name="LegalCertNo")
	public String getLegalCertNo() {
		return LegalCertNo;
	}
	public void setLegalCertNo(String legalCertNo) {
		LegalCertNo = legalCertNo;
	}
	@JSONField(name="AgentName")
	public String getAgentName() {
		return AgentName;
	}
	public void setAgentName(String agentName) {
		AgentName = agentName;
	}
	@JSONField(name="AgentCertType")
	public String getAgentCertType() {
		return AgentCertType;
	}
	public void setAgentCertType(String agentCertType) {
		AgentCertType = agentCertType;
	}
	@JSONField(name="AgentCertNo")
	public String getAgentCertNo() {
		return AgentCertNo;
	}
	public void setAgentCertNo(String agentCertNo) {
		AgentCertNo = agentCertNo;
	}
	@JSONField(name="AgentMobileNo")
	public String getAgentMobileNo() {
		return AgentMobileNo;
	}
	public void setAgentMobileNo(String agentMobileNo) {
		AgentMobileNo = agentMobileNo;
	}
	@JSONField(name="Email")
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@JSONField(name="RepayAcctFlag")
	public String getRepayAcctFlag() {
		return RepayAcctFlag;
	}
	public void setRepayAcctFlag(String repayAcctFlag) {
		RepayAcctFlag = repayAcctFlag;
	}

	@JSONField(name="CertValidDate")
	public String getCertValidDate() {
		return CertValidDate;
	}

	public void setCertValidDate(String certValidDate) {
		CertValidDate = certValidDate;
	}

	@JSONField(name="RegisteredPlace")
	public String getRegisteredPlace() {
		return RegisteredPlace;
	}

	public void setRegisteredPlace(String registeredPlace) {
		RegisteredPlace = registeredPlace;
	}

	@JSONField(name="BusinessPlace")
	public String getBusinessPlace() {
		return BusinessPlace;
	}

	public void setBusinessPlace(String businessPlace) {
		BusinessPlace = businessPlace;
	}

	@JSONField(name="Nationality")
	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	@JSONField(name="EntityType")
	public String getEntityType() {
		return EntityType;
	}

	public void setEntityType(String entityType) {
		EntityType = entityType;
	}

	@JSONField(name="AcctType")
	public String getAcctType() {
		return AcctType;
	}

	public void setAcctType(String acctType) {
		AcctType = acctType;
	}
}
