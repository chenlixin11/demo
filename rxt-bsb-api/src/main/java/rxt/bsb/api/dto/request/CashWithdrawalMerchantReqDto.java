package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class CashWithdrawalMerchantReqDto implements Serializable{

	private static final long serialVersionUID = -1516483499066019902L;

	@NotBlank(message="商户资金账号不能空")
	@Size(max=32,message="商户资金账号长度不能超过{max}位")
	private String SubAcctNo;//商户资金账号
	@NotBlank(message="收款卡号/结算账号不能空")
	@Size(max=32,message="收款卡号/结算账号长度不能超过{max}位")
	private String RcvAcctNo;//收款卡号/结算账号
	@NotBlank(message="收款户名不能空")
	@Size(max=140,message="收款户名长度不能超过{max}位")
	private String RcvAcctName;//收款户名
	@NotBlank(message="收款行号不能空")
	@Size(max=12,message="收款行号长度不能超过{max}位")
	private String RcvBankNo;//收款行号（支行）
	@NotBlank(message="收款行名不能空")
	@Size(max=255,message="收款行名长度不能超过{max}位")
	private String RcvBankName;//收款行名（支行）
	@Size(max=16,message="交易金额长度不能超过{max}位")
	private String Amount;//交易金额
	@Size(max=255,message="交易附言长度不能超过{max}位")
	private String PostScript;//交易附言
	
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
	@JSONField(name="Amount")
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	@JSONField(name="PostScript")
	public String getPostScript() {
		return PostScript;
	}
	public void setPostScript(String postScript) {
		PostScript = postScript;
	}
	
	
}
