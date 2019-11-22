package rxt.bsb.rest.vo.showVO;

import java.io.Serializable;
import java.util.Date;

/**
 * 开子账户信息
 */
public class ShowCustomOpenSubAcctInfoVO implements Serializable {


    private String  custNo; //客户编号

    private String  custName; //客户名称

    private String  custType; //证件类型

    private String  certNo; //证件号码

    private String certValidDate;//证件有效期

    private String certStartDate;//证件起始日

    private String certLengthDate;//证件到期日

    private String legalRealName;//法人姓名

    private String legalCertType;//法人证件类型

    private String legalCertNo;//法人证件号码

    private String email;//电子邮箱

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCertValidDate() {
        return certValidDate;
    }

    public void setCertValidDate(String certValidDate) {
        this.certValidDate = certValidDate;
    }

    public String getCertStartDate() {
        return certStartDate;
    }

    public void setCertStartDate(String certStartDate) {
        this.certStartDate = certStartDate;
    }

    public String getCertLengthDate() {
        return certLengthDate;
    }

    public void setCertLengthDate(String certLengthDate) {
        this.certLengthDate = certLengthDate;
    }

    public String getLegalRealName() {
        return legalRealName;
    }

    public void setLegalRealName(String legalRealName) {
        this.legalRealName = legalRealName;
    }

    public String getLegalCertType() {
        return legalCertType;
    }

    public void setLegalCertType(String legalCertType) {
        this.legalCertType = legalCertType;
    }

    public String getLegalCertNo() {
        return legalCertNo;
    }

    public void setLegalCertNo(String legalCertNo) {
        this.legalCertNo = legalCertNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
