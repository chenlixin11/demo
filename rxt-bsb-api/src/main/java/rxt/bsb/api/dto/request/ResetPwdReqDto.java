package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月24日 下午6:26:23
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description:重置密码
 */
public class ResetPwdReqDto implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = 3977453002470397662L;
	@Size(max=32,message="资金账号长度不能超过{max}位")
	private String SubAcctNo ;//资金账号

	@JSONField(name="SubAcctNo")
	public String getSubAcctNo() {
		return SubAcctNo;
	}

	public void setSubAcctNo(String subAcctNo) {
		SubAcctNo = subAcctNo;
	}
	
}
