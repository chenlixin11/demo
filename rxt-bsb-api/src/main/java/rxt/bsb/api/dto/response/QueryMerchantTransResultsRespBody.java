package rxt.bsb.api.dto.response;
/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月29日 上午14:40:04
 *
 * @author <a href="mailto:zhanggaoqun@rokesoft.com">zgq</a>
 *
 * @Description:商户交易结果查证响应报文
 */
public class QueryMerchantTransResultsRespBody {
	private String SerialNo;//交易流水号
	private String SubSerialNo;//交易子流水号
	private String TransDate;//交易日期
	private String TransTime;//交易时间
	private String OrderNo;//商户流水号
	private String SubOrderNo;//商户子流水号
	private String OrderDate;//商户交易日期
	private String OrderTime;//商户交易时间
	private String TransStatus;//交易状态
	private String Amount;//交易金额
	private String RealAmt;//会员提现金额
	private String SalaryAmt;//商户佣金金额
	private String FeeAmt;//银行手续费
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
	public String getTransStatus() {
		return TransStatus;
	}
	public void setTransStatus(String transStatus) {
		TransStatus = transStatus;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getRealAmt() {
		return RealAmt;
	}
	public void setRealAmt(String realAmt) {
		RealAmt = realAmt;
	}
	public String getSalaryAmt() {
		return SalaryAmt;
	}
	public void setSalaryAmt(String salaryAmt) {
		SalaryAmt = salaryAmt;
	}
	public String getFeeAmt() {
		return FeeAmt;
	}
	public void setFeeAmt(String feeAmt) {
		FeeAmt = feeAmt;
	}
}
