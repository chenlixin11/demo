package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

//4.1.3.3. 会员账户信息修改
public class UpdateSubAcctNoReqDto implements Serializable {

    @NotBlank(message = "资金账号不能空")
    @Size(max = 11,message = "资金账号长度不超过{max}位")
    private String SubAcctNo;//资金账号
    @Size(max = 11,message = "手机号长度不超过{max}位")
    private String NewMobileNo;//手机号
    @Size(max = 11,message = "法人代表长度不超过{max}位")
    private String LegalRealName;//法人代表
    @Size(max = 11,message = "法人证件类型长度不超过{max}位")
    private String LegalCertType;//法人证件类型
    @Size(max = 11,message = "法人证件号码长度不超过{max}位")
    private String LegalCertNo;//法人证件号码
    @Size(max = 11,message = "邮箱长度不超过{max}位")
    private String Email;//邮箱
    @Size(max = 11,message = "证件有效期长度不超过{max}位")
    private String CertValidDate;//证件有效期
    @Size(max = 11,message = "国籍长度不超过{max}位")
    private String Nationality;//国籍
    @Size(max = 11,message = "注册地长度不超过{max}位")
    private String RegisteredPlace;//注册地
    @Size(max = 11,message = "经营地长度不超过{max}位")
    private String BusinessPlace;//经营地
    @Size(max = 11,message = "经营主体类型长度不超过{max}位")
    private String EntityType;//经营主体类型

    @JSONField(name = "SubAcctNo")
    public String getSubAcctNo() {
        return SubAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        SubAcctNo = subAcctNo;
    }

    @JSONField(name = "NewMobileNo")
    public String getNewMobileNo() {
        return NewMobileNo;
    }

    public void setNewMobileNo(String newMobileNo) {
        NewMobileNo = newMobileNo;
    }

    @JSONField(name = "LegalRealName")
    public String getLegalRealName() {
        return LegalRealName;
    }

    public void setLegalRealName(String legalRealName) {
        LegalRealName = legalRealName;
    }

    @JSONField(name = "LegalCertType")
    public String getLegalCertType() {
        return LegalCertType;
    }

    public void setLegalCertType(String legalCertType) {
        LegalCertType = legalCertType;
    }

    @JSONField(name = "LegalCertNo")
    public String getLegalCertNo() {
        return LegalCertNo;
    }

    public void setLegalCertNo(String legalCertNo) {
        LegalCertNo = legalCertNo;
    }

    @JSONField(name = "Email")
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @JSONField(name = "CertValidDate")
    public String getCertValidDate() {
        return CertValidDate;
    }

    public void setCertValidDate(String certValidDate) {
        CertValidDate = certValidDate;
    }

    @JSONField(name = "Nationality")
    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    @JSONField(name = "RegisteredPlace")
    public String getRegisteredPlace() {
        return RegisteredPlace;
    }

    public void setRegisteredPlace(String registeredPlace) {
        RegisteredPlace = registeredPlace;
    }

    @JSONField(name = "BusinessPlace")
    public String getBusinessPlace() {
        return BusinessPlace;
    }

    public void setBusinessPlace(String businessPlace) {
        BusinessPlace = businessPlace;
    }

    @JSONField(name = "EntityType")
    public String getEntityType() {
        return EntityType;
    }

    public void setEntityType(String entityType) {
        EntityType = entityType;
    }
}
