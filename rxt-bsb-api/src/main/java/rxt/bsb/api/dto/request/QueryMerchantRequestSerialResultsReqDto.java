package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月29日 上午14:40:04
 *
 * @author <a href="mailto:zhanggaoqun@rokesoft.com">zgq</a>
 *
 * @Description:商户请求流水结果查询
 */
public class QueryMerchantRequestSerialResultsReqDto implements Serializable{
	private static final long serialVersionUID = -3514593607813456730L;
	@NotBlank(message="原商户请求交易流水号不能空")
	@Size(max=32,message="原商户请求交易流水号长度不能超过{max}位")
	private String OldOrderNo;//原商户请求交易流水号
	
	@NotBlank(message="原商户交易日期不能空")
	@Size(max=8,message="原商户交易日期长度不能超过{max}位")
	private String OldReqDate;//原商户交易日期
	
	@NotBlank(message="原功能代码不能空")
	@Size(max=10,message="原功能代码长度不能超过{max}位")
	private String OldFunCode;//原功能代码

	@JSONField(name="OldOrderNo")
	public String getOldOrderNo() {
		return OldOrderNo;
	}

	public void setOldOrderNo(String oldOrderNo) {
		OldOrderNo = oldOrderNo;
	}

	@JSONField(name="OldReqDate")
	public String getOldReqDate() {
		return OldReqDate;
	}

	public void setOldReqDate(String oldReqDate) {
		OldReqDate = oldReqDate;
	}

	@JSONField(name="OldFunCode")
	public String getOldFunCode() {
		return OldFunCode;
	}

	public void setOldFunCode(String oldFunCode) {
		OldFunCode = oldFunCode;
	}

}
