package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月24日 上午10:29:40
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description:商户资金账户信息查询
 */
public class QueryTradeAcctInfoReqDto implements Serializable{
	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = -2247298526259452246L;
	@Size(max=32,message="资金账号长度不能超过{max}位")
	private String SubAcctNo;//资金账号
	@Size(max=1,message="文件标志长度不能超过{max}位")
	private String FileFlag;//文件标志,0-分页模式;1-文件模式(暂未实现)
	@Size(max=10,message="页码长度不能超过{max}位")
	private String PageId;//页码,分页模式有效
	@Size(max=10,message="每页记录数长度不能超过{max}位")
	private String PageSize;//每页记录数,每页记录数最大 100 条,分页模式有效
	
	@JSONField(name="SubAcctNo")
	public String getSubAcctNo() {
		return SubAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
	}
	@JSONField(name="FileFlag")
	public String getFileFlag() {
		return FileFlag;
	}
	public void setFileFlag(String fileFlag) {
		FileFlag = fileFlag;
	}
	@JSONField(name="PageId")
	public String getPageId() {
		return PageId;
	}
	public void setPageId(String pageId) {
		PageId = pageId;
	}
	@JSONField(name="PageSize")
	public String getPageSize() {
		return PageSize;
	}
	public void setPageSize(String pageSize) {
		PageSize = pageSize;
	}
	
}
