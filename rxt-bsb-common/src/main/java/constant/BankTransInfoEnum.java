package constant;


/**
 * @author <a href="mailto:changguangwei@rokesoft.com">cgw</a>
 * @Copyright (c)</ b> 2012融信通-版权所有<br/>
 * @createTime 2019年1月28日 下午3:54:37
 * @Description:交易对应的交易码以及对应的返回地址
 */
public enum BankTransInfoEnum {

    个人开户("030503C301", "receiveOpenAcctResultServlet", "www.baidu.com"),
    企业开户("030503C303", "receiveOpenEnterpriseAcctResultServlet", "www.baidu.com"),
    个人密码重置("030503C318", "resetPwdResultServlet", "www.baidu.com"),
    企业密码重置("030503C319", "enterpriseResetPwdResultServlet", "www.baidu.com"),
    个人手机号码修改("030503C322", "modifyPersonMobileResultServlet", "www.baidu.com"),
    企业手机号码修改("030503C323", "modifyEnterpriseMobileResultServlet", "www.baidu.com"),
    会员账户信息修改("030503C305","receiveUpdateSubAcctNoServlet","www.baidu.com"),
    首笔支付认证("030503B657", "firstPayAuthenticationResultServlet", "www.baidu.com"),
    个人会员支付认证("030503B658", "personPayAuthenticationResultServlet", "www.baidu.com"),
    个人会员银行卡绑定("030503C935", "receivePersonalBindAcctResultServlet", "www.baidu.com"),
    个人会员代扣协议签约("030503C947", "personMemberAgreementSignResultServlet", "www.baidu.com"),
    企业会员结算账户绑定("030503C936", "receiveEnterpriseBindAcctResultServlet", "www.baidu.com"),
    个人会员银行卡解绑("030503C937", "receivePersonalUnBindAcctResultServlet", "www.baidu.com"),
    企业会员结算账户解绑("030503C938", "receiveEnterpriseUnBindAcctResultServlet", "www.baidu.com"),
    个人会员资金账户线上转账充值入金("030503B655", "receiveRechargePersonalResultServlet", "www.baidu.com"),
    企业会员资金账户线上转账充值入金("030503B656", "receiveRechargeEnterpriseResultServlet", "www.baidu.com"),
    个人会员资金账户提现出金("030503B348", "receiveCashWithdrawalPersonalResultServlet", "www.baidu.com"),
    企业会员资金账户提现出金("030503B349", "receiveCashWithdrawalEnterpriseResultServlet", "www.baidu.com"),
    会员批量出金("030503B939", "batchPaymentResultServlet", "www.baidu.com"),
    商户资金账户提现出金("030503B926", "receiveCashWithdrawalMerchantResultServlet", "www.baidu.com"),
    个人订单单笔即时支付("030503B801", "singleOrderPayDownResultServlet", "www.baidu.com"),
    个人订单批量即时支付("030503B934", "batchOrderPayDownResultServlet", "www.baidu.com"),
    企业订单单笔即时支付("030503B802", "enterpriseSingleOrderPayDownResultServlet", "www.baidu.com"),
    企业订单批量即时支付("030503B818", "enterpriseBatchOrderPayDownResultServlet", "www.baidu.com"),
    会员订单批量担保支付预付("030503B804", "receiveOrderBatchGuaranteePrepaymentResultServlet", "www.baidu.com"),
    会员订单担保支付确认("030503B807", "receiveOrderGuaranteedPaymentConfirmResultServlet", "www.baidu.com"),
    会员订单担保支付撤销("030503B809", "", "www.baidu.com"),
    会员订单加强型单笔即时支付("030503B821", "receiveStrongSingleOrderPayDownResultServlet", "www.baidu.com"),
    会员订单加强型批量担保支付预付("030503B822", "receiveStrongOrderBatchGuaranteePrepaymentResultServlet", "www.baidu.com"),
    会员订单加强型批量即时支付("030503B823", "receiveStrongBatchOrderPayDownResultServlet", "www.baidu.com"),
    企业开户Ukey绑定修改("030503C345", "enterpriseOpenUkeyBindingResultServlet", "www.baidu.com"),
    商户资金账户信息查询("030503A048", "", "www.baidu.com"),
    商户资金账户余额查询("030503A054", "", "www.baidu.com"),
    商户资金账户明细查询("030503A057", "", "www.baidu.com"),
    商户资金账户白名单查询("030503A079", "", "www.baidu.com"),
    会员资金账户绑定信息查询("030503A312", "", "www.baidu.com"),
    会员资金账户明细查询("030503A314", "", "www.baidu.com"),
    会员资金账户信息查询("030503A324", "", "www.baidu.com"),
    会员资金账户余额查询("030503A313", "", "www.baidu.com"),
    通用查询("030503A940", "", "www.baidu.com"),
    商户交易结果通知("030503B998", "merchantTransactionsResultServlet", "www.baidu.com"),
    资金账户动账通知("030503B999", "capitalAccountMovementResultServlet", "www.baidu.com"),
    商户交易流水对账("030503A628", "", "www.baidu.com"),
    商户资金账户余额对账("030503A626", "", "www.baidu.com"),
    商户资金账户明细对账("030503A627", "", "www.baidu.com"),
    商户文件下载("030503A668", "", "www.baidu.com"),
    商户文件上传("030503A669", "", "www.baidu.com"),
    回单查询("031203A212", "", "www.baidu.com"),
    回单打印("031203C205", "", "www.baidu.com"),


    //在线授信申请文档的 功能代码枚举
    授信申请接受_实时模式("031203C118", "", "www.baidu.com"),
    在线授信申请的状态查询("031203A120", "", "www.baidu.com"),
    提款申请_实时模式("031203C422", "", "www.baidu.com"),
    提款申请状态查询("031203A424", "", "www.baidu.com"),
    商户资金账户利息试算("031203A419", "", "www.baidu.com"),
    商户资金账户提前还款("031203C112", "", "www.baidu.com"),
    附件上传("031203C179", "", "www.baidu.com"),
    订单信息推送接口("030503C500", "", "www.baidu.com"),
    在线授信申请确认结果通知("031203C118", "onlineCreditApplicationConfirmResultServlet", "www.baidu.com"),
    在线授信申请受理结果通知("031200C119", "onlineCreditApplicationAcceptResultServlet", "www.baidu.com"),
    在线授信申请审批结果通知("031203A125", "onlineCreditApplicationApprovalResultServlet", "www.baidu.com"),
    在线提款申请确认结果通知("031203C121", "onlineWithdrawalApplicationConfirmResultServlet", "www.baidu.com"),
    在线提款申请受理结果通知("031203C061", "onlineWithdrawalApplicationAcceptResultServlet", "www.baidu.com"),
    合同签署结果通知("031203C304", "contractSignResultServlet", "www.baidu.com"),
    贷款信息查询("031203A414", "", "www.baidu.com"),
    还款计划详情查询("031203A415", "", "www.baidu.com"),
    还款计划明细查询("031203A416", "", "www.baidu.com"),
    合同协议列表查询("031203A274", "", "www.baidu.com"),
    合同协议详情查询("031203A210", "", "www.baidu.com"),
    授信额度查询("031203A147", "", "www.baidu.com"),
    还款结果查询("031203A418", "", "www.baidu.com"),
    项目信息查询("031203A266", "", "www.baidu.com"),
    模式查询("031203A421", "", "www.baidu.com"),
    授信申请接受("031203C469", "onlineCreditApplicationConfirmResultServlet", "www.baidu.com"),
    提款申请("031203C121", "onlineWithdrawalApplicationConfirmResultServlet", "www.baidu.com"),
    合同签署("031203C304", "contractSignResultServlet", "www.baidu.com");

    private String transCode = null;  //功能代码
    private String receiveNotifyUrl = null;  //商户通知回调URL 银行实时或网关页面交易完成之后自动向此 URL发送交易结果通知
    private String tradeBackUrl = null;  //商户页面回调URL  银行网关页面交易完成之后自动回调此 URL 返回商户平台页面

    private BankTransInfoEnum(String transCode, String receiveNotifyUrl, String tradeBackUrl) {
        this.transCode = transCode;
        this.receiveNotifyUrl = receiveNotifyUrl;
        this.tradeBackUrl = tradeBackUrl;
    }

    public String getTransCode() {
        return transCode;
    }

    public String getReceiveNotifyUrl() {
        return receiveNotifyUrl;
    }

    public String getTradeBackUrl() {
        return tradeBackUrl;
    }

}
