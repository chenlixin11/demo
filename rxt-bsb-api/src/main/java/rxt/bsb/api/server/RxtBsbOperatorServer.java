package rxt.bsb.api.server;

import constant.BankTransInfoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import rxt.bsb.api.dto.request.*;
import rxt.bsb.api.dto.request.credit.*;
import rxt.bsb.api.dto.request.entity.BatchPaymentReqDto;
import rxt.bsb.api.dto.request.notice.ContractSignReqDto;
import rxt.bsb.api.dto.request.query.*;
import rxt.bsb.api.dto.response.credit.*;
import rxt.bsb.api.dto.response.notice.ContractSignResDto;
import rxt.bsb.api.dto.response.notice.NotifyResultResDto;
import rxt.bsb.api.dto.response.query.*;
import vo.InterfaceRespVo;

@FeignClient("RXT-BSB-FRONT")
public interface RxtBsbOperatorServer {


    //@PostMapping("/open-acct")
    //String openAcct();

    /**
     * 会员账户信息修改
     */
    @PostMapping("/update-subacctno")
    InterfaceRespVo<NotifyResultResDto> updateSubacctno(UpdateSubAcctNoReqDto updateSubAcctNoReqDto);

    /**
     * 个人子账户开户
     */
    @PostMapping("/open-personal-acct")
    InterfaceRespVo<OpenPersonalAcctReqDto> openPersonalAcct(OpenPersonalAcctReqDto openPersonalAcctReqDto);

    /**
     * 企业子账户开户
     */
    @PostMapping("/open-enterprise-acct")
    InterfaceRespVo<OpenEnterpriseAcctReqDto> openEnterpriseAcct(OpenEnterpriseAcctReqDto openEnterpriseAcctReqDto);

    /**
     * 密码重置
     */
    @PostMapping("/reset-pwd")
    InterfaceRespVo<ResetPwdReqDto> resetPwd(ResetPwdReqDto resetPwdReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 修改手机号码
     */
    @PostMapping("/modify-mobile")
    InterfaceRespVo<ModifyMobileReqDto> modifyMobile(ModifyMobileReqDto modifyMobileReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 绑定银行卡
     */
    @PostMapping("/bind-acctNo")
    InterfaceRespVo<BindAcctNoReqDto> bindAcctNo(BindAcctNoReqDto bindAcctNoReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 解绑银行卡
     */
    @PostMapping("/unbind-acctNo")
    InterfaceRespVo<UnBindAcctNoReqDto> unbindAcctNo(UnBindAcctNoReqDto unBindAcctNoReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 个人充值
     */
    @PostMapping("/recharge-personal")
    InterfaceRespVo<RechargePersonalReqDto> rechargePersonal(RechargePersonalReqDto rechargePersonalReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 企业重置
     */
    @PostMapping("/recharge-enterprise")
    InterfaceRespVo<RechargeEnterpriseReqDto> rechargeEnterprise(RechargeEnterpriseReqDto rechargeEnterpriseReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 个人/企业提现
     */
    @PostMapping("/cashWithdrawal")
    InterfaceRespVo<CashWithdrawalReqDto> cashWithdrawal(CashWithdrawalReqDto cashWithdrawalReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 会员批量出金
     */
    @PostMapping("/batchPayment")
    InterfaceRespVo<BatchPaymentReqDto> batchPayment(BatchPaymentReqDto batchPaymentReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 商户提现
     */
    @PostMapping("/cashWithdrawal-merchant")
    InterfaceRespVo<CashWithdrawalMerchantReqDto> cashWithdrawalMerchant(CashWithdrawalMerchantReqDto cashWithdrawalMerchantReqDto, BankTransInfoEnum bankTransInfoEnum);


    //个人会员支付认证
    @PostMapping("/personPay-authentication")
    InterfaceRespVo<NotifyResultResDto> personPayAuthentication(PersonPayAuthenticationReqDto personPayAuthenticationReqDto);

    //个人会员代扣协议签约
    @PostMapping("/personMemberAgreementSign")
    InterfaceRespVo<NotifyResultResDto> personMemberAgreementSign(PersonPayAuthenticationReqDto personPayAuthenticationReqDto);

    /**
     * 线上首笔支付认证
     */
    @PostMapping("/firstPay-authentication")
    InterfaceRespVo<FirstPayAuthenticationReqDto> firstPayAuthentication(FirstPayAuthenticationReqDto firstPayAuthenticationReqDto);

    /**
     * 个人/企业订单单笔即时支付
     */
    @PostMapping("/single-order-payDown")
    InterfaceRespVo<SingleOrderPayDownReqDto> singleOrderPayDown(SingleOrderPayDownReqDto singleOrderPayDownReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 个人订单批量即时支付
     */
    @PostMapping("/personal-batchOrder-payDown")
    InterfaceRespVo<PersonalBatchOrderPayDownReqDto> personalBatchOrderPayDown(PersonalBatchOrderPayDownReqDto personalBatchOrderPayDownReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 企业订单批量即时支付
     */
    @PostMapping("/enterprise-batchOrder-payDown")
    InterfaceRespVo<EnterpriseBatchOrderPayDownReqDto> enterpriseBatchOrderPayDown(EnterpriseBatchOrderPayDownReqDto enterpriseBatchOrderPayDownReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 会员订单批量担保支付预付
     */
    @PostMapping("/order-batch-guarantee-prepayment")
    InterfaceRespVo<OrderBatchGuaranteePrepaymentReqDto> orderBatchGuaranteePrepayment(OrderBatchGuaranteePrepaymentReqDto orderBatchGuaranteePrepaymentReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 会员订单担保支付确认
     */
    @PostMapping("/order-guaranteed-payment-confirm")
    InterfaceRespVo<OrderGuaranteedPaymentConfirmReqDto> orderGuaranteedPaymentConfirm(OrderGuaranteedPaymentConfirmReqDto orderGuaranteedPaymentConfirmReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 会员订单单笔担保支付撤销
     */
    @PostMapping("/order-guaranteed-payment-revoke")
    InterfaceRespVo<OrderGuaranteedPaymentRevokeReqDto> orderGuaranteedPaymentRevoke(OrderGuaranteedPaymentRevokeReqDto orderGuaranteedPaymentRevokeReqDto, BankTransInfoEnum bankTransInfoEnum);


    /**
     * 会员订单加强型单笔即时支付
     */
    @PostMapping("/strong-single-orderpaydown")
    InterfaceRespVo<SingleOrderPayDownReqDto> strongSingleOrderPayDown(SingleOrderPayDownReqDto singleOrderPayDownReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 会员订单加强型批量担保支付预付
     */
    @PostMapping("/strong-order-batch-guarantee-prepayment")
    InterfaceRespVo<OrderBatchGuaranteePrepaymentReqDto> strongOrderBatchGuaranteePrepayment(OrderBatchGuaranteePrepaymentReqDto orderBatchGuaranteePrepaymentReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 会员订单加强型批量即时支付
     */
    @PostMapping("/strong-batch-orderpaydown")
    InterfaceRespVo<EnterpriseBatchOrderPayDownReqDto> strongBatchOrderPayDown(EnterpriseBatchOrderPayDownReqDto enterpriseBatchOrderPayDownReqDto , BankTransInfoEnum bankTransInfoEnum) ;

        /**
         * 企业开户Ukey绑定修改
         */
    @PostMapping("/enterprise-open-ukey-binding")
    InterfaceRespVo<AcctBindInfoQueryReqDto> enterpriseOpenUkeyBinding(AcctBindInfoQueryReqDto acctBindInfoQueryReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 商户资金账户信息查询
     * 商户资金账户余额查询
     * 商户资金账户白名单查询
     */
    @PostMapping("/buinessAcct-query")
    InterfaceRespVo<BuinessAcctQueryReqDto> buinessAcctQuery(BuinessAcctQueryReqDto buinessAcctQueryReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 商户资金账户明细查询
     */
    @PostMapping("/buinessAcct-detail-query")
    InterfaceRespVo<BuinessAcctDetailQueryReqDto> buinessAcctDetailQuery(BuinessAcctDetailQueryReqDto buinessAcctDetailQueryReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 会员资金账户绑定信息查询
     */
    @PostMapping("/acctBindInfo-query")
    InterfaceRespVo<AcctBindInfoQueryReqDto> acctBindInfoQuery(AcctBindInfoQueryReqDto acctBindInfoQueryReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 会员资金账户明细查询
     */
    @PostMapping("/acctDetail-query")
    InterfaceRespVo<AcctDetailQueryReqDto> acctDetailQuery(AcctDetailQueryReqDto acctDetailQueryReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 会员资金账户信息查询
     * 会员资金账户余额查询
     */
    @PostMapping("/acctInfo-query")
    InterfaceRespVo<AcctInfoQueryReqDto> acctInfoQuery(AcctInfoQueryReqDto acctInfoQueryReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 通用查询
     */
    @PostMapping("/general-query")
    InterfaceRespVo<GeneralQueryReqDto> generalQuery(GeneralQueryReqDto generalQueryReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 商户交易结果通知
     */
    @PostMapping("/buiness-transResult-notify")
    InterfaceRespVo<BuinessTransResultNotifyReqDto> buinessTransResultNotify(BuinessTransResultNotifyReqDto buinessTransResultNotifyReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 资金账户动账通知
     */
    @PostMapping("/acct-dynamic-notify")
    InterfaceRespVo<AcctDynamicNotifyReqDto> acctDynamicNotify(AcctDynamicNotifyReqDto acctDynamicNotifyReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 商户交易流水对账
     * 商户资金账户余额对账
     * 商户资金账户明细对账
     */
    @PostMapping("/business-transaction-flow-reconciliation")
    InterfaceRespVo<BusinessTransactionReqDto> businessTransactionFlowReconciliation(BusinessTransactionReqDto businessTransactionReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 商户文件下载
     *
     */
    @PostMapping("/business-document-download")
    InterfaceRespVo<BusinessDocumentReqDto> businessDocumentDownload(BusinessDocumentReqDto businessDocumentReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     *
     * 商户文件上传
     */
    @PostMapping("/business-document")
    InterfaceRespVo<BusinessDocumentReqDto> businessDocument(BusinessDocumentReqDto businessDocumentReqDto, BankTransInfoEnum bankTransInfoEnum);


    /**
     *
     * 回单查询
     */
    @PostMapping("/back-order-query")
    InterfaceRespVo<BackOrderQueryReqDto> backOrderQuery(BackOrderQueryReqDto backOrderQueryReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     *
     * 回单打印
     */
    @PostMapping("/back-order-prin")
    InterfaceRespVo<BackOrderPrinReqDto> backOrderPrin(BackOrderPrinReqDto backOrderPrinReqDto, BankTransInfoEnum bankTransInfoEnum);


    //======================================在线授信申请文档接口================================================

    /**
     * 3.1.1 授信申请接受（实时模式）
     */
    @PostMapping("/credit-apply-notify-time")
    InterfaceRespVo<CreditApplyResDto> creditApplyNotifyTime(CreditApplyReqDto creditApplyReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.1.2 在线授信申请的状态查询（实时模式）
     */
    @PostMapping("/credit-apply-state")
    InterfaceRespVo<CreditApplyStateResDto> creditApplyState(CreditApplyStateReqDto creditApplyStateReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.1.3 提款申请(实时模式)
     */
    @PostMapping("/withdrawal-apply-time")
    InterfaceRespVo<WithdrawalApplyResDto> withdrawalApplyTime(WithdrawalApplyReqDto withdrawalApplyReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.1.4 提款申请状态查询（实时模式）
     */
    @PostMapping("/withdrawal-apply-state")
    InterfaceRespVo<WithdrawalApplyStateResDto> withdrawalApplyState(WithdrawalApplyStateReqDto withdrawalApplyStateReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.1.5 商户资金账户利息试算（实时模式）
     */
    @PostMapping("/interest-trial")
    InterfaceRespVo<InterestTrialResDto> interestTrial(InterestTrialReqDto interestTrialReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.1.6 商户资金账户提前还款（实时模式）
     */
    @PostMapping("/early-repayment")
    InterfaceRespVo<EarlyRepaymentResDto> earlyRepayment(EarlyRepaymentReqDto earlyRepaymentReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.2.1 附件上传（实时模式）
     */
    @PostMapping("/upload-attachments")
    InterfaceRespVo<UploadAttachmentsResDto> uploadAttachments(UploadAttachmentsReqDto uploadAttachmentsReqDto);

    /**
     * 3.2.2 订单信息推送接口（实时模式）
     */
    @PostMapping("/order-push")
    InterfaceRespVo<OrderPushResDto> orderPush(OrderPushReqDto orderPushReqDto, BankTransInfoEnum bankTransInfoEnum);
//
//    /**
//     * 3.3.2 在线授信申请 确认 结果通知（实时模式）
//     */
//    @PostMapping("/online-credit-application-confirm")
//    InterfaceRespVo<NotifyResultResDto> onlineCreditApplicationConfirm(NotifyResultReqDto notifyReqDto, BankTransInfoEnum bankTransInfoEnum);
//
//    /**
//     * 3.3.3 在线授信申请 受理 结果通知（实时模式）
//     */
//    @PostMapping("/online-credit-application-accept")
//    InterfaceRespVo<NotifyResultResDto> onlineCreditApplicationAccept(NotifyResultReqDto notifyReqDto, BankTransInfoEnum bankTransInfoEnum);
//
//    /**
//     * 3.3.4 在线授信申请 审批 结果通知（实时模式）
//     */
//    @PostMapping("/online-credit-application-approval")
//    InterfaceRespVo<NotifyResultResDto> onlineCreditApplicationApproval(NotifyResultReqDto notifyReqDto, BankTransInfoEnum bankTransInfoEnum);
//
//    /**
//     * 3.3.5 在线 提款申请 确认 结果通知（实时模式）
//     */
//    @PostMapping("/online-withdrawal-application-confirm")
//    InterfaceRespVo<NotifyResultResDto> onlineWithdrawalApplicationConfirm(NotifyResultReqDto notifyReqDto, BankTransInfoEnum bankTransInfoEnum);
//
//    /**
//     * 3.3.6 在线 提款申请 受理 结果通知（实时模式）
//     */
//    @PostMapping("/online-withdrawal-application-accept")
//    InterfaceRespVo<NotifyResultResDto> onlineWithdrawalApplicationAccept(NotifyResultReqDto notifyReqDto, BankTransInfoEnum bankTransInfoEnum);
//
//    /**
//     * 3.3.7 合同签署 结果通知（实时模式）
//     */
//    @PostMapping("/contract-sign-result")
//    InterfaceRespVo<NotifyResultResDto> contractSignResult(NotifyResultReqDto notifyReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.4.1 贷款信息 查询（实时模式）
     */
    @PostMapping("/loan-information")
    InterfaceRespVo<LoanInformationResDto> loanInformation(LoanInformationReqDto loanInformationReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.4.2 还款计划详情 查询（实时模式）
     */
    @PostMapping("/payment-information")
    InterfaceRespVo<PaymentInformationResDto> paymentInformation(PaymentInformationReqDto paymentInformationReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.4.3 还款计划明细 查询（实时模式）
     */
    @PostMapping("/payment-detail-list")
    InterfaceRespVo<PaymentDetaileResDto> paymentDetailList(PaymentInformationReqDto paymentInformationReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.4.4 合同协议列表 查询（实时模式）
     */
    @PostMapping("/contract-agreement-list")
    InterfaceRespVo<ContractAgreementResDto> contractAgreementList(ContractAgreementReqDto contractAgreementReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.4.5 合同协议详情 查询（实时模式）
     */
    @PostMapping("/contract-agreement-detail")
    InterfaceRespVo<ContractAgreementDetailResDto> contractAgreementDetail(ContractAgreementDetailReqDto contractAgreementDetailReqDto);

    /**
     * 3.4.6 授信额度 查询（实时模式）
     */
    @PostMapping("/credit-line")
    InterfaceRespVo<CreditLineResDto> creditLine(CreditLineReqDto creditLineReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.4.7 还款结果 查询（实时模式）
     */
    @PostMapping("/repayment-result")
    InterfaceRespVo<RepaymentResultResDto> repaymentResult(RepaymentResultReqDto repaymentResultReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.4.8 项目信息 查询（实时模式）
     */
    @PostMapping("/project-info")
    InterfaceRespVo<ProjectInfoResDto> projectInfo(ProjectInfoReqDto projectInfoReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 3.4.9 模式 查询（实时模式）
     */
    @PostMapping("/pattern-query")
    InterfaceRespVo<PatternQueryResDto> patternQuery(PatternQueryReqDto patternQueryReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 4.1 授信申请接受
     */
    @PostMapping("/credit-apply-notify")
    InterfaceRespVo<CreditApplyResDto> creditApplyNotify(CreditApplyReqDto creditApplyReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 4.2 提款申请
     */
    @PostMapping("/withdrawal-apply")
    InterfaceRespVo<WithdrawalApplyResDto> withdrawalApply(WithdrawalApplyReqDto withdrawalApplyReqDto, BankTransInfoEnum bankTransInfoEnum);

    /**
     * 4.3 合同签署
     */
    @PostMapping("/contract-sign")
    InterfaceRespVo<ContractSignResDto> contractSign(ContractSignReqDto contractSignReqDto, BankTransInfoEnum bankTransInfoEnum);


}
