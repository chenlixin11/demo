package rxt.bsb.api.dto.request.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

public class FeeList implements Serializable{

	private static final long serialVersionUID = 6500755375762078285L;
	
	@Size(max = 6, message = "费用编号长度不能超过{max}位")
	private String FeeCode;//费用编号
	private String FeeAmt;//费用金额
	
	@JSONField(name="FeeCode")
	public String getFeeCode() {
		return FeeCode;
	}
	public void setFeeCode(String feeCode) {
		FeeCode = feeCode;
	}
	@JSONField(name="FeeAmt")
	public String getFeeAmt() {
		return FeeAmt;
	}
	public void setFeeAmt(String feeAmt) {
		FeeAmt = feeAmt;
	}

	
}
