package rxt.bsb.front.web;

import com.alibaba.fastjson.JSONObject;
import com.hundsun.tbsp.adapter.suite.cipher.client.EncrAndDecryptForClient;
import constant.BankTransInfoEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rxt.bsb.api.constant.BankReturnCode;
import rxt.bsb.api.dto.request.NotifyReqDto;
import rxt.bsb.api.dto.response.NotifyRespondBody;
import rxt.bsb.api.dto.response.NotifyRespondDto;
import rxt.bsb.api.dto.response.NotifyRespondHead;
import rxt.bsb.front.service.LogService;
import utils.ValidateUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * Created by ChenLiXin on 2019/9/24 0024 14:54
 */
@RestController
@RequestMapping(value = "/bsbFront")
public class BankNotifyController {
    private static Logger logger = LoggerFactory.getLogger(BankNotifyController.class);

    @Autowired
    private LogService logService;

    /**
     * 接收 会员账户信息修改结果
     *
     * @param request
     * @param
     */
    @PostMapping("/receiveUpdateSubAcctNoServlet")
    public String receiveUpdateSubAcctNoServlet(HttpServletRequest request, HttpServletResponse response) {
        String receiveCiphertext = null;  //接收的密文
        String receiveOriginal = null;  //接收的原文
        Integer invocationResult = null;// 接口调用结果0-失败;1-成功
        String sendOriginal = null;  //发送的原文
        String sendCiphertext = null;  //发送的密文
        try {
            System.out.println("接收会员账户信息修改结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            // 将资料解码
            String reqBody = sb.toString();
            receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签后的通知数据：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode(); //状态码

            invocationResult = 0;
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                PrintWriter out = response.getWriter();
                System.out.println(sendCiphertext);
                out.print(sendCiphertext);
                response.setContentType("application/json");
                out.flush();
                out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.会员账户信息修改.getTransCode(),
                        "会员账户信息修改结果通知", sendOriginal, receiveOriginal, invocationResult);

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收会员账户信息修改结果通知异常", e);
        }
        return sendCiphertext;

    }

    /**
     * 接收 银行通知个人开户结果
     *
     * @param request
     * @param
     */
    @PostMapping("/receiveOpenAcctResultServlet")
    public String receiveOpenAcctResultServlet(HttpServletRequest request, HttpServletResponse response) {
        String receiveCiphertext = null;  //接收的密文
        String receiveOriginal = null;  //接收的原文
        Integer invocationResult = null;// 接口调用结果0-失败;1-成功
        String sendOriginal = null;  //发送的原文
        String sendCiphertext = null;  //发送的密文
        try {
            System.out.println("接收个人开户结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            // 将资料解码
            String reqBody = sb.toString();
            receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签后的通知数据：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode(); //状态码

            invocationResult = 0;
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                PrintWriter out = response.getWriter();
                System.out.println(sendCiphertext);
                out.print(sendCiphertext);
                response.setContentType("application/json");
                out.flush();
                out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人开户.getTransCode(),
                        "个人开户结果通知", sendOriginal, receiveOriginal, invocationResult);

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收银行个人开户结果通知异常", e);
        }
        return sendCiphertext;

    }

    /**
     * 接收 银行通知企业开户结果
     *
     * @param request
     * @param response
     */
    @PostMapping("/receiveOpenEnterpriseAcctResultServlet")
    public String receiveOpenEnterpriseAcctResultServlet(HttpServletRequest request, HttpServletResponse response) {
        String sendCiphertext = null;
        try {
            System.out.println("接收企业开户结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.企业开户.getTransCode(),
                        "企业开户结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收银行企业开户结果通知异常", e);
        }
        return sendCiphertext;
    }

    /**
     * 接收银行个人会员重置密码结果通知
     *
     * @param request
     * @return
     */
    @PostMapping("/resetPwdResultServlet")
    public String resetPwd(HttpServletRequest request) {
        String receiveCiphertext = null;  //接收的密文
        String receiveOriginal = null;  //接收的原文
        Integer invocationResult = null;// 接口调用结果0-失败;1-成功
        String sendOriginal = null;  //发送的原文
        String sendCiphertext = null;  //发送的密文
        try {
            logger.info("接收个人密码重置结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            // 将资料解码
            String reqBody = sb.toString();
            receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("验签后的通知数据：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode(); //状态码

            invocationResult = 0;
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人密码重置.getTransCode(),
                        "个人密码重置结果通知", sendOriginal, receiveOriginal, invocationResult);

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收个人重置密码结果通知异常", e);
        }
        return sendCiphertext;

    }

    /**
     * 接收银行企业会员重置密码结果通知
     *
     * @param request
     * @return
     */
    @PostMapping("/enterpriseResetPwdResultServlet")
    public String enterpriseResetPwd(HttpServletRequest request) {
        String receiveCiphertext = null;  //接收的密文
        String receiveOriginal = null;  //接收的原文
        Integer invocationResult = null;// 接口调用结果0-失败;1-成功
        String sendOriginal = null;  //发送的原文
        String sendCiphertext = null;  //发送的密文
        try {
            logger.info("接收企业会员密码重置结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            // 将资料解码
            String reqBody = sb.toString();
            receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("验签后的通知数据：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode(); //状态码

            invocationResult = 0;
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.企业密码重置.getTransCode(),
                        "企业密码重置结果通知", sendOriginal, receiveOriginal, invocationResult);

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收企业会员重置密码结果通知异常", e);
        }
        return sendCiphertext;
    }

    /**
     * 接收修改个人会员手机号结果通知
     *
     * @param request
     * @return
     */
    @PostMapping("/modifyPersonMobileResultServlet")
    public String modifyPersonMobile(HttpServletRequest request) {
        String receiveCiphertext = null;  //接收的密文
        String receiveOriginal = null;  //接收的原文
        Integer invocationResult = null;// 接口调用结果0-失败;1-成功
        String sendOriginal = null;  //发送的原文
        String sendCiphertext = null;  //发送的密文
        try {
            logger.info("接收修改个人会员手机号结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            // 将资料解码
            String reqBody = sb.toString();
            receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签后的通知数据：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode(); //状态码

            invocationResult = 0;
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人手机号码修改.getTransCode(),
                        "个人手机号码修改结果通知", sendOriginal, receiveOriginal, invocationResult);

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收修改个人会员手机号通知异常", e);
        }
        return sendCiphertext;

    }

    /**
     * 接收企业会员手机号修改 结果通知
     *
     * @param request
     * @return
     */
    @PostMapping("/modifyEnterpriseMobileResultServlet")
    public String modifyEnterpriseMobile(HttpServletRequest request) {
        String receiveCiphertext = null;  //接收的密文
        String receiveOriginal = null;  //接收的原文
        Integer invocationResult = null;// 接口调用结果0-失败;1-成功
        String sendOriginal = null;  //发送的原文
        String sendCiphertext = null;  //发送的密文
        try {
            logger.info("接收企业会员手机号修改结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            // 将资料解码
            String reqBody = sb.toString();
            receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签后的通知数据：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode(); //状态码

            invocationResult = 0;
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.企业手机号码修改.getTransCode(),
                        "企业手机号码修改结果通知", sendOriginal, receiveOriginal, invocationResult);

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收企业会员手机号修改结果通知异常", e);
        }
        return sendCiphertext;
    }


    /**
     * 接收个人首笔支付认证结果通知
     *
     * @param request
     * @return
     */
    @PostMapping("/personPayAuthenticationResultServlet")
    public String personPayAuthentication(HttpServletRequest request) {
        String receiveCiphertext = null;  //接收的密文
        String receiveOriginal = null;  //接收的原文
        Integer invocationResult = null;// 接口调用结果0-失败;1-成功
        String sendOriginal = null;  //发送的原文
        String sendCiphertext = null;  //发送的密文
        try {
            logger.info("接收个人首笔支付认证结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            // 将资料解码
            String reqBody = sb.toString();
            receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签后的通知数据：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode(); //状态码

            invocationResult = 0;
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人会员支付认证.getTransCode(),
                        "个人首笔支付认证结果通知", sendOriginal, receiveOriginal, invocationResult);

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收个人首笔支付认证结果通知异常", e);
        }
        return sendCiphertext;

    }

    /**
     * 接收企业会员首笔支付认证 结果通知
     *
     * @param request
     * @return
     */
    @PostMapping("/firstPayAuthenticationResultServlet")
    public String firstPayAuthentication(HttpServletRequest request) {
        String receiveCiphertext = null;  //接收的密文
        String receiveOriginal = null;  //接收的原文
        Integer invocationResult = null;// 接口调用结果0-失败;1-成功
        String sendOriginal = null;  //发送的原文
        String sendCiphertext = null;  //发送的密文
        try {
            logger.info("接收企业会员首笔支付认证结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            // 将资料解码
            String reqBody = sb.toString();
            receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签后的通知数据：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode(); //状态码

            invocationResult = 0;
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.首笔支付认证.getTransCode(),
                        "企业会员首笔支付认证结果通知", sendOriginal, receiveOriginal, invocationResult);

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收企业会员首笔支付认证结果通知异常", e);
        }
        return sendCiphertext;
    }

    /**
     * 接收  个人代扣协议签约通知
     *
     * @param request
     * @return
     */
    @PostMapping("/personMemberAgreementSignResultServlet")
    public String personMemberAgreementSign(HttpServletRequest request) {
        String receiveCiphertext = null;  //接收的密文
        String receiveOriginal = null;  //接收的原文
        Integer invocationResult = null;// 接口调用结果0-失败;1-成功
        String sendOriginal = null;  //发送的原文
        String sendCiphertext = null;  //发送的密文
        try {
            logger.info("接收密码重置结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            // 将资料解码
            String reqBody = sb.toString();
            receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签后的通知数据：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode(); //状态码

            invocationResult = 0;
            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

//                PrintWriter out = response.getWriter();
//                System.out.println(sendCiphertext);
//                out.print(sendCiphertext);
//                response.setContentType("application/json");
//                out.flush();
//                out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人会员代扣协议签约.getTransCode(),
                        "个人会员代扣协议签约通知", sendOriginal, receiveOriginal, invocationResult);

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收个人代扣协议签约通知异常", e);
        }
        return sendCiphertext;

    }


    /**
     * 接收个人会员银行卡绑定结果
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receivePersonalBindAcctResultServlet")
    public String receivePersonalBindAcctResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收个人会员银行卡绑定结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人会员银行卡绑定.getTransCode(),
                        "个人会员银行卡绑定结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收个人会员银行卡绑定结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }


    /**
     * 企业会员结算账户绑定
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receiveEnterpriseBindAcctResultServlet")
    public String receiveEnterpriseBindAcctResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收企业会员银行卡绑定结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.企业会员结算账户绑定.getTransCode(),
                        "企业会员结算账户绑定结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收企业会员银行卡绑定结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }


    /**
     * 个人会员银行卡解绑
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receivePersonalUnBindAcctResultServlet")
    public String receivePersonalUnBindAcctResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收个人会员银行卡解绑结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人会员银行卡解绑.getTransCode(),
                        "个人会员银行卡解绑结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收个人会员银行卡解绑结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }

        return sendCiphertext;
    }


    /**
     * 企业会员结算账户解绑
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receiveEnterpriseUnBindAcctResultServlet")
    public String receiveEnterpriseUnBindAcctResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收企业会员结算账户解绑结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.企业会员结算账户解绑.getTransCode(),
                        "企业会员结算账户解绑结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收企业会员结算账户解绑结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }


    /**
     * 个人会员资金账户线上转账充值入金
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receiveRechargePersonalResultServlet")
    public String receiveRechargePersonalResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收个人会员资金账户转账充值入金结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人会员资金账户线上转账充值入金.getTransCode(),
                        "个人会员资金账户线上转账充值入金结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收个人会员资金账户线上转账充值入金结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }


    /**
     * 企业会员资金账户线上转账充值入金
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receiveRechargeEnterpriseResultServlet")
    public String receiveRechargeEnterpriseResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收企业会员资金账户转账充值入金结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.企业会员资金账户线上转账充值入金.getTransCode(),
                        "企业会员资金账户线上转账充值入金结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收企业会员资金账户线上转账充值入金结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }


    /**
     * 个人会员资金账户提现出金
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receiveCashWithdrawalPersonalResultServlet")
    public String receiveCashWithdrawalPersonalResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收个人会员资金账户提现出金结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人会员资金账户提现出金.getTransCode(),
                        "个人会员资金账户提现出金结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收个人会员资金账户提现出金结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }


    /**
     * 企业会员资金账户提现出金
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receiveCashWithdrawalEnterpriseResultServlet")
    public String receiveCashWithdrawalEnterpriseResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收企业会员资金账户提现出金结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.企业会员资金账户提现出金.getTransCode(),
                        "企业会员资金账户提现出金结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收企业会员资金账户提现出金结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }


    /**
     * 会员批量出金
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/batchPaymentResultServlet")
    public String batchPaymentResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收会员批量出金结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.会员批量出金.getTransCode(),
                        "会员批量出金结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收会员批量出金结果异常", e);
        }
        return sendCiphertext;
    }

    /**
     * 个人订单单笔即时支付通知
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/singleOrderPayDownResultServlet")
    public String singleOrderPayDownResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收个人订单单笔即时支付通知");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人订单单笔即时支付.getTransCode(),
                        "个人订单单笔即时支付通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收个人订单单笔即时支付通知异常");
        }
        return sendCiphertext;
    }

    /**
     * 个人订单批量即时支付通知
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/batchOrderPayDownResultServlet")
    public String batchOrderPayDownResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收个人订单批量即时支付通知");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.个人订单批量即时支付.getTransCode(),
                        "个人订单批量即时支付通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收个人订单批量即时支付通知异常");
        }
        return sendCiphertext;
    }

    /**
     * 企业会员订单单笔即时支付通知
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/enterpriseSingleOrderPayDownResultServlet")
    public String enterpriseSingleOrderPayDown(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收企业会员订单单笔即时支付通知");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.企业订单单笔即时支付.getTransCode(),
                        "企业会员订单单笔即时支付通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收企业会员订单单笔即时支付通知异常");
        }
        return sendCiphertext;
    }

    /**
     * 企业会员订单批量即时支付通知
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/enterpriseBatchOrderPayDownResultServlet")
    public String enterpriseBatchOrderPayDown(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收企业会员订单批量即时支付通知");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.企业订单批量即时支付.getTransCode(),
                        "企业会员订单批量即时支付通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收企业会员订单批量即时支付通知异常");
        }
        return sendCiphertext;
    }

    /**
     * 会员订单批量担保支付预付
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receiveOrderBatchGuaranteePrepaymentResultServlet")
    public String receiveOrderBatchGuaranteePrepaymentResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收会员订单批量担保支付预付结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.println("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.会员订单批量担保支付预付.getTransCode(),
                        "会员订单批量担保支付预付结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收会员订单批量担保支付预付结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }


    /**
     * 会员订单担保支付确认
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receiveOrderGuaranteedPaymentConfirmResultServlet")
    public String receiveOrderGuaranteedPaymentConfirmResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收会员订单单笔担保支付确认结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.会员订单担保支付确认.getTransCode(),
                        "会员订单担保支付确认结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收会员订单担保支付确认结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }


    /* *//**
     * 会员订单单笔担保支付撤销
     *
     * @param request
     * @throws IOException
     *//*
    @PostMapping("/receiveOrderGuaranteedPaymentRevokeResultServlet")
    public String receiveOrderGuaranteedPaymentRevokeResultServlet(HttpServletRequest request){
        String sendCiphertext = null;
        try {
            System.out.println("接收会员订单单笔担保支付撤销结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            // if(BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)){//交易成功
            if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                invocationResult = 1;
            }
            *//*
     * 返回接收成功的消息
     *//*

            NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
            NotifyRespondHead head = new NotifyRespondHead();
            head.setMerchantCode(merchantCode);
            head.setPlatformSerialCode(platformSerialCode);
            NotifyRespondBody body = new NotifyRespondBody();
            body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
            body.setRetInfo("");
            notifyRespondDto.setBody(body);
            notifyRespondDto.setHead(head);
            String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
            System.out.println("通知返回内容：" + sendOriginal);
            sendCiphertext = EncrAndDecryptForClient
                    .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
            //保存接口日志
            logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.会员订单单笔担保支付撤销.getTransCode(), "会员订单单笔担保支付撤销结果通知", sendOriginal, receiveOriginal, invocationResult);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收会员订单单笔担保支付撤销结果异常",e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }*/


    /**
     * 会员订单加强型单笔即时支付
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receiveStrongSingleOrderPayDownResultServlet")
    public String receiveStrongSingleOrderPayDown(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收会员订单加强型单笔即时支付结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.会员订单加强型单笔即时支付.getTransCode(),
                        "会员订单加强型单笔即时支付结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收会员订单加强型单笔即时支付结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }


    /**
     * 会员订单加强型批量担保支付预付
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receiveStrongOrderBatchGuaranteePrepaymentResultServlet")
    public String receiveStrongOrderBatchGuaranteePrepayment(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收会员订单加强型批量担保支付预付结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.会员订单加强型批量担保支付预付.getTransCode(),
                        "会员订单加强型批量担保支付预付结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收会员订单加强型批量担保支付预付结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }


    /**
     * 会员订单加强型批量即时支付
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receiveStrongBatchOrderPayDownResultServlet")
    public String receiveStrongBatchOrderPayDown(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收会员订单加强型批量即时支付结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.会员订单加强型批量即时支付.getTransCode(),
                        "会员订单加强型批量即时支付结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收会员订单加强型批量即时支付结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }

    /**
     * 企业开户Ukey绑定修改
     *
     * @return
     */
    @PostMapping("/enterpriseOpenUkeyBindingResultServlet")
    public String enterpriseOpenUkeyBinding(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收企业开户Ukey绑定修改结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient.encryptAndSign(sendOriginal);

                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.企业开户Ukey绑定修改.getTransCode(),
                        "企业开户Ukey绑定修改结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收企业开户Ukey绑定修改结果通知异常", e);
        }
        return sendCiphertext;
    }


    /**
     * 商户资金账户提现出金
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/receiveCashWithdrawalMerchantResultServlet")
    public String receiveCashWithdrawalMerchantResultServlet(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收商户资金账户提现出金结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.商户资金账户提现出金.getTransCode(),
                        "商户资金账户提现出金结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收商户资金账户提现出金结果异常", e);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print("{'result':'0','failReason':'发送失败'}");
//            out.flush();
//            out.close();
        }
        return sendCiphertext;
    }

    /**
     * 4.8.1.2. 资金账户动账通知（实时模式）
     */
    @PostMapping("/capitalAccountMovementResultServlet")
    public String capitalAccountMovement(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收资金账户动账通知");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("通知成功");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//                PrintWriter out = response.getWriter();
//                System.out.println(sendCiphertext);
//                out.print(sendCiphertext);
//                response.setContentType("application/json");
//                out.flush();
//                out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.资金账户动账通知.getTransCode(),
                        "资金账户动账通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收资金账户动账通知结果异常", e);
//            try {
//                response.setContentType("application/json");
//                PrintWriter out = response.getWriter();
//                out.print("{'result':'0','failReason':'发送失败'}");
//                out.flush();
//                out.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
        }
        return sendCiphertext;
    }


    /**
     * 3.3.1.商户交易结果通知（实时模式）
     */
    @PostMapping("/merchantTransactionsResultServlet")
    public String merchantTransactionsResult(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收商户交易结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("通知成功");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.商户交易结果通知.getTransCode(),
                        "商户交易结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收商户交易结果通知结果异常", e);
//            try {
//                response.setContentType("application/json");
//                PrintWriter out = response.getWriter();
//                out.print("{'result':'0','failReason':'发送失败'}");
//                out.flush();
//                out.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
        }
        return sendCiphertext;
    }


    /**
     * 3.3.2.在线授信申请 确认 结果通知（实时模式）
     */
    @PostMapping("/onlineCreditApplicationConfirmResultServlet")
    public String onlineCreditApplicationConfirm(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收在线授信申请确认结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("通知成功");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.在线授信申请确认结果通知.getTransCode(),
                        "在线授信申请确认结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收在线授信申请确认结果通知结果异常", e);
//            try {
//                response.setContentType("application/json");
//                PrintWriter out = response.getWriter();
//                out.print("{'result':'0','failReason':'发送失败'}");
//                out.flush();
//                out.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
        }
        return sendCiphertext;
    }

    /**
     * 3.3.3 在线授信申请 受理 结果通知（实时模式）
     */
    @PostMapping("/onlineCreditApplicationAcceptResultServlet")
    public String onlineCreditApplicationAccept(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收在线授信申请受理结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("通知成功");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.在线授信申请受理结果通知.getTransCode(),
                        "在线授信申请受理结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收在线授信申请受理结果通知结果异常", e);
//            try {
//                response.setContentType("application/json");
//                PrintWriter out = response.getWriter();
//                out.print("{'result':'0','failReason':'发送失败'}");
//                out.flush();
//                out.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
        }
        return sendCiphertext;
    }

    /**
     * 3.3.4 在线授信申请 审批 结果通知（实时模式）
     */
    @PostMapping("/onlineCreditApplicationApprovalResultServlet")
    public String onlineCreditApplicationApproval(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收在线授信申请审批结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("通知成功");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.在线授信申请审批结果通知.getTransCode(),
                        "在线授信申请审批结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收在线授信申请审批结果通知结果异常", e);
//            try {
//                response.setContentType("application/json");
//                PrintWriter out = response.getWriter();
//                out.print("{'result':'0','failReason':'发送失败'}");
//                out.flush();
//                out.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
        }
        return sendCiphertext;
    }

    /**
     * 3.3.5 在线 提款申请 确认 结果通知（实时模式）
     */
    @PostMapping("/onlineWithdrawalApplicationConfirmResultServlet")
    public String onlineWithdrawalApplicationConfirm(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收在线 提款申请 确认 结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("通知成功");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.在线提款申请确认结果通知.getTransCode(),
                        "在线提款申请确认结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收在线提款申请确认结果通知结果异常", e);
//            try {
//                response.setContentType("application/json");
//                PrintWriter out = response.getWriter();
//                out.print("{'result':'0','failReason':'发送失败'}");
//                out.flush();
//                out.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
        }
        return sendCiphertext;
    }

    /**
     * 3.3.6 在线 提款申请 受理 结果通知（实时模式）
     */
    @PostMapping("/onlineWithdrawalApplicationAcceptResultServlet")
    public String onlineWithdrawalApplicationAccept(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收在线 提款申请 受理 结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("通知成功");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.在线提款申请受理结果通知.getTransCode(),
                        "在线提款申请受理结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收在线提款申请受理结果通知结果异常", e);
//            try {
//                response.setContentType("application/json");
//                PrintWriter out = response.getWriter();
//                out.print("{'result':'0','failReason':'发送失败'}");
//                out.flush();
//                out.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
        }
        return sendCiphertext;
    }

    /**
     * 3.3.7 合同签署 结果通知（实时模式）
     */
    @PostMapping("/contractSignResultServlet")
    public String contractSignResult(HttpServletRequest request) {
        String sendCiphertext = null;
        try {
            System.out.println("接收合同签署结果");
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            // 将资料解码
            String reqBody = sb.toString();
            String receiveCiphertext = URLDecoder.decode(reqBody, "UTF-8");
            System.out.println("响应报文UF8：" + receiveCiphertext);
            String receiveOriginal = EncrAndDecryptForClient.decryptAndVertify(receiveCiphertext);
            System.out.print("验签：" + receiveOriginal);
            NotifyReqDto notifyReqDto = JSONObject.parseObject(receiveOriginal, NotifyReqDto.class);
            String merchantCode = notifyReqDto.getHead().getMerchantCode();
            String platformSerialCode = notifyReqDto.getBody().getMerchantSerialCode();
            String returnCode = notifyReqDto.getBody().getReturnCode();

            Integer invocationResult = 0;// 接口调用结果0-失败;1-成功

            if (BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)) {//交易成功
                if (ValidateUtils.isNotEmpty(notifyReqDto.getBody().getReturnInfo())) {// 由于测试环境returnCode返回值有误暂时用此判断
                    invocationResult = 1;
                }
                /*
                 * 返回接收成功的消息
                 */

                NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
                NotifyRespondHead head = new NotifyRespondHead();
                head.setMerchantCode(merchantCode);
                head.setPlatformSerialCode(platformSerialCode);
                NotifyRespondBody body = new NotifyRespondBody();
                body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
                body.setRetInfo("通知成功");
                notifyRespondDto.setBody(body);
                notifyRespondDto.setHead(head);
                String sendOriginal = JSONObject.toJSONString(notifyRespondDto);
                System.out.println("通知返回内容：" + sendOriginal);
                sendCiphertext = EncrAndDecryptForClient
                        .encryptAndSign(sendOriginal);
//            PrintWriter out = response.getWriter();
//            System.out.println(sendCiphertext);
//            out.print(sendCiphertext);
//            response.setContentType("application/json");
//            out.flush();
//            out.close();
                //保存接口日志
                logService.saveLogInterfaceInvoke(null, BankTransInfoEnum.合同签署结果通知.getTransCode(),
                        "合同签署结果通知", sendOriginal, receiveOriginal, invocationResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接收合同签署结果通知结果异常", e);
//            try {
//                response.setContentType("application/json");
//                PrintWriter out = response.getWriter();
//                out.print("{'result':'0','failReason':'发送失败'}");
//                out.flush();
//                out.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
        }
        return sendCiphertext;
    }
}
