package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by ChenLiXin on 2019/9/17 0017 20:30
 */
public class EntrustReqDto implements Serializable {

    @Size(max=32,message="账号长度不能超过{max}位")
    private String  AssetNo;//账号

    @Size(max=20,message="开户行号长度不能超过{max}位")
    private String  BankNo;//开户行号

    @Size(max=100,message="开户行名称长度不能超过{max}位")
    private String  BankName;//开户行名称

    @Size(max=100,message="户名长度不能超过{max}位")
    private String  AssetName;//户名

    @Size(max=20,message="是否行内长度不能超过{max}位")
    private String  IsBaoShang;//是否行内

    @Size(max=16,message="金额长度不能超过{max}位")
    private String  Amount;//金额

    @JSONField(name = "AssetNo")
    public String getAssetNo() {
        return AssetNo;
    }

    public void setAssetNo(String assetNo) {
        AssetNo = assetNo;
    }

    @JSONField(name = "BankNo")
    public String getBankNo() {
        return BankNo;
    }

    public void setBankNo(String bankNo) {
        BankNo = bankNo;
    }

    @JSONField(name = "BankName")
    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    @JSONField(name = "AssetName")
    public String getAssetName() {
        return AssetName;
    }

    public void setAssetName(String assetName) {
        AssetName = assetName;
    }

    @JSONField(name = "IsBaoShang")
    public String getIsBaoShang() {
        return IsBaoShang;
    }

    public void setIsBaoShang(String isBaoShang) {
        IsBaoShang = isBaoShang;
    }

    @JSONField(name = "Amount")
    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
