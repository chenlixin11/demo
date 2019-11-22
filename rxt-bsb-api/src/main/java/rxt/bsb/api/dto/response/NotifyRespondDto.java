package rxt.bsb.api.dto.response;

/**
 * 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2019年1月28日 上午11:26:55
 *
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 *
 * @Description:通知消息返回
 */
public class NotifyRespondDto {

	private NotifyRespondHead head;
	
	private NotifyRespondBody body;
	
	public NotifyRespondHead getHead() {
		return head;
	}
	public void setHead(NotifyRespondHead head) {
		this.head = head;
	}
	public NotifyRespondBody getBody() {
		return body;
	}
	public void setBody(NotifyRespondBody body) {
		this.body = body;
	}
}
