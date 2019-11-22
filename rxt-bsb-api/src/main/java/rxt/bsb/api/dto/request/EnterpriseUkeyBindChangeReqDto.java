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
 * @createTime  2019年1月30日 上午11:49:28	
 *
 * @Description:	企业开户Ukey绑定修改
 */
public class EnterpriseUkeyBindChangeReqDto implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = 7995241332921781505L;
	@Size(max=32,message="资金账号长度不能超过{max}位")
	private String SubAcctNo;//资金账号

	@JSONField(name="SubAcctNo")
	public String getSubAcctNo() {
		return SubAcctNo;
	}
	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
	}
}
