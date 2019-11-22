package rxt.bsb.api.dto.request.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class BatchWithdrawInfoList implements Serializable{

	private static final long serialVersionUID = 6500755375762078285L;
	
	@NotBlank(message = "收款账号不能空")
	@Size(max = 32, message = "收款账号长度不能超过{max}位")
	private String BatchAcctNo;//收款账号
	@NotBlank(message = "收款账户名不能空")
	@Size(max = 64, message = "收款账户名长度不能超过{max}位")
	private String BatchAcctName;//收款账户名
	@NotBlank(message = "收款金额不能空")
	@Size(max = 16, message = "收款金额长度不能超过{max}位")
	private String BatchAmt;//收款金额
	@NotBlank(message = "交易子流水不能空")
	@Size(max = 32, message = "交易子流水长度不能超过{max}位")
	private String BatchOrderNo;//交易子流水
	@NotBlank(message = "收款方行号不能空")
	@Size(max = 32, message = "收款方行号长度不能超过{max}位")
	private String BatchBankNo;//收款方行号（支行行号）
	@NotBlank(message = "收款方行名不能空")
	@Size(max = 32, message = "收款方行名长度不能超过{max}位")
	private String BatchBankName;//收款方行名（支行行名）
	
	@JSONField(name="BatchAcctNo")
	public String getBatchAcctNo() {
		return BatchAcctNo;
	}
	public void setBatchAcctNo(String batchAcctNo) {
		BatchAcctNo = batchAcctNo;
	}
	@JSONField(name="BatchAcctName")
	public String getBatchAcctName() {
		return BatchAcctName;
	}
	public void setBatchAcctName(String batchAcctName) {
		BatchAcctName = batchAcctName;
	}
	@JSONField(name="BatchAmt")
	public String getBatchAmt() {
		return BatchAmt;
	}
	public void setBatchAmt(String batchAmt) {
		BatchAmt = batchAmt;
	}
	@JSONField(name="BatchOrderNo")
	public String getBatchOrderNo() {
		return BatchOrderNo;
	}
	public void setBatchOrderNo(String batchOrderNo) {
		BatchOrderNo = batchOrderNo;
	}
	@JSONField(name="BatchBankNo")
	public String getBatchBankNo() {
		return BatchBankNo;
	}
	public void setBatchBankNo(String batchBankNo) {
		BatchBankNo = batchBankNo;
	}
	@JSONField(name="BatchBankName")
	public String getBatchBankName() {
		return BatchBankName;
	}
	public void setBatchBankName(String batchBankName) {
		BatchBankName = batchBankName;
	}

	
}
