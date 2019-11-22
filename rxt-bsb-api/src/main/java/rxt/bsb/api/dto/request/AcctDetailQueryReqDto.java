package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 *
 * @createTime  2019年1月30日 下午5:42:49	
 *
 * @Description:	会员资金账户明细查询
 */
public class AcctDetailQueryReqDto implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = -3356410674079193558L;
	@NotBlank(message="起始日期不能空")
	@Size(max=8,message="起始日期长度不能超过{max}位")
	private String StartDate;//起始日期,格式：yyyyMMdd,银行交易起止日期时间段不能大于 90 天
	@NotBlank(message="截止日期不能空")
	@Size(max=8,message="截止日期长度不能超过{max}位")
	private String EndDate;//截止日期,格式：yyyyMMdd,银行交易起止日期时间段不能大于 90 天
	@Size(max=32,message="会员资金账号长度不能超过{max}位")
	private String SubAcctNo;//会员资金账号
	@Size(max=32,message="银行交易流水号长度不能超过{max}位")
	private String SerialNo;//银行交易流水号
	@Size(max=32,message="银行交易子流水号长度不能超过{max}位")
	private String SubSerialNo;//银行交易子流水号
	@Size(max=32,message="商户流水号或订单号长度不能超过{max}位")
	private String OrderNo;//商户流水号或订单号
	@Size(max=32,message="商户子流水号或子订单号长度不能超过{max}位")
	private String SubOrderNo;//商户子流水号或子订单号
	@Size(max=8,message="商户交易起始日期长度不能超过{max}位")
	private String OrderStartDate;//商户交易起始日期,格式：yyyyMMdd,商户交易起止日期时间段不能大于 90 天
	@Size(max=8,message="商户交易截止日期长度不能超过{max}位")
	private String OrderEndDate;//商户交易截止日期,格式：yyyyMMdd,商户交易起止日期时间段不能大于 90 天
	@NotBlank(message="文件标志不能空")
	@Size(max=1,message="文件标志长度不能超过{max}位")
	private String FileFlag;//文件标志,0-分页模式,1-文件模式（暂未实现）
	private Integer PageId;//页码，第几页，分页模式有效
	private Integer PageSize;//每页记录数，每页记录数最大 100 条，分页模式有效
	
	@JSONField(name="StartDate")
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	@JSONField(name="EndDate")
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	@JSONField(name="SubAcctNo")
	public String getSubAcctNo() {
		return SubAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
	}
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
	@JSONField(name="OrderStartDate")
	public String getOrderStartDate() {
		return OrderStartDate;
	}
	public void setOrderStartDate(String orderStartDate) {
		OrderStartDate = orderStartDate;
	}
	@JSONField(name="OrderEndDate")
	public String getOrderEndDate() {
		return OrderEndDate;
	}
	public void setOrderEndDate(String orderEndDate) {
		OrderEndDate = orderEndDate;
	}
	@JSONField(name="FileFlag")
	public String getFileFlag() {
		return FileFlag;
	}
	public void setFileFlag(String fileFlag) {
		FileFlag = fileFlag;
	}
	@JSONField(name="PageId")
	public Integer getPageId() {
		return PageId;
	}
	public void setPageId(Integer pageId) {
		PageId = pageId;
	}
	@JSONField(name="PageSize")
	public Integer getPageSize() {
		return PageSize;
	}
	public void setPageSize(Integer pageSize) {
		PageSize = pageSize;
	}
	
}
