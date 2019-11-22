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
 * @createTime  2019年1月31日 上午10:09:01	
 *
 * @Description:	通用查询
 */
public class GeneralQueryReqDto implements Serializable{

	/**
	 * 序列化标记
	 */
	private static final long serialVersionUID = -2642708807235496260L;
	@Size(max=32,message="商户平台流水号长度不能超过{max}位")
	private String OrderNo;//商户平台流水号
	@JSONField(name="OrderNo")
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
}
