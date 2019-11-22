package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class UnBindAcctNoReqDto implements Serializable{

	private static final long serialVersionUID = -1516483499066019902L;

	@NotBlank(message="资金账号不能空")
	@Size(max=32,message="资金账号长度不能超过{max}位")
	private String SubAcctNo;//资金账号
	@NotBlank(message="解绑银行卡号不能空")
	@Size(max=32,message="解绑银行卡号长度不能超过{max}位")
	private String BindAcctNo;//解绑银行卡号
	
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
	
	
	
}
