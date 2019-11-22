package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CashWithdrawalReqDto implements Serializable{

	private static final long serialVersionUID = -1516483499066019902L;

	@NotBlank(message="资金账号不能空")
	@Size(max=32,message="资金账号长度不能超过{max}位")
	private String SubAcctNo;//资金账号
	@NotBlank(message="收款银行卡号不能空")
	@Size(max=32,message="收款银行卡号长度不能超过{max}位")
	private String RcvAcctNo;//收款银行卡号
	@NotBlank(message="收款银行卡户名不能空")
	@Size(max=140,message="收款银行卡户名长度不能超过{max}位")
	private String RcvAcctName;//收款银行卡户名
	@NotBlank(message="收款银行行号不能空")
	@Size(max=12,message="收款银行行号长度不能超过{max}位")
	private String RcvBankNo;//收款银行行号
	@NotBlank(message="收款银行行名不能空")
	@Size(max=255,message="收款银行行名长度不能超过{max}位")
	private String RcvBankName;//收款银行行名（支行）
	@NotBlank(message="提现类型不能空")
	@Size(max=1,message="提现类型长度不能超过{max}位")
	private String OperFlag;//提现类型(0:实时提现,1:提现申请（暂不支持）)
	private String Amount;//交易金额
	@Valid
	private List<rxt.bsb.api.dto.request.entity.FeeList> FeeList;
	@Size(max=255,message="附言信息长度不能超过{max}位")
	private String PostScript;//附言信息
	
	@JSONField(name="SubAcctNo")
	public String getSubAcctNo() {
		return SubAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
	}
	@JSONField(name="RcvAcctNo")
	public String getRcvAcctNo() {
		return RcvAcctNo;
	}
	public void setRcvAcctNo(String rcvAcctNo) {
		RcvAcctNo = rcvAcctNo;
	}
	@JSONField(name="RcvAcctName")
	public String getRcvAcctName() {
		return RcvAcctName;
	}
	public void setRcvAcctName(String rcvAcctName) {
		RcvAcctName = rcvAcctName;
	}
	@JSONField(name="RcvBankNo")
	public String getRcvBankNo() {
		return RcvBankNo;
	}
	public void setRcvBankNo(String rcvBankNo) {
		RcvBankNo = rcvBankNo;
	}
	@JSONField(name="RcvBankName")
	public String getRcvBankName() {
		return RcvBankName;
	}
	public void setRcvBankName(String rcvBankName) {
		RcvBankName = rcvBankName;
	}
	@JSONField(name="OperFlag")
	public String getOperFlag() {
		return OperFlag;
	}
	public void setOperFlag(String operFlag) {
		OperFlag = operFlag;
	}
	@JSONField(name="Amount")
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	@JSONField(name="FeeList")
	public List<rxt.bsb.api.dto.request.entity.FeeList> getFeeList() {
		return FeeList;
	}
	public void setFeeList(List<rxt.bsb.api.dto.request.entity.FeeList> feeList) {
		FeeList = feeList;
	}
	@JSONField(name="PostScript")
	public String getPostScript() {
		return PostScript;
	}
	public void setPostScript(String postScript) {
		PostScript = postScript;
	}
	
	
}
