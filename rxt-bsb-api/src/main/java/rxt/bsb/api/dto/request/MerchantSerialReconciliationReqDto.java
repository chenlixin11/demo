package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月29日 上午14:40:04
 *
 * @author <a href="mailto:zhanggaoqun@rokesoft.com">zgq</a>
 *
 * @Description:商户交易流水对账
 */
public class MerchantSerialReconciliationReqDto implements Serializable {

	private static final long serialVersionUID = -1186092862862811826L;
	@NotBlank(message="对账日期不能空")
	@Size(max=8,message="对账日期长度不能超过{max}位")
	private String CheckDate;//对账日期
	
	@JSONField(name="CheckDate")
	public String getCheckDate() {
		return CheckDate;
	}

	public void setCheckDate(String checkDate) {
		CheckDate = checkDate;
	}
}
