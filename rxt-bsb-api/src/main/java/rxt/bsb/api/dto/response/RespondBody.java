package rxt.bsb.api.dto.response;
/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月25日 上午10:40:19
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description:响应包
 */
public class RespondBody {

	private RespondHead  head;
	private String body;
	public RespondHead getHead() {
		return head;
	}
	public void setHead(RespondHead head) {
		this.head = head;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
