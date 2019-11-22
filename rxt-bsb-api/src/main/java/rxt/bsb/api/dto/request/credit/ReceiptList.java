package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import net.sf.json.JSON;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 收获信息统计
 * Created by ChenLiXin on 2019/9/18 0018 13:19
 */
public class ReceiptList implements Serializable {

    @Size(max = 50, message = "收货人长度不超过位{max}")
    private String receiver;//收货人

    @Size(max = 20, message = "联系方式长度不超过位{max}")
    private String contactInfo ;//联系方式

    @Size(max = 100, message = "收货地址长度不超过位{max}")
    private String recAddress ;//收货地址

    @Size(max = 18, message = "交易笔数长度不超过位{max}")
    private String transNum ;//交易笔数

    @Size(max = 18, message = "交易金额长度不超过位{max}")
    private String transAmt  ;//交易金额

    @JSONField(name = "receiver")
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @JSONField(name = "contactInfo")
    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @JSONField(name = "recAddress")
    public String getRecAddress() {
        return recAddress;
    }

    public void setRecAddress(String recAddress) {
        this.recAddress = recAddress;
    }

    @JSONField(name = "transNum")
    public String getTransNum() {
        return transNum;
    }

    public void setTransNum(String transNum) {
        this.transNum = transNum;
    }

    @JSONField(name = "transAmt")
    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }

}
