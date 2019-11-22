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
 * @createTime  2019年1月30日 下午5:35:50	
 *
 * @Description:	会员资金账户绑定信息查询
 */
public class AcctBindInfoQueryReqDto implements Serializable{


	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = 855958910427716852L;
	@NotBlank(message="资金账号不能空")
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
