package rxt.bsb.front.server;

import com.alibaba.fastjson.JSONObject;
import com.hundsun.tbsp.adapter.suite.cipher.client.EncrAndDecryptForClient;
import constant.BankTransInfoEnum;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rxt.bsb.api.constant.BankReturnCode;
import rxt.bsb.api.constant.ChancelConfigConstant;
import rxt.bsb.api.constant.UrlConstant;
import rxt.bsb.api.dto.request.*;
import rxt.bsb.api.dto.request.credit.*;
import rxt.bsb.api.dto.request.entity.BatchPaymentReqDto;
import rxt.bsb.api.dto.request.notice.ContractSignReqDto;
import rxt.bsb.api.dto.request.query.*;
import rxt.bsb.api.dto.response.BusinessFileDownloadResDto;
import rxt.bsb.api.dto.response.RespondBody;
import rxt.bsb.api.dto.response.RespondHead;
import rxt.bsb.api.dto.response.credit.*;
import rxt.bsb.api.dto.response.notice.ContractSignResDto;
import rxt.bsb.api.dto.response.notice.NotifyResultResDto;
import rxt.bsb.api.dto.response.query.*;
import rxt.bsb.api.server.RxtBsbOperatorServer;
import rxt.bsb.front.service.LogService;
import utils.AnnotationValidate;
import utils.BeanValidator;
import utils.DateUtils;
import utils.HttpPostJsonUtils;
import vo.InterfaceRespVo;

/**
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 * @Copyright (c)</ b> 2012融信通-版权所有<br/>
 * @createTime: 2019/9/17 14:42
 * @Description:
 */
@RestController
public class RxtBsbOperatorServerImp implements RxtBsbOperatorServer {

    @Autowired
    private LogService logService;

    /**
     * 会员账户信息修改
     */
    @PostMapping("/update-subacctno")
    @Override
    public InterfaceRespVo<NotifyResultResDto> updateSubacctno(UpdateSubAcctNoReqDto updateSubAcctNoReqDto) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(updateSubAcctNoReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, BankTransInfoEnum.个人开户);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", updateSubAcctNoReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答报文原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("会员账户信息修改的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;

            }
            interfaceRespVo.setResult(invocationResult);
            interfaceRespVo.setObject(respondBody);
            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.会员账户信息修改.getTransCode(),
                    "会员账户信息修改", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 个人子账户开户
     */
    @PostMapping("/open-personal-acct")
    @Override
    public InterfaceRespVo<OpenPersonalAcctReqDto> openPersonalAcct(OpenPersonalAcctReqDto openPersonalAcctReqDto) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(openPersonalAcctReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, BankTransInfoEnum.个人开户);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", openPersonalAcctReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答报文原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("用户确认信息的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;

            }
            interfaceRespVo.setResult(invocationResult);
            interfaceRespVo.setObject(respondBody);
            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人开户.getTransCode(),
                    "个人开户", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 企业子账户开户
     */
    @PostMapping("/open-enterprise-acct")
    @Override
    public InterfaceRespVo<OpenEnterpriseAcctReqDto> openEnterpriseAcct(OpenEnterpriseAcctReqDto openEnterpriseAcctReqDto) {

        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(openEnterpriseAcctReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, BankTransInfoEnum.企业开户);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", openEnterpriseAcctReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("企业会员资金账户开户的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.企业开户.getTransCode(), "企业开户",
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 密码重置
     */
    @PostMapping("/reset-pwd")
    @Override
    public InterfaceRespVo<ResetPwdReqDto> resetPwd(ResetPwdReqDto resetPwdReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(resetPwdReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", resetPwdReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("修改密码的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);

        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 修改手机号码
     */
    @PostMapping("/modify-mobile")
    @Override
    public InterfaceRespVo<ModifyMobileReqDto> modifyMobile(ModifyMobileReqDto modifyMobileReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(modifyMobileReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", modifyMobileReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("修改手机号的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 绑定银行卡
     */
    @PostMapping("/bind-acctNo")
    @Override
    public InterfaceRespVo<BindAcctNoReqDto> bindAcctNo(BindAcctNoReqDto bindAcctNoReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(bindAcctNoReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", bindAcctNoReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("绑定银行卡的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 解绑银行卡
     */
    @PostMapping("/unbind-acctNo")
    @Override
    public InterfaceRespVo<UnBindAcctNoReqDto> unbindAcctNo(UnBindAcctNoReqDto unBindAcctNoReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(unBindAcctNoReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", unBindAcctNoReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("解绑银行卡的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 个人充值
     */
    @PostMapping("/recharge-personal")
    @Override
    public InterfaceRespVo<RechargePersonalReqDto> rechargePersonal(RechargePersonalReqDto rechargePersonalReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(rechargePersonalReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", rechargePersonalReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("个人充值的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 企业充值
     */
    @PostMapping("/recharge-enterprise")
    @Override
    public InterfaceRespVo<RechargeEnterpriseReqDto> rechargeEnterprise(RechargeEnterpriseReqDto rechargeEnterpriseReqDto,
                                                                        BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(rechargeEnterpriseReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", rechargeEnterpriseReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("企业充值的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 个人/企业提现
     */
    @PostMapping("/cashWithdrawal")
    @Override
    public InterfaceRespVo<CashWithdrawalReqDto> cashWithdrawal(CashWithdrawalReqDto cashWithdrawalReqDto,
                                                                BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(cashWithdrawalReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", cashWithdrawalReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("个人/企业提现的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 会员批量出金
     *
     * @param batchPaymentReqDto
     * @param bankTransInfoEnum
     * @return
     */
    @Override
    @PostMapping("/batchPayment")
    public InterfaceRespVo<BatchPaymentReqDto> batchPayment(BatchPaymentReqDto batchPaymentReqDto,
                                                            BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(batchPaymentReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, BankTransInfoEnum.会员批量出金);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", batchPaymentReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答报文原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("会员批量出金的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;

            }
            interfaceRespVo.setResult(invocationResult);
            interfaceRespVo.setObject(respondBody);
            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.会员批量出金.getTransCode(),
                    "会员批量出金", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("会员批量出金接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 商户提现
     */
    @PostMapping("/cashWithdrawal-merchant")
    @Override
    public InterfaceRespVo<CashWithdrawalMerchantReqDto> cashWithdrawalMerchant(
            CashWithdrawalMerchantReqDto cashWithdrawalMerchantReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(cashWithdrawalMerchantReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", cashWithdrawalMerchantReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("商户提现的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }


    //个人会员支付认证
    @PostMapping("/personPay-authentication")
    @Override
    public InterfaceRespVo<NotifyResultResDto> personPayAuthentication(PersonPayAuthenticationReqDto personPayAuthenticationReqDto) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(personPayAuthenticationReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, BankTransInfoEnum.个人会员支付认证);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", personPayAuthenticationReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("个人支付认证的url：" + authURL + "?AuthTokenID=" + authTokenID);

            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人会员支付认证.getTransCode(),
                    "个人会员支付认证", req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }


    //个人会员代扣协议签约
    @PostMapping("/personMemberAgreementSign")
    @Override
    public InterfaceRespVo<NotifyResultResDto> personMemberAgreementSign(
            PersonPayAuthenticationReqDto personPayAuthenticationReqDto) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(personPayAuthenticationReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, BankTransInfoEnum.个人会员代扣协议签约);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", personPayAuthenticationReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("个人会员代扣协议签约的url：" + authURL + "?AuthTokenID=" + authTokenID);

            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人会员代扣协议签约.getTransCode(),
                    "个人会员代扣协议签约", req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }


    /**
     * 线上首笔支付认证
     */
    @PostMapping("/firstPay-authentication")
    @Override
    public InterfaceRespVo<FirstPayAuthenticationReqDto> firstPayAuthentication(
            FirstPayAuthenticationReqDto firstPayAuthenticationReqDto) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(firstPayAuthenticationReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, BankTransInfoEnum.首笔支付认证);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", firstPayAuthenticationReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("首笔支付认证的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.首笔支付认证.getTransCode(), "首笔支付认证",
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 个人/企业订单单笔即时支付
     */
    @PostMapping("/single-order-payDown")
    @Override
    public InterfaceRespVo<SingleOrderPayDownReqDto> singleOrderPayDown(
            SingleOrderPayDownReqDto singleOrderPayDownReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(singleOrderPayDownReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", singleOrderPayDownReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("个人/企业订单单笔即时支付的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 个人订单批量即时支付
     */
    @PostMapping("/personal-batchOrder-payDown")
    @Override
    public InterfaceRespVo<PersonalBatchOrderPayDownReqDto> personalBatchOrderPayDown(
            PersonalBatchOrderPayDownReqDto personalBatchOrderPayDownReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(personalBatchOrderPayDownReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", personalBatchOrderPayDownReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("个人订单批量即时支付的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 企业订单批量即时支付
     */
    @PostMapping("/enterprise-batchOrder-payDown")
    @Override
    public InterfaceRespVo<EnterpriseBatchOrderPayDownReqDto> enterpriseBatchOrderPayDown(
            EnterpriseBatchOrderPayDownReqDto enterpriseBatchOrderPayDownReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(enterpriseBatchOrderPayDownReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", enterpriseBatchOrderPayDownReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("企业订单批量即时支付的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 会员订单批量担保支付预付
     */
    @PostMapping("/order-batch-guarantee-prepayment")
    @Override
    public InterfaceRespVo<OrderBatchGuaranteePrepaymentReqDto> orderBatchGuaranteePrepayment(
            OrderBatchGuaranteePrepaymentReqDto orderBatchGuaranteePrepaymentReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(orderBatchGuaranteePrepaymentReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", orderBatchGuaranteePrepaymentReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("会员订单批量担保支付预付的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 会员订单担保支付确认
     */
    @PostMapping("/order-guaranteed-payment-confirm")
    @Override
    public InterfaceRespVo<OrderGuaranteedPaymentConfirmReqDto> orderGuaranteedPaymentConfirm(OrderGuaranteedPaymentConfirmReqDto orderGuaranteedPaymentConfirmReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(orderGuaranteedPaymentConfirmReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", orderGuaranteedPaymentConfirmReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("会员订单担保支付确认的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 会员订单单笔担保支付撤销
     */
    @PostMapping("/order-guaranteed-payment-revoke")
    @Override
    public InterfaceRespVo<OrderGuaranteedPaymentRevokeReqDto> orderGuaranteedPaymentRevoke(
            OrderGuaranteedPaymentRevokeReqDto orderGuaranteedPaymentRevokeReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(orderGuaranteedPaymentRevokeReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", orderGuaranteedPaymentRevokeReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("会员订单单笔担保支付撤销的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 会员订单加强型单笔即时支付
     */
    @PostMapping("/strong-single-orderpaydown")
    @Override
    public InterfaceRespVo<SingleOrderPayDownReqDto> strongSingleOrderPayDown(
            SingleOrderPayDownReqDto singleOrderPayDownReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(singleOrderPayDownReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", singleOrderPayDownReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("会员订单加强型单笔即时支付的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("会员订单加强型单笔即时支付接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 会员订单加强型批量担保支付预付
     */
    @PostMapping("/strong-order-batch-guarantee-prepayment")
    @Override
    public InterfaceRespVo<OrderBatchGuaranteePrepaymentReqDto> strongOrderBatchGuaranteePrepayment(
            OrderBatchGuaranteePrepaymentReqDto orderBatchGuaranteePrepaymentReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(orderBatchGuaranteePrepaymentReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", orderBatchGuaranteePrepaymentReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("会员订单加强型批量担保支付预付的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("会员订单加强型批量担保支付预付接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 会员订单加强型批量即时支付
     */
    @PostMapping("/strong-batch-orderpaydown")
    @Override
    public InterfaceRespVo<EnterpriseBatchOrderPayDownReqDto> strongBatchOrderPayDown(
            EnterpriseBatchOrderPayDownReqDto enterpriseBatchOrderPayDownReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(enterpriseBatchOrderPayDownReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", enterpriseBatchOrderPayDownReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("会员订单加强型批量即时支付的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("会员订单加强型批量即时支付接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 企业开户Ukey绑定修改
     *
     * @param acctBindInfoQueryReqDto
     * @param bankTransInfoEnum
     * @return
     */
    @PostMapping("/enterprise-open-ukey-binding")
    @Override
    public InterfaceRespVo<AcctBindInfoQueryReqDto> enterpriseOpenUkeyBinding(
            AcctBindInfoQueryReqDto acctBindInfoQueryReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(acctBindInfoQueryReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", acctBindInfoQueryReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("企业开户Ukey绑定修改的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 商户资金账户信息查询
     * 商户资金账户余额查询
     * 商户资金账户白名单查询
     */
    @PostMapping("/buinessAcct-query")
    @Override
    public InterfaceRespVo<BuinessAcctQueryReqDto> buinessAcctQuery(BuinessAcctQueryReqDto buinessAcctQueryReqDto,
                                                                    BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(buinessAcctQueryReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", buinessAcctQueryReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }
            interfaceRespVo.setResult(invocationResult);
            interfaceRespVo.setObject(respondBody);

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 商户资金账户明细查询
     */
    @PostMapping("/buinessAcct-detail-query")
    @Override
    public InterfaceRespVo<BuinessAcctDetailQueryReqDto> buinessAcctDetailQuery(
            BuinessAcctDetailQueryReqDto buinessAcctDetailQueryReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(buinessAcctDetailQueryReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", buinessAcctDetailQueryReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 会员资金账户绑定信息查询
     */
    @PostMapping("/acctBindInfo-query")
    @Override
    public InterfaceRespVo<AcctBindInfoQueryReqDto> acctBindInfoQuery(
            AcctBindInfoQueryReqDto acctBindInfoQueryReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(acctBindInfoQueryReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", acctBindInfoQueryReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }
            interfaceRespVo.setResult(invocationResult);
            interfaceRespVo.setObject(respondBody);

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 会员资金账户明细查询
     */
    @PostMapping("/acctDetail-query")
    @Override
    public InterfaceRespVo<AcctDetailQueryReqDto> acctDetailQuery(
            AcctDetailQueryReqDto acctDetailQueryReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(acctDetailQueryReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", acctDetailQueryReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 会员资金账户信息查询
     * 会员资金账户余额查询
     */
    @PostMapping("/acctInfo-query")
    @Override
    public InterfaceRespVo<AcctInfoQueryReqDto> acctInfoQuery(AcctInfoQueryReqDto acctInfoQueryReqDto,
                                                              BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(acctInfoQueryReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum /*BankTransInfoEnum.会员资金账户信息查询*/);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", acctInfoQueryReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            String body = respondBody.getBody();
            MemberFundAccountInfoResDto memberFundAccountInfoResDto =
                    JSONObject.parseObject(body, MemberFundAccountInfoResDto.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }
            interfaceRespVo.setObject(memberFundAccountInfoResDto);
            interfaceRespVo.setResult(invocationResult);

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 通用查询
     */
    @PostMapping("/general-query")
    @Override
    public InterfaceRespVo<GeneralQueryReqDto> generalQuery(GeneralQueryReqDto generalQueryReqDto,
                                                            BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(generalQueryReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", generalQueryReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            //应答报文体
            String body = respondBody.getBody();
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 商户交易结果通知
     */
    @PostMapping("/buiness-transResult-notify")
    @Override
    public InterfaceRespVo<BuinessTransResultNotifyReqDto> buinessTransResultNotify(
            BuinessTransResultNotifyReqDto buinessTransResultNotifyReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(buinessTransResultNotifyReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", buinessTransResultNotifyReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("网关页面的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 资金账户动账通知
     */
    @PostMapping("/acct-dynamic-notify")
    @Override
    public InterfaceRespVo<AcctDynamicNotifyReqDto> acctDynamicNotify(
            AcctDynamicNotifyReqDto acctDynamicNotifyReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(acctDynamicNotifyReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", acctDynamicNotifyReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("网关页面的url：" + authURL + "?AuthTokenID=" + authTokenID);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 商户交易流水对账
     * 商户资金账户余额对账
     * 商户资金账户明细对账
     */
    @PostMapping("/business-transaction-flow-reconciliation")
    @Override
    public InterfaceRespVo<BusinessTransactionReqDto> businessTransactionFlowReconciliation(
            BusinessTransactionReqDto businessTransactionReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(businessTransactionReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", businessTransactionReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }
            interfaceRespVo.setResult(invocationResult);
            interfaceRespVo.setObject(respondBody);

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 商户文件下载
     */
    @PostMapping("/business-document-download")
    @Override
    public InterfaceRespVo<BusinessDocumentReqDto> businessDocumentDownload(
            BusinessDocumentReqDto businessDocumentReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(businessDocumentReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", businessDocumentReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            String body = respondBody.getBody();
            BusinessFileDownloadResDto businessFileDownloadResDto = JSONObject.parseObject(body, BusinessFileDownloadResDto.class);
            //base64 文件解密
            String baseFileData = businessFileDownloadResDto.getFileData();
            String fileData = new String(Base64.decodeBase64(baseFileData.getBytes()));
            System.out.println("下载的文件内容：" + fileData);

            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }
            interfaceRespVo.setResult(invocationResult);
            interfaceRespVo.setObject(respondBody);

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }


    /**
     * 商户文件上传
     */
    @PostMapping("/business-document")
    @Override
    public InterfaceRespVo<BusinessDocumentReqDto> businessDocument(
            BusinessDocumentReqDto businessDocumentReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(businessDocumentReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }

        //base64 加密文件内容
        String fileData = businessDocumentReqDto.getFileData();
        String str = new String(Base64.encodeBase64(fileData.getBytes()));
        businessDocumentReqDto.setFileData(str);

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", businessDocumentReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文：" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }
            interfaceRespVo.setResult(invocationResult);
            interfaceRespVo.setObject(respondBody);

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(), bankTransInfoEnum.name(),
                    req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 回单查询
     */
    @PostMapping("/back-order-query")
    @Override
    public InterfaceRespVo<BackOrderQueryReqDto> backOrderQuery(BackOrderQueryReqDto backOrderQueryReqDto,
                                                                BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(backOrderQueryReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", backOrderQueryReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文:" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文:" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }
            interfaceRespVo.setResult(invocationResult);
            interfaceRespVo.setObject(respondBody);

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    bankTransInfoEnum.name(), req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 回单打印
     */
    @PostMapping("/back-order-prin")
    @Override
    public InterfaceRespVo<BackOrderPrinReqDto> backOrderPrin(BackOrderPrinReqDto backOrderPrinReqDto,
                                                              BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(backOrderPrinReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", backOrderPrinReqDto);
        jsonObject.put("head", requestHead);
        String req = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + req);
        try {
            String message = EncrAndDecryptForClient.encryptAndSign(req);
            System.out.println("请求报文密文：" + message);
            String res = HttpPostJsonUtils.post(UrlConstant.REQ_URL, message);
            System.out.println("应答报文：" + res);
            String resp = EncrAndDecryptForClient.decryptAndVertify(res);
            System.out.println("应答报文明文:" + resp);
            RespondBody respondBody = JSONObject.parseObject(resp, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }
            interfaceRespVo.setResult(invocationResult);
            interfaceRespVo.setObject(respondBody);

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    bankTransInfoEnum.name(), req, resp, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }


    //======================================在线授信申请文档接口================================================

    /**
     * 3.1.1 授信申请接受（实时模式）
     */
    @PostMapping("/credit-apply-notify-time")
    @Override
    public InterfaceRespVo<CreditApplyResDto> creditApplyNotifyTime(CreditApplyReqDto creditApplyReqDto,
                                                                    BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(creditApplyReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", creditApplyReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "授信申请接受_实时模式", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.1.2 在线授信申请的状态查询（实时模式）
     */
    @PostMapping("/credit-apply-state")
    @Override
    public InterfaceRespVo<CreditApplyStateResDto> creditApplyState(CreditApplyStateReqDto creditApplyStateReqDto,
                                                                    BankTransInfoEnum bankTransInfoEnum) {

        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(creditApplyStateReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", creditApplyStateReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "在线授信申请的状态查询", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;

    }

    /**
     * 3.1.3 提款申请(实时模式)
     */
    @PostMapping("/withdrawal-apply-time")
    @Override
    public InterfaceRespVo<WithdrawalApplyResDto> withdrawalApplyTime(WithdrawalApplyReqDto withdrawalApplyReqDto,
                                                                      BankTransInfoEnum bankTransInfoEnum) {

        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(withdrawalApplyReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", withdrawalApplyReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "提款申请_实时模式", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.1.4 提款申请状态查询（实时模式）
     */
    @PostMapping("/withdrawal-apply-state")
    @Override
    public InterfaceRespVo<WithdrawalApplyStateResDto> withdrawalApplyState(
            WithdrawalApplyStateReqDto withdrawalApplyStateReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(withdrawalApplyStateReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", withdrawalApplyStateReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "提款申请状态查询", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.1.5 商户资金账户利息试算（实时模式）
     */
    @PostMapping("/interest-trial")
    @Override
    public InterfaceRespVo<InterestTrialResDto> interestTrial(InterestTrialReqDto interestTrialReqDto,
                                                              BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(interestTrialReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", interestTrialReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "商户资金账户利息试算", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.1.6 商户资金账户提前还款（实时模式）
     */
    @PostMapping("/early-repayment")
    @Override
    public InterfaceRespVo<EarlyRepaymentResDto> earlyRepayment(EarlyRepaymentReqDto earlyRepaymentReqDto,
                                                                BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(earlyRepaymentReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", earlyRepaymentReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "商户资金账户提前还款", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.2.1 附件上传（实时模式）
     */
    @PostMapping("/upload-attachments")
    @Override
    public InterfaceRespVo<UploadAttachmentsResDto> uploadAttachments(@RequestBody UploadAttachmentsReqDto uploadAttachmentsReqDto) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(uploadAttachmentsReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        //base64加密附件内容
//        String uploadFile = uploadAttachmentsReqDto.getUploadFile();
//        String str = new String(Base64.encodeBase64(uploadFile.getBytes()));
//        uploadAttachmentsReqDto.setUploadFile(str);

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, BankTransInfoEnum.附件上传);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", uploadAttachmentsReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }
            interfaceRespVo.setResult(invocationResult);
            interfaceRespVo.setObject(respondBody);

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.附件上传.getTransCode(),
                    "附件上传", "sendOriginal", receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.2.2 订单信息推送接口（实时模式）
     */
    @PostMapping("/order-push")
    @Override
    public InterfaceRespVo<OrderPushResDto> orderPush(OrderPushReqDto orderPushReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(orderPushReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", orderPushReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }
            interfaceRespVo.setResult(invocationResult);
            interfaceRespVo.setObject(respondBody);

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "订单信息推送接口", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

//    /**
//     * 3.3.2.在线授信申请 确认 结果通知（实时模式）
//     */
//    @PostMapping("/online-credit-application-confirm")
//    public InterfaceRespVo<NotifyResultResDto> onlineCreditApplicationConfirm(NotifyResultReqDto notifyReqDto, BankTransInfoEnum bankTransInfoEnum) {
//        /*
//         * 校验dto参数
//         */
//        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
//        String checkResult = BeanValidator.validate(notifyReqDto);
//        if(!"1".equals(checkResult)){
//            interfaceRespVo.setResult("0");
//            interfaceRespVo.setFailReasons(checkResult);
//            System.out.println(checkResult);
//            return interfaceRespVo;
//        }
//        /*
//        组装报文
//         */
//
//        String transNo = DateUtils.getNowTimeInMillis();
//        RequestHead requestHead = generateHead(transNo,bankTransInfoEnum);
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("body", notifyReqDto);
//        jsonObject.put("head", requestHead);
//        //请求原文
//        String sendOriginal = JSONObject.toJSONString(jsonObject);
//        System.out.println("请求报文："+sendOriginal);
//        try {
//            //请求报文密文
//            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
//            System.out.println("请求报文密文："+sendCiphertext);
//
//            //应答报文
//            String receiveCiphertext= HttpPostJsonUtils.post(UrlConstant.REQ_URL,sendCiphertext);
//            System.out.println("应答报文"+receiveCiphertext);
//
//            //应答原文
//            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
//            RespondBody respondBody  = JSONObject.parseObject(receiveOriginal, RespondBody.class);
//            String returnCode = respondBody.getHead().getRetCode();
//            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
//            //交易成功
//            if(BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)){
//                invocationResult = 1;
//            }
//
//            //保存接口业务日志
//            //logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人开户.getTransCode(),"个人开户", sendOriginal, receiveOriginal, invocationResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//            interfaceRespVo.setFailReasons("接口调用失败");
//            return interfaceRespVo;
//        }
//        return interfaceRespVo;
//    }
//
//    /**
//     * 3.3.3 在线授信申请 受理 结果通知（实时模式）
//     */
//    @PostMapping("/online-credit-application-accept")
//    public InterfaceRespVo<NotifyResultResDto> onlineCreditApplicationAccept(NotifyResultReqDto notifyReqDto, BankTransInfoEnum bankTransInfoEnum) {
//        /*
//         * 校验dto参数
//         */
//        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
//        String checkResult = BeanValidator.validate(notifyReqDto);
//        if(!"1".equals(checkResult)){
//            interfaceRespVo.setResult("0");
//            interfaceRespVo.setFailReasons(checkResult);
//            System.out.println(checkResult);
//            return interfaceRespVo;
//        }
//        /*
//        组装报文
//         */
//
//        String transNo = DateUtils.getNowTimeInMillis();
//        RequestHead requestHead = generateHead(transNo,bankTransInfoEnum);
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("body", notifyReqDto);
//        jsonObject.put("head", requestHead);
//        //请求原文
//        String sendOriginal = JSONObject.toJSONString(jsonObject);
//        System.out.println("请求报文："+sendOriginal);
//        try {
//            //请求报文密文
//            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
//            System.out.println("请求报文密文："+sendCiphertext);
//
//            //应答报文
//            String receiveCiphertext= HttpPostJsonUtils.post(UrlConstant.REQ_URL,sendCiphertext);
//            System.out.println("应答报文"+receiveCiphertext);
//
//            //应答原文
//            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
//            RespondBody respondBody  = JSONObject.parseObject(receiveOriginal, RespondBody.class);
//            String returnCode = respondBody.getHead().getRetCode();
//            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
//            //交易成功
//            if(BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)){
//                invocationResult = 1;
//            }
//
//            //保存接口业务日志
//            //logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人开户.getTransCode(),"个人开户", sendOriginal, receiveOriginal, invocationResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//            interfaceRespVo.setFailReasons("接口调用失败");
//            return interfaceRespVo;
//        }
//        return interfaceRespVo;
//    }
//
//    /**
//     * 3.3.4 在线授信申请 审批 结果通知（实时模式）
//     */
//    @PostMapping("/online-credit-application-approval")
//    public InterfaceRespVo<NotifyResultResDto> onlineCreditApplicationApproval(NotifyResultReqDto notifyReqDto, BankTransInfoEnum bankTransInfoEnum) {
//        /*
//         * 校验dto参数
//         */
//        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
//        String checkResult = BeanValidator.validate(notifyReqDto);
//        if(!"1".equals(checkResult)){
//            interfaceRespVo.setResult("0");
//            interfaceRespVo.setFailReasons(checkResult);
//            System.out.println(checkResult);
//            return interfaceRespVo;
//        }
//        /*
//        组装报文
//         */
//
//        String transNo = DateUtils.getNowTimeInMillis();
//        NotifyReqHead notifyReqHead = generateNotifyHead(transNo,bankTransInfoEnum);
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("body", notifyReqDto);
//        jsonObject.put("head", notifyReqHead);
//        //请求原文
//        String sendOriginal = JSONObject.toJSONString(jsonObject);
//        System.out.println("请求报文："+sendOriginal);
//        try {
//            //请求报文密文
//            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
//            System.out.println("请求报文密文："+sendCiphertext);
//
//            //应答报文
//            String receiveCiphertext= HttpPostJsonUtils.post(UrlConstant.REQ_URL,sendCiphertext);
//            System.out.println("应答报文"+receiveCiphertext);
//
//            //应答原文
//            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
//            RespondBody respondBody  = JSONObject.parseObject(receiveOriginal, RespondBody.class);
//            String returnCode = respondBody.getHead().getRetCode();
//            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
//            //交易成功
//            if(BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)){
//                invocationResult = 1;
//            }
//
//            //保存接口业务日志
//            //logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人开户.getTransCode(),"个人开户", sendOriginal, receiveOriginal, invocationResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//            interfaceRespVo.setFailReasons("接口调用失败");
//            return interfaceRespVo;
//        }
//        return interfaceRespVo;
//    }
//
//    /**
//     * 3.3.5 在线 提款申请 确认 结果通知（实时模式）
//     */
//    @PostMapping("/online-withdrawal-application-confirm")
//    public InterfaceRespVo<NotifyResultResDto> onlineWithdrawalApplicationConfirm(NotifyResultReqDto notifyReqDto, BankTransInfoEnum bankTransInfoEnum) {
//        /*
//         * 校验dto参数
//         */
//        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
//        String checkResult = BeanValidator.validate(notifyReqDto);
//        if(!"1".equals(checkResult)){
//            interfaceRespVo.setResult("0");
//            interfaceRespVo.setFailReasons(checkResult);
//            System.out.println(checkResult);
//            return interfaceRespVo;
//        }
//        /*
//        组装报文
//         */
//
//        String transNo = DateUtils.getNowTimeInMillis();
//        NotifyReqHead notifyReqHead = generateNotifyHead(transNo,bankTransInfoEnum);
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("body", notifyReqDto);
//        jsonObject.put("head", notifyReqHead);
//        //请求原文
//        String sendOriginal = JSONObject.toJSONString(jsonObject);
//        System.out.println("请求报文："+sendOriginal);
//        try {
//            //请求报文密文
//            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
//            System.out.println("请求报文密文："+sendCiphertext);
//
//            //应答报文
//            String receiveCiphertext= HttpPostJsonUtils.post(UrlConstant.REQ_URL,sendCiphertext);
//            System.out.println("应答报文"+receiveCiphertext);
//
//            //应答原文
//            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
//            RespondBody respondBody  = JSONObject.parseObject(receiveOriginal, RespondBody.class);
//            String returnCode = respondBody.getHead().getRetCode();
//            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
//            //交易成功
//            if(BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)){
//                invocationResult = 1;
//            }
//
//            //保存接口业务日志
//            //logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人开户.getTransCode(),"个人开户", sendOriginal, receiveOriginal, invocationResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//            interfaceRespVo.setFailReasons("接口调用失败");
//            return interfaceRespVo;
//        }
//        return interfaceRespVo;
//    }
//
//    /**
//     * 3.3.6 在线 提款申请 受理 结果通知（实时模式）
//     */
//    @PostMapping("/online-withdrawal-application-accept")
//    public InterfaceRespVo<NotifyResultResDto> onlineWithdrawalApplicationAccept(NotifyResultReqDto notifyReqDto, BankTransInfoEnum bankTransInfoEnum) {
//        /*
//         * 校验dto参数
//         */
//        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
//        String checkResult = BeanValidator.validate(notifyReqDto);
//        if(!"1".equals(checkResult)){
//            interfaceRespVo.setResult("0");
//            interfaceRespVo.setFailReasons(checkResult);
//            System.out.println(checkResult);
//            return interfaceRespVo;
//        }
//        /*
//        组装报文
//         */
//
//        String transNo = DateUtils.getNowTimeInMillis();
//        NotifyReqHead notifyReqHead = generateNotifyHead(transNo,bankTransInfoEnum);
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("body", notifyReqDto);
//        jsonObject.put("head", notifyReqHead);
//        //请求原文
//        String sendOriginal = JSONObject.toJSONString(jsonObject);
//        System.out.println("请求报文："+sendOriginal);
//        try {
//            //请求报文密文
//            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
//            System.out.println("请求报文密文："+sendCiphertext);
//
//            //应答报文
//            String receiveCiphertext= HttpPostJsonUtils.post(UrlConstant.REQ_URL,sendCiphertext);
//            System.out.println("应答报文"+receiveCiphertext);
//
//            //应答原文
//            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
//            RespondBody respondBody  = JSONObject.parseObject(receiveOriginal, RespondBody.class);
//            String returnCode = respondBody.getHead().getRetCode();
//            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
//            //交易成功
//            if(BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)){
//                invocationResult = 1;
//            }
//
//            //保存接口业务日志
//            //logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人开户.getTransCode(),"个人开户", sendOriginal, receiveOriginal, invocationResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//            interfaceRespVo.setFailReasons("接口调用失败");
//            return interfaceRespVo;
//        }
//        return interfaceRespVo;
//    }
//
//    /**
//     * 3.3.7 合同签署 结果通知（实时模式）
//     */
//    @PostMapping("/contract-sign-result")
//    public InterfaceRespVo<NotifyResultResDto> contractSignResult(NotifyResultReqDto notifyReqDto, BankTransInfoEnum bankTransInfoEnum) {
//        /*
//         * 校验dto参数
//         */
//        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
//        String checkResult = BeanValidator.validate(notifyReqDto);
//        if(!"1".equals(checkResult)){
//            interfaceRespVo.setResult("0");
//            interfaceRespVo.setFailReasons(checkResult);
//            System.out.println(checkResult);
//            return interfaceRespVo;
//        }
//        /*
//        组装报文
//         */
//
//        String transNo = DateUtils.getNowTimeInMillis();
//        NotifyReqHead notifyReqHead = generateNotifyHead(transNo,bankTransInfoEnum);
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("body", notifyReqDto);
//        jsonObject.put("head", notifyReqHead);
//        //请求原文
//        String sendOriginal = JSONObject.toJSONString(jsonObject);
//        System.out.println("请求报文："+sendOriginal);
//        try {
//            //请求报文密文
//            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
//            System.out.println("请求报文密文："+sendCiphertext);
//
//            //应答报文
//            String receiveCiphertext= HttpPostJsonUtils.post(UrlConstant.REQ_URL,sendCiphertext);
//            System.out.println("应答报文"+receiveCiphertext);
//
//            //应答原文
//            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
//            RespondBody respondBody  = JSONObject.parseObject(receiveOriginal, RespondBody.class);
//            String returnCode = respondBody.getHead().getRetCode();
//            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
//            //交易成功
//            if(BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)){
//                invocationResult = 1;
//            }
//
//            //保存接口业务日志
//            //logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人开户.getTransCode(),"个人开户", sendOriginal, receiveOriginal, invocationResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//            interfaceRespVo.setFailReasons("接口调用失败");
//            return interfaceRespVo;
//        }
//        return interfaceRespVo;
//    }

    /**
     * 3.4.1 贷款信息查询（实时模式）
     */
    @PostMapping("/loan-information")
    @Override
    public InterfaceRespVo<LoanInformationResDto> loanInformation(LoanInformationReqDto loanInformationReqDto,
                                                                  BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(loanInformationReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", loanInformationReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "贷款信息查询", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.4.2 还款计划详情 查询（实时模式）
     */
    @PostMapping("/payment-information")
    @Override
    public InterfaceRespVo<PaymentInformationResDto> paymentInformation(
            PaymentInformationReqDto paymentInformationReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(paymentInformationReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", paymentInformationReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "还款计划详情查询", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.4.3 还款计划明细 查询（实时模式）
     */
    @PostMapping("/payment-detail-list")
    @Override
    public InterfaceRespVo<PaymentDetaileResDto> paymentDetailList(
            PaymentInformationReqDto paymentInformationReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(paymentInformationReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", paymentInformationReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "还款计划明细查询", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.4.4 合同协议列表 查询（实时模式）
     */
    @PostMapping("/contract-agreement-list")
    @Override
    public InterfaceRespVo<ContractAgreementResDto> contractAgreementList(
            ContractAgreementReqDto contractAgreementReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(contractAgreementReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", contractAgreementReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "合同协议列表查询", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.4.5 合同协议详情 查询（实时模式）
     */
    @PostMapping("/contract-agreement-detail")
    @Override
    public InterfaceRespVo<ContractAgreementDetailResDto> contractAgreementDetail(
            @RequestBody ContractAgreementDetailReqDto contractAgreementDetailReqDto) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(contractAgreementDetailReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, BankTransInfoEnum.合同协议详情查询);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", contractAgreementDetailReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.合同协议详情查询.getTransCode(),
                    "合同协议详情查询", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.4.6 授信额度 查询（实时模式）
     */
    @PostMapping("/credit-line")
    @Override
    public InterfaceRespVo<CreditLineResDto> creditLine(CreditLineReqDto creditLineReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(creditLineReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", creditLineReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "授信额度查询", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.4.7 还款结果 查询（实时模式）
     */
    @PostMapping("/repayment-result")
    @Override
    public InterfaceRespVo<RepaymentResultResDto> repaymentResult(
            RepaymentResultReqDto repaymentResultReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(repaymentResultReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", repaymentResultReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "还款结果查询", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.4.8 项目信息 查询（实时模式）
     */
    @PostMapping("/project-info")
    @Override
    public InterfaceRespVo<ProjectInfoResDto> projectInfo(ProjectInfoReqDto projectInfoReqDto,
                                                          BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(projectInfoReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", projectInfoReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "项目信息查询", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 3.4.9 模式 查询（实时模式）
     */
    @PostMapping("/pattern-query")
    @Override
    public InterfaceRespVo<PatternQueryResDto> patternQuery(PatternQueryReqDto patternQueryReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(patternQueryReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", patternQueryReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "模式查询", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 4.1 授信申请接受
     */
    @PostMapping("/credit-apply-notify")
    @Override
    public InterfaceRespVo<CreditApplyResDto> creditApplyNotify(CreditApplyReqDto creditApplyReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(creditApplyReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", creditApplyReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("授信申请接受的url：" + authURL + "?AuthTokenID=" + authTokenID);

            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "授信申请接受", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 4.2 提款申请
     */
    @PostMapping("/withdrawal-apply")
    @Override
    public InterfaceRespVo<WithdrawalApplyResDto> withdrawalApply(
            WithdrawalApplyReqDto withdrawalApplyReqDto, BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(withdrawalApplyReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", withdrawalApplyReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("提款申请的url：" + authURL + "?AuthTokenID=" + authTokenID);

            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "提款申请", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }

    /**
     * 4.3 合同签署
     */
    @PostMapping("/contract-sign")
    @Override
    public InterfaceRespVo<ContractSignResDto> contractSign(ContractSignReqDto contractSignReqDto,
                                                            BankTransInfoEnum bankTransInfoEnum) {
        /*
         * 校验dto参数
         */
        InterfaceRespVo interfaceRespVo = new InterfaceRespVo();
        String checkResult = BeanValidator.validate(contractSignReqDto);
        if (!"1".equals(checkResult)) {
            interfaceRespVo.setResult(0);
            interfaceRespVo.setFailReasons(checkResult);
            System.out.println(checkResult);
            return interfaceRespVo;
        }
        /*
        组装报文
         */

        String transNo = DateUtils.getNowTimeInMillis();
        RequestHead requestHead = generateHead(transNo, bankTransInfoEnum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", contractSignReqDto);
        jsonObject.put("head", requestHead);
        //请求原文
        String sendOriginal = JSONObject.toJSONString(jsonObject);
        System.out.println("请求报文：" + sendOriginal);
        try {
            //请求报文密文
            String sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);
            System.out.println("请求报文密文：" + sendCiphertext);

            //应答报文
            String receiveCiphertext = HttpPostJsonUtils.post(UrlConstant.REQ_URL, sendCiphertext);
            System.out.println("应答报文：" + receiveCiphertext);

            //应答原文
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("应答原文：" + receiveOriginal);
            RespondBody respondBody = JSONObject.parseObject(receiveOriginal, RespondBody.class);
            RespondHead head = respondBody.getHead();
            String authURL = head.getAuthURL();
            authURL = authURL.replace("14.16.20.226:7054", "test2.thinksofterp.com:7055");
            String authTokenID = head.getAuthTokenID();
            System.out.println("合同签署的url：" + authURL + "?AuthTokenID=" + authTokenID);

            String returnCode = respondBody.getHead().getRetCode();
            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功
            //交易成功
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {
                invocationResult = 1;
            }

            //保存接口业务日志
            logService.saveLogInterfaceInvoke(null, bankTransInfoEnum.getTransCode(),
                    "合同签署", sendOriginal, receiveOriginal, invocationResult);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceRespVo.setFailReasons("接口调用失败");
            return interfaceRespVo;
        }
        return interfaceRespVo;
    }


    /**
     * @param transNo
     * @param bankNotifyUrl
     * @return RequestHead
     * @功能描述：组装请求报文头
     * @developer：zhanggaoqun
     * @date：2019年1月30日 上午10:42:15
     */
    private static RequestHead generateHead(String transNo, BankTransInfoEnum bankNotifyUrl) {
        System.out.println("功能代码:" + bankNotifyUrl.getTransCode());
        System.out.println("银行通知的url:" + UrlConstant.NOTIFY_URL + bankNotifyUrl.getReceiveNotifyUrl());
        System.out.println("页面跳转的url:" + bankNotifyUrl.getTradeBackUrl());
        RequestHead requestHead = new RequestHead();
        requestHead.setMerCurrCode("01");//人民币
        requestHead.setChanCode(ChancelConfigConstant.CHAN_CODE);
        requestHead.setCustCode(ChancelConfigConstant.CUST_CODE);
        requestHead.setMerCode(ChancelConfigConstant.MER_CODE);
        requestHead.setMerAcctNo(ChancelConfigConstant.MER_ACCT_NO);
        requestHead.setFunCode(bankNotifyUrl.getTransCode());
        requestHead.setOrderNo(transNo);
        requestHead.setNotifyURL(UrlConstant.NOTIFY_URL + bankNotifyUrl.getReceiveNotifyUrl());
        requestHead.setOrderDate(DateUtils.getNowDate());
        requestHead.setOrderTime(DateUtils.getNowTime().substring(8, 14));
        requestHead.setRebackURL(bankNotifyUrl.getTradeBackUrl());
        AnnotationValidate.validate(requestHead);
        return requestHead;
    }


}
