package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class BindAcctNoReqDto implements Serializable{

	private static final long serialVersionUID = -1516483499066019902L;

	@NotBlank(message="资金账号不能空")
	@Size(max=32,message="资金账号长度不能超过{max}位")
	private String SubAcctNo;//资金账号
	@NotBlank(message="绑定卡号不能空")
	@Size(max=32,message="绑定卡号长度不能超过{max}位")
	private String BindAcctNo;//绑定卡号
	@NotBlank(message="绑定卡号不能空")
	@Size(max=32,message="绑定卡号长度不能超过{max}位")
	private String BindBankNo;//绑定卡行号
	@NotBlank(message="绑定卡行名不能空")
	@Size(max=32,message="绑定卡行名长度不能超过{max}位")
	private String BindBankName;//绑定卡行名
//	@NotBlank(message="开户银行不能空")
//	@Size(max=32,message="开户银行长度不能超过{max}位")
//	private String Bank;//开户银行
	
	@JSONField(name="SubAcctNo")
	public String getSubAcctNo() {
		return SubAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
	}
	@JSONField(name="BindAcctNo")
	public String getBindAcctNo() {
		return BindAcctNo;
	}
	public void setBindAcctNo(String bindAcctNo) {
		BindAcctNo = bindAcctNo;
	}
	@JSONField(name="BindBankNo")
	public String getBindBankNo() {
		return BindBankNo;
	}
	public void setBindBankNo(String bindBankNo) {
		BindBankNo = bindBankNo;
	}
	@JSONField(name="BindBankName")
	public String getBindBankName() {
		return BindBankName;
	}
	public void setBindBankName(String bindBankName) {
		BindBankName = bindBankName;
	}
//	@JSONField(name="Bank")
//	public String getBank() {
//		return Bank;
//	}
//	public void setBank(String bank) {
//		Bank = bank;
//	}
	
	
	
	
}
