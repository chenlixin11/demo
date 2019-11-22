package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ChenLiXin on 2019/9/18 0018 9:51
 */
public class EntrstdPayListReqDto implements Serializable {

    @Size(max = 32,message = "受托账号长度不超过{max}位")
    private String  EntrstdAccNo;  //受托账号 当支付方式为受托支付时必输

    @Size(max = 20,message = "开户行号长度不超过{max}位")
    private String DepBnkNo;  //开户行号 当支付方式为受托支付时必输

    @Size(max = 100,message = "开户行名称长度不超过{max}位")
    private String DepBnkNm;  //开户行名称 当支付方式为受托支付时必输

    @Size(max = 100,message = "受托户名长度不超过{max}位")
    private String  EntrstdAccNm;  //受托户名 当支付方式为受托支付时必输

    @Size(max = 2,message = "是否行内账号长度不超过{max}位")
    private String  IsBnkInsidAccNo;  //是否行内账号 当支付方式为受托支付时必输

    @Size(max = 18,message = "受托金额长度不超过{max}位")
    private String  EntrstdAmt ;  //受托金额 当支付方式为受托支付时必输

    @JSONField(name = "EntrstdAccNo")
    public String getEntrstdAccNo() {
        return EntrstdAccNo;
    }

    public void setEntrstdAccNo(String entrstdAccNo) {
        EntrstdAccNo = entrstdAccNo;
    }

    @JSONField(name = "DepBnkNo")
    public String getDepBnkNo() {
        return DepBnkNo;
    }

    public void setDepBnkNo(String depBnkNo) {
        DepBnkNo = depBnkNo;
    }

    @JSONField(name = "DepBnkNm")
    public String getDepBnkNm() {
        return DepBnkNm;
    }

    public void setDepBnkNm(String depBnkNm) {
        DepBnkNm = depBnkNm;
    }

    @JSONField(name = "EntrstdAccNm")
    public String getEntrstdAccNm() {
        return EntrstdAccNm;
    }

    public void setEntrstdAccNm(String entrstdAccNm) {
        EntrstdAccNm = entrstdAccNm;
    }

    @JSONField(name = "IsBnkInsidAccNo")
    public String getIsBnkInsidAccNo() {
        return IsBnkInsidAccNo;
    }

    public void setIsBnkInsidAccNo(String isBnkInsidAccNo) {
        IsBnkInsidAccNo = isBnkInsidAccNo;
    }

    @JSONField(name = "EntrstdAmt")
    public String getEntrstdAmt() {
        return EntrstdAmt;
    }

    public void setEntrstdAmt(String entrstdAmt) {
        EntrstdAmt = entrstdAmt;
    }
}
