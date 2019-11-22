package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class RechargeEnterpriseReqDto implements Serializable{

	private static final long serialVersionUID = -1516483499066019902L;

	@NotBlank(message="资金账号不能空")
	@Size(max=32,message="资金账号长度不能超过{max}位")
	private String SubAcctNo;//资金账号
	@NotBlank(message="出金方账号不能空")
	@Size(max=32,message="出金方账号长度不能超过{max}位")
	private String OppAcctNo;//出金方账号
	@NotBlank(message="出金方户名不能空")
	@Size(max=140,message="出金方户名长度不能超过{max}位")
	private String OppAcctName;//出金方户名
	@NotBlank(message="出金方行号不能空")
	@Size(max=32,message="出金方行号长度不能超过{max}位")
	private String OppBankNo;//出金方行号
	@NotBlank(message="出金方银行名称不能空")
	@Size(max=140,message="出金方银行名称长度不能超过{max}位")
	private String OppBankName;//出金方银行名称
	
	@JSONField(name="SubAcctNo")
	public String getSubAcctNo() {
		return SubAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
	}
	@JSONField(name="OppAcctNo")
	public String getOppAcctNo() {
		return OppAcctNo;
	}
	public void setOppAcctNo(String oppAcctNo) {
		OppAcctNo = oppAcctNo;
	}
	@JSONField(name="OppAcctName")
	public String getOppAcctName() {
		return OppAcctName;
	}
	public void setOppAcctName(String oppAcctName) {
		OppAcctName = oppAcctName;
	}
	@JSONField(name="OppBankNo")
	public String getOppBankNo() {
		return OppBankNo;
	}
	public void setOppBankNo(String oppBankNo) {
		OppBankNo = oppBankNo;
	}
	@JSONField(name="OppBankName")
	public String getOppBankName() {
		return OppBankName;
	}
	public void setOppBankName(String oppBankName) {
		OppBankName = oppBankName;
	}

	
}
