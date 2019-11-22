package rxt.bsb.api.dto.response;
/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月29日 上午14:40:04
 *
 * @author <a href="mailto:zhanggaoqun@rokesoft.com">zgq</a>
 *
 * @Description:商户请求流水结果查询响应报文
 */
public class QueryMerchantRequestSerialResultsRespBody {
	private String Status;//S--成功,F—失败,A—接收状态（初始化） 如果返回为空，说明该交易并未真实发生

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
