package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 * @Copyright (c)</ b> 2012融信通-版权所有<br/>
 * @createTime 2019年1月24日 上午10:39:38
 * @Description:个人会员资金账户开户
 */
public class OpenPersonalAcctReqDto implements Serializable {

    private static final long serialVersionUID = -3284110279662363447L;
    @NotBlank(message = "用户代码不能空")
    @Size(max = 20, message = "用户代码长度不能超过{max}位")
    private String CustNo;//用户代码

    @NotBlank(message = "用户姓名不能空")
    @Size(max = 20, message = "用户姓名长度不能超过{max}位")
    private String CustName;//用户姓名

    @NotBlank(message = "证件类型不能空")
    @Size(max = 2, message = "证件类型长度不能超过{max}位")
    private String CertType;//证件类型

    @NotBlank(message = "证件号码不能空")
    @Size(max = 20, message = "证件号码长度不能超过{max}位")
    private String CertNo;//证件号码

    @NotBlank(message = "手机号码不能空")
    @Size(max = 11, message = "手机号码长度不能超过{max}位")
    private String MobileNo;//手机号码

    @NotBlank(message = "邮箱不能空")
    @Size(max = 128, message = "邮箱长度不能超过{max}位")
    private String Email;//邮箱

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

    @Size(max = 1, message = "还款账户开立标志长度不能超过{max}位")
    private String RepayAcctFlag;//还款账户开立标志

	@Size(max = 2, message = "开户类型长度不能超过{max}位")
	private String AcctType;//开户类型  当开定向支付户时，值为“03” ，不开定向支付户时，默认为空。

    @JSONField(name = "CustNo")
    public String getCustNo() {
        return CustNo;
    }

    public void setCustNo(String custNo) {
        CustNo = custNo;
    }

    @JSONField(name = "CustName")
    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    @JSONField(name = "CertType")
    public String getCertType() {
        return CertType;
    }

    public void setCertType(String certType) {
        CertType = certType;
    }

    @JSONField(name = "CertNo")
    public String getCertNo() {
        return CertNo;
    }

    public void setCertNo(String certNo) {
        CertNo = certNo;
    }

    @JSONField(name = "MobileNo")
    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    @JSONField(name = "Email")
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @JSONField(name = "RepayAcctFlag")
    public String getRepayAcctFlag() {
        return RepayAcctFlag;
    }

    public void setRepayAcctFlag(String repayAcctFlag) {
        RepayAcctFlag = repayAcctFlag;
    }

	@JSONField(name = "CertValidDate")
	public String getCertValidDate() {
		return CertValidDate;
	}

	public void setCertValidDate(String certValidDate) {
		CertValidDate = certValidDate;
	}

	@JSONField(name = "RegisteredPlace")
	public String getRegisteredPlace() {
		return RegisteredPlace;
	}

	public void setRegisteredPlace(String registeredPlace) {
		RegisteredPlace = registeredPlace;
	}

	@JSONField(name = "BusinessPlace")
	public String getBusinessPlace() {
		return BusinessPlace;
	}

	public void setBusinessPlace(String businessPlace) {
		BusinessPlace = businessPlace;
	}

	@JSONField(name = "Nationality")
	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	@JSONField(name = "AcctType")
	public String getAcctType() {
		return AcctType;
	}

	public void setAcctType(String acctType) {
		AcctType = acctType;
	}
}
