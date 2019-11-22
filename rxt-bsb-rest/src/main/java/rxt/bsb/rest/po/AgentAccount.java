package rxt.bsb.rest.po;

import java.util.Date;

public class AgentAccount {
    private Integer id;

    private Integer agentInfoId;

    private String custNo;

    private String custType;

    private String certType;

    private String certNo;

    private String certValidDate;//证件有效期

    private String certStartDate;//证件起始日

    private String certLengthDate;//证件到期日

    private String subacctNo;

    private String subacctNoStatus;

    private String repaySubacctNo;

    private String repaySubacctNoStatus;

    private String legalRealName;//法人姓名

    private String legalCertType;//法人证件类型

    private String legalCertNo;//法人证件号码

    private String agentName; //经办人

    private String agentCertType;//经办人证件类型（01:身份证）

    private String agentCertNo;//经办人证件号

    private String agentMobileNo;//经办人手机号

    private String ukeyBindStatus;

    private Date openAcctTime;

    private Date createTime;

    private String openAcctStep;//开户步骤 1：开户 2：绑定结算账户 3：支付认证 4:开户完成

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgentInfoId() {
        return agentInfoId;
    }

    public void setAgentInfoId(Integer agentInfoId) {
        this.agentInfoId = agentInfoId;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType == null ? null : custType.trim();
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
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

    public String getSubacctNo() {
        return subacctNo;
    }

    public void setSubacctNo(String subacctNo) {
        this.subacctNo = subacctNo == null ? null : subacctNo.trim();
    }

    public String getSubacctNoStatus() {
        return subacctNoStatus;
    }

    public void setSubacctNoStatus(String subacctNoStatus) {
        this.subacctNoStatus = subacctNoStatus == null ? null : subacctNoStatus.trim();
    }

    public String getRepaySubacctNo() {
        return repaySubacctNo;
    }

    public void setRepaySubacctNo(String repaySubacctNo) {
        this.repaySubacctNo = repaySubacctNo == null ? null : repaySubacctNo.trim();
    }

    public String getRepaySubacctNoStatus() {
        return repaySubacctNoStatus;
    }

    public void setRepaySubacctNoStatus(String repaySubacctNoStatus) {
        this.repaySubacctNoStatus = repaySubacctNoStatus == null ? null : repaySubacctNoStatus.trim();
    }

    public String getLegalRealName() {
        return legalRealName;
    }

    public void setLegalRealName(String legalRealName) {
        this.legalRealName = legalRealName == null ? null : legalRealName.trim();
    }

    public String getLegalCertType() {
        return legalCertType;
    }

    public void setLegalCertType(String legalCertType) {
        this.legalCertType = legalCertType == null ? null : legalCertType.trim();
    }

    public String getLegalCertNo() {
        return legalCertNo;
    }

    public void setLegalCertNo(String legalCertNo) {
        this.legalCertNo = legalCertNo == null ? null : legalCertNo.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getAgentCertType() {
        return agentCertType;
    }

    public void setAgentCertType(String agentCertType) {
        this.agentCertType = agentCertType == null ? null : agentCertType.trim();
    }

    public String getAgentCertNo() {
        return agentCertNo;
    }

    public void setAgentCertNo(String agentCertNo) {
        this.agentCertNo = agentCertNo == null ? null : agentCertNo.trim();
    }

    public String getAgentMobileNo() {
        return agentMobileNo;
    }

    public void setAgentMobileNo(String agentMobileNo) {
        this.agentMobileNo = agentMobileNo == null ? null : agentMobileNo.trim();
    }

    public String getUkeyBindStatus() {
        return ukeyBindStatus;
    }

    public void setUkeyBindStatus(String ukeyBindStatus) {
        this.ukeyBindStatus = ukeyBindStatus == null ? null : ukeyBindStatus.trim();
    }

    public Date getOpenAcctTime() {
        return openAcctTime;
    }

    public void setOpenAcctTime(Date openAcctTime) {
        this.openAcctTime = openAcctTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOpenAcctStep() {
        return openAcctStep;
    }

    public void setOpenAcctStep(String openAcctStep) {
        this.openAcctStep = openAcctStep;
    }

}