package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;


public class ModifyMobileReqDto implements Serializable{
	
	private static final long serialVersionUID = 2190080697400170740L;
	
	@NotBlank(message="资金账号不能空")
	@Size(max=32,message="资金账号长度不能超过{max}位")
	private String SubAcctNo;//资金账号
	@NotBlank(message="新手机号不能空")
	@Size(max=11,message="新手机号长度不能超过{max}位")
	private String NewMobileNo;//新手机号

	@JSONField(name="SubAcctNo")
	public String getSubAcctNo() {
		return SubAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
	}
	@JSONField(name="NewMobileNo")
	public String getNewMobileNo() {
		return NewMobileNo;
	}
	public void setNewMobileNo(String newMobileNo) {
		NewMobileNo = newMobileNo;
	}
	
	

}
