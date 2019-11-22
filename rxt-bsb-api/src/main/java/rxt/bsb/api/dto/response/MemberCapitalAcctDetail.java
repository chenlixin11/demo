package rxt.bsb.api.dto.response;

import java.math.BigDecimal;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月29日 上午14:48:11
 *
 * @author <a href="mailto:zhanggaoqun@rokesoft.com">zgq</a>
 *
 * @Description:会员资金账户明细查询响应报文体
 */
public class MemberCapitalAcctDetail {
	private String SerialNo;//交易流水号
	private String SubSerialNo;//交易子流水号
	private String TransDate;//交易日期
	private String TransTime;//交易时间
	private String SubAcctNo;//资金账号
	private String SubAcctName;//资金户名
	private String TransType;//交易类型
	private String CdFlag;//借贷类型
	private BigDecimal Amount;//交易金额
	private BigDecimal RcvAmt;//收入金额
	private BigDecimal PayAmt;//支出金额
	private BigDecimal FeeAmt;//手续费
	private BigDecimal LastBalance;//上笔余额
	private BigDecimal CurrBalance;//当前余额
	private String OppAcctNo;//对方账号
	private String OppAcctName;//对方户名
	private String PostScript;//交易附言
	private String OrderNo;//商户流水号
	private String SubOrderNo;//商户子流水号
	private String OrderDate;//商户交易日期
	private String OrderTime;//商户交易时间
	public String getSerialNo() {
		return SerialNo;
	}
	public void setSerialNo(String serialNo) {
		SerialNo = serialNo;
	}
	public String getSubSerialNo() {
		return SubSerialNo;
	}
	public void setSubSerialNo(String subSerialNo) {
		SubSerialNo = subSerialNo;
	}
	public String getTransDate() {
		return TransDate;
	}
	public void setTransDate(String transDate) {
		TransDate = transDate;
	}
	public String getTransTime() {
		return TransTime;
	}
	public void setTransTime(String transTime) {
		TransTime = transTime;
	}
	public String getSubAcctNo() {
		return SubAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
	}
	public String getSubAcctName() {
		return SubAcctName;
	}
	public void setSubAcctName(String subAcctName) {
		SubAcctName = subAcctName;
	}
	public String getTransType() {
		return TransType;
	}
	public void setTransType(String transType) {
		TransType = transType;
	}
	public String getCdFlag() {
		return CdFlag;
	}
	public void setCdFlag(String cdFlag) {
		CdFlag = cdFlag;
	}
	public BigDecimal getAmount() {
		return Amount;
	}
	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}
	public BigDecimal getRcvAmt() {
		return RcvAmt;
	}
	public void setRcvAmt(BigDecimal rcvAmt) {
		RcvAmt = rcvAmt;
	}
	public BigDecimal getPayAmt() {
		return PayAmt;
	}
	public void setPayAmt(BigDecimal payAmt) {
		PayAmt = payAmt;
	}
	public BigDecimal getFeeAmt() {
		return FeeAmt;
	}
	public void setFeeAmt(BigDecimal feeAmt) {
		FeeAmt = feeAmt;
	}
	public BigDecimal getLastBalance() {
		return LastBalance;
	}
	public void setLastBalance(BigDecimal lastBalance) {
		LastBalance = lastBalance;
	}
	public BigDecimal getCurrBalance() {
		return CurrBalance;
	}
	public void setCurrBalance(BigDecimal currBalance) {
		CurrBalance = currBalance;
	}
	public String getOppAcctNo() {
		return OppAcctNo;
	}
	public void setOppAcctNo(String oppAcctNo) {
		OppAcctNo = oppAcctNo;
	}
	public String getOppAcctName() {
		return OppAcctName;
	}
	public void setOppAcctName(String oppAcctName) {
		OppAcctName = oppAcctName;
	}
	public String getPostScript() {
		return PostScript;
	}
	public void setPostScript(String postScript) {
		PostScript = postScript;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	public String getSubOrderNo() {
		return SubOrderNo;
	}
	public void setSubOrderNo(String subOrderNo) {
		SubOrderNo = subOrderNo;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public String getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}

}
