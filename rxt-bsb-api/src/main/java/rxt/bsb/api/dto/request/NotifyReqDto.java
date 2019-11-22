package rxt.bsb.api.dto.request;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月28日 上午10:02:30
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description: 通知请求报文
 */
public class NotifyReqDto {

	private NotifyReqHead head;
	
	private NotifyReqBody body;
	
	public NotifyReqHead getHead() {
		return head;
	}
	public void setHead(NotifyReqHead head) {
		this.head = head;
	}
	public NotifyReqBody getBody() {
		return body;
	}
	public void setBody(NotifyReqBody body) {
		this.body = body;
	}
	
}
