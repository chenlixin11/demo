package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 *
 * @createTime  2019年1月31日 上午9:51:41	
 *
 * @Description:	资金账户动账通知
 */
public class AcctDynamicNotifyReqDto implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = -1752800400447690289L;
	@Size(max=32,message="银行交易流水号长度不能超过{max}位")
	private String SerialNo;//银行交易流水号,公共报文头取值
	@Size(max=32,message="银行子交易流水号长度不能超过{max}位")
	private String SubSerialNo;//银行子交易流水号,公共报文头取值
	@Size(max=8,message="交易日期长度不能超过{max}位")
	private String TransDate;//交易日期,格式：yyyyMMdd,公共报文头取值
	@Size(max=6,message="交易时间长度不能超过{max}位")
	private String TransTime;//交易时间,格式：HHmmss,公共报文头取值
	@Size(max=32,message="商户流水号长度不能超过{max}位")
	private String OrderNo;//商户流水号,公共报文头取值
	@Size(max=32,message="商户子流水号长度不能超过{max}位")
	private String SubOrderNo;//商户子流水号,公共报文头取值
	@Size(max=8,message="商户交易日期长度不能超过{max}位")
	private String OrderDate;//商户交易日期,格式：yyyyMMdd,公共报文头取值
	@Size(max=6,message="商户交易时间长度不能超过{max}位")
	private String OrderTime;//商户交易时间,格式：HHmmss,公共报文头取值
	@Size(max=32,message="资金账号长度不能超过{max}位")
	private String SubAcctNo;//资金账号
	@Size(max=2,message="交易类型长度不能超过{max}位")
	private String TransType;//交易类型,02-收费;03-结息;12-充值入金;13-提现出金;14-交易;15-退款;99-其它
	@Size(max=1,message="借贷类型长度不能超过{max}位")
	private String CdFlag;//借贷类型,C-贷;D-借
	@Size(max=16,message="交易金额长度不能超过{max}位")
	private BigDecimal Amount;//交易金额
	
	@JSONField(name="SerialNo")
	public String getSerialNo() {
		return SerialNo;
	}
	public void setSerialNo(String serialNo) {
		SerialNo = serialNo;
	}
	@JSONField(name="SubSerialNo")
	public String getSubSerialNo() {
		return SubSerialNo;
	}
	public void setSubSerialNo(String subSerialNo) {
		SubSerialNo = subSerialNo;
	}
	@JSONField(name="TransDate")
	public String getTransDate() {
		return TransDate;
	}
	public void setTransDate(String transDate) {
		TransDate = transDate;
	}
	@JSONField(name="TransTime")
	public String getTransTime() {
		return TransTime;
	}
	public void setTransTime(String transTime) {
		TransTime = transTime;
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
	@JSONField(name="OrderTime")
	public String getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}
	@JSONField(name="SubAcctNo")
	public String getSubAcctNo() {
		return SubAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
	}
	@JSONField(name="TransType")
	public String getTransType() {
		return TransType;
	}
	public void setTransType(String transType) {
		TransType = transType;
	}
	@JSONField(name="CdFlag")
	public String getCdFlag() {
		return CdFlag;
	}
	public void setCdFlag(String cdFlag) {
		CdFlag = cdFlag;
	}
	@JSONField(name="Amount")
	public BigDecimal getAmount() {
		return Amount;
	}
	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}

}
