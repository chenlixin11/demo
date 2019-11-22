package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月29日 上午14:48:11
 *
 * @author <a href="mailto:zhanggaoqun@rokesoft.com">zgq</a>
 *
 * @Description:会员订单单笔担保支付撤销
 */
public class RevocationMemberOrderPayReqDto implements Serializable{
	private static final long serialVersionUID = -3770103526150916393L;
	@NotBlank(message="商户流水号不能空")
	@Size(max=32,message="商户流水号长度不能超过{max}位")
	private String OrderNo;//商户流水号
	
	@NotBlank(message="商户子流水号不能空")
	@Size(max=32,message="商户子流水号长度不能超过{max}位")
	private String SubOrderNo;//商户子流水号
	
	@NotBlank(message="商户交易日期不能空")
	@Size(max=8,message="商户交易日期长度不能超过{max}位")
	private String OrderDate;//商户交易日期
	
	@Size(max=255,message="交易附言长度不能超过{max}位")
	private String PostScript;//交易附言

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

	@JSONField(name="PostScript")
	public String getPostScript() {
		return PostScript;
	}

	public void setPostScript(String postScript) {
		PostScript = postScript;
	}
}
