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
 * @Description:商户交易结果查证
 */
public class QueryMerchantTransResultsReqDto implements Serializable{
	private static final long serialVersionUID = -4329621292595418975L;
	@NotBlank(message="用户代码不能空")
	@Size(max=32,message="商户流水号长度不能超过{max}位")
	private String OrderNo;//商户流水号
	
	@NotBlank(message="用户代码不能空")
	@Size(max=32,message="商户子流水号长度不能超过{max}位")
	private String SubOrderNo;//商户子流水号
	
	@NotBlank(message="商户交易日期不能空")
	@Size(max=8,message="商户交易日期长度不能超过{max}位")
	private String OrderDate;//商户交易日期

	@JSONField(name="OrderNo")
	public String getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}

	@JSONField(name="SubOrderNo")
	public String getSubOrderNo() {
		return SubOrderNo;
	}

	public void setSubOrderNo(String subOrderNo) {
		SubOrderNo = subOrderNo;
	}

	@JSONField(name="OrderDate")
	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
}
