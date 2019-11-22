package rxt.bsb.api.dto.request.entity;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月28日 上午9:56:41
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description:企业开户响应报文实体
 */
public class NotifyOpenEnterpriseAcctEntity {

	private String subAcctNo;//资金账户
	private String subAcctNoStatus;//账号状态
	private String repayNo;//资金账户
	private String repayNoStatus;//账号状态
	private String dirPayNo;//资金账户
	private String dirPayNoStatus;//账号状态
	
	public String getSubAcctNo() {
		return subAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		this.subAcctNo = subAcctNo;
	}
	public String getSubAcctNoStatus() {
		return subAcctNoStatus;
	}
	public void setSubAcctNoStatus(String subAcctNoStatus) {
		this.subAcctNoStatus = subAcctNoStatus;
	}
	public String getRepayNo() {
		return repayNo;
	}
	public void setRepayNo(String repayNo) {
		this.repayNo = repayNo;
	}
	public String getRepayNoStatus() {
		return repayNoStatus;
	}
	public void setRepayNoStatus(String repayNoStatus) {
		this.repayNoStatus = repayNoStatus;
	}
	public String getDirPayNo() {
		return dirPayNo;
	}
	public void setDirPayNo(String dirPayNo) {
		this.dirPayNo = dirPayNo;
	}
	public String getDirPayNoStatus() {
		return dirPayNoStatus;
	}
	public void setDirPayNoStatus(String dirPayNoStatus) {
		this.dirPayNoStatus = dirPayNoStatus;
	}

}
