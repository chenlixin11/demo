package rxt.bsb.api.dto.response;
/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月29日 上午14:40:04
 *
 * @author <a href="mailto:zhanggaoqun@rokesoft.com">zgq</a>
 *
 * @Description:商户交易流水对账响应报文
 */
public class MerchantSerialReconciliationRespBody {
	private String FileName;//文件名
	private Integer RecordNum;//记录数
	private Integer FieldNum;//字段数
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
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
}
