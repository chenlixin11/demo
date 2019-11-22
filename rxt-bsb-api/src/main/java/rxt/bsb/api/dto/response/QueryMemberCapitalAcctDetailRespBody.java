package rxt.bsb.api.dto.response;

import java.util.List;

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
public class QueryMemberCapitalAcctDetailRespBody {
	private String FileFlag;//文件标志0-分页模式,1-文件模式(暂未实现)
	private Integer PageId;//页码
	private Integer PageSize;//每页记录数
	private Integer PageSum;//总页数
	private Integer RecordNum;//总记录数
	private Integer FieldNum;//文件字段数
	private String FileName;//文件名称
	private List<MemberCapitalAcctDetail> Detail;//资金账户明细集合
	public String getFileFlag() {
		return FileFlag;
	}
	public void setFileFlag(String fileFlag) {
		FileFlag = fileFlag;
	}
	public Integer getPageId() {
		return PageId;
	}
	public void setPageId(Integer pageId) {
		PageId = pageId;
	}
	public Integer getPageSize() {
		return PageSize;
	}
	public void setPageSize(Integer pageSize) {
		PageSize = pageSize;
	}
	public Integer getPageSum() {
		return PageSum;
	}
	public void setPageSum(Integer pageSum) {
		PageSum = pageSum;
	}
	public Integer getRecordNum() {
		return RecordNum;
	}
	public void setRecordNum(Integer recordNum) {
		RecordNum = recordNum;
	}
	public Integer getFieldNum() {
		return FieldNum;
	}
	public void setFieldNum(Integer fieldNum) {
		FieldNum = fieldNum;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public List<MemberCapitalAcctDetail> getDetail() {
		return Detail;
	}
	public void setDetail(List<MemberCapitalAcctDetail> detail) {
		Detail = detail;
	}
}
