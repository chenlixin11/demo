package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 *
 * @createTime  2019年1月30日 上午11:26:09	
 *
 * @Description:	会员订单担保支付确认
 */
public class OrderGuaranteedPaymentConfirmReqDto implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = 6715091864419829031L;
	@Size(max=32,message="付款资金账号长度不能超过{max}位")
	private String SubAcctNo;//付款资金账号
	@Size(max=32,message="订单流水号长度不能超过{max}位")
	private String OrderNo;//订单流水号
	@Size(max=32,message="订单子流水号长度不能超过{max}位")
	private String SubOrderNo;//订单子流水号
	@Size(max=8,message="订单流水日期长度不能超过{max}位")
	private String OrderDate;//订单流水日期
	@Size(max=128,message="交易附言长度不能超过{max}位")
	private String PostScript;//交易附言
	
	@JSONField(name="SubAcctNo")
	public String getSubAcctNo() {
		return SubAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
	}
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
