package rxt.bsb.api.dto.request.notice;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 通知管理的 请求报文
 * Created by ChenLiXin on 2019/9/18 0018 14:37
 */
public class NotifyResultReqDto implements Serializable {

    @NotBlank(message = "商户请求流水号不能空")
    @Size(max = 32, message = "商户请求流水号长度不超过{max}位")
    private String merchantSerialCode; //商户请求流水号

    @NotBlank(message = "银行交易流水号不能空")
    @Size(max = 32, message = "银行交易流水号长度不超过{max}位")
    private String platformSerialCode; //银行交易流水号

    @NotBlank(message = "功能代码不能空")
    @Size(max = 8, message = "功能代码长度不超过{max}位")
    private String tradeCode; //功能代码

    @NotBlank(message = "状态码不能空")
    @Size(max = 6, message = "状态码长度不超过{max}位")
    private String returnCode; //状态码

    @NotBlank(message = "状态描述不能空")
    @Size(max = 32, message = "状态描述长度不超过{max}位")
    private String returnMessage; //状态描述

    @Size(max = 1000, message = "交易返回信息长度不超过{max}位")
    private String returnInfo; //交易返回信息

    @Size(max = 32, message = "授信申请编号长度不超过{max}位")
    private String applyNo; //授信申请编号 授信申请发起时的申请编号

    @Size(max = 32, message = "合同编号长度不超过{max}位")
    private String  ContractNo ; //合同编号


    public String getMerchantSerialCode() {
        return merchantSerialCode;
    }

    public void setMerchantSerialCode(String merchantSerialCode) {
        this.merchantSerialCode = merchantSerialCode;
    }

    public String getPlatformSerialCode() {
        return platformSerialCode;
    }

    public void setPlatformSerialCode(String platformSerialCode) {
        this.platformSerialCode = platformSerialCode;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getContractNo() {
        return ContractNo;
    }

    public void setContractNo(String contractNo) {
        ContractNo = contractNo;
    }
}
