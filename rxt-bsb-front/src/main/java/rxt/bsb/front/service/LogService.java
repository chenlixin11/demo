package rxt.bsb.front.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rxt.bsb.front.dao.LogInterfaceinvokeDao;
import rxt.bsb.front.po.LogInterfaceinvokeWithBLOBs;
import utils.DateUtils;


@Service
public class LogService {
	@Autowired
	private LogInterfaceinvokeDao logInterfaceinvokeDao;

	/**
	 *
	 * @功能描述：保存业务日志表
	 * @developer：zhanggaoqun
	 * @date：2019年2月21日 上午10:37:55
	 * @param username
	 * @param businessName
	 * @param businessResult
	 * @return
	 * LogBusiness
	 */
	//public LogBusiness saveBusinessLog(String username, String businessName,
	//                                   String businessResult) {
	//	LogBusiness logBusiness = new LogBusiness();
	//	String businessLogId = SystemUtil.getUNID();
	//	logBusiness.setId(businessLogId);
	//	logBusiness.setUserId(username);
	//	logBusiness.setBusinessName(businessName);
	//	logBusiness.setBusinessResult(businessResult);
	//	logBusiness.setBusinessTime(DateUtils.getNowTime());
	//	logInterfaceinvokeMapper.save(logBusiness);
	//	return logBusiness;
	//}

	/**
	 *
	 * @功能描述：接口日志表
	 * @developer：zhanggaoqun
	 * @date：2019年2月21日 上午10:38:29
	 * @param businessId
	 * @param invocationResult
	 * void
	 */
	public void saveLogInterfaceInvoke(Integer businessId,String funCode,String funName,String sendPackage,String receivePackage,Integer invocationResult) {
		LogInterfaceinvokeWithBLOBs logInterfaceinvokeWithBLOBs = new LogInterfaceinvokeWithBLOBs();
		logInterfaceinvokeWithBLOBs.setBusinessId(businessId);
		logInterfaceinvokeWithBLOBs.setFunCode(funCode);//功能代码
		logInterfaceinvokeWithBLOBs.setFunName(funName);//功能名称
		logInterfaceinvokeWithBLOBs.setSendPackage(sendPackage);//发送报文
		logInterfaceinvokeWithBLOBs.setReceivePackage(receivePackage);//接收报文
		logInterfaceinvokeWithBLOBs.setInvokeTime(DateUtils.getNowTimeForDate());//接口调用时间
		logInterfaceinvokeWithBLOBs.setInvokeResult(invocationResult);//接口调用结果0-失败;1-成功
		logInterfaceinvokeDao.insert(logInterfaceinvokeWithBLOBs);
	}
}
