package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;
import rxt.bsb.api.dto.request.entity.BatchWithdrawInfoList;
import rxt.bsb.api.dto.request.entity.FeeList;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class CashWithdrawalBatchReqDto implements Serializable{

	private static final long serialVersionUID = -1516483499066019902L;

	@NotBlank(message="付款资金账号不能空")
	@Size(max=32,message="付款资金账号长度不能超过{max}位")
	private String SubAcctNo;//付款资金账号
	@NotBlank(message="操作标识不能空")
	@Size(max=32,message="操作标识长度不能超过{max}位")
	private String OperFlag;//操作标识(默认为 0)
	@NotBlank(message="批量出金总金额不能空")
	@Size(max=16,message="批量出金总金额长度不能超过{max}位")
	private String Amount;//批量出金总金额
	@NotBlank(message="批量出金收款方总个数不能空")
	@Size(max=8,message="批量出金收款方总个数长度不能超过{max}位")
	private String Count;//批量出金收款方总个数
	@NotBlank(message="收款信息不能空")
	@Valid
	private List<BatchWithdrawInfoList> BatchWithdrawInfoList;
	@Valid
	private List<FeeList> FeeList;
	@Size(max=128,message="交易附言长度不能超过{max}位")
	private String BatchPostScript;//交易附言
	
	@JSONField(name="SubAcctNo")
	public String getSubAcctNo() {
		return SubAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
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
	@JSONField(name="Count")
	public String getCount() {
		return Count;
	}
	public void setCount(String count) {
		Count = count;
	}
	@JSONField(name="BatchWithdrawInfoList")
	public List<BatchWithdrawInfoList> getBatchWithdrawInfoList() {
		return BatchWithdrawInfoList;
	}
	public void setBatchWithdrawInfoList(
			List<BatchWithdrawInfoList> batchWithdrawInfoList) {
		BatchWithdrawInfoList = batchWithdrawInfoList;
	}
	@JSONField(name="FeeList")
	public List<FeeList> getFeeList() {
		return FeeList;
	}
	public void setFeeList(List<FeeList> feeList) {
		FeeList = feeList;
	}
	@JSONField(name="BatchPostScript")
	public String getBatchPostScript() {
		return BatchPostScript;
	}
	public void setBatchPostScript(String batchPostScript) {
		BatchPostScript = batchPostScript;
	}
	
	
}
