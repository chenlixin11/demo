package rxt.bsb.rest.po;

import java.util.Date;

public class AgentRelationInfo {
    private Integer id;

    private Integer agentInfoId;

    private String relType;

    private String relName;

    private String relCustRelation;

    private String relPhone;

    private String relAddress;

    private String relComName;

    private String relComAddress;

    private String relComPhone;

    private Date createTime;

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

    public String getRelType() {
        return relType;
    }

    public void setRelType(String relType) {
        this.relType = relType == null ? null : relType.trim();
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName == null ? null : relName.trim();
    }

    public String getRelCustRelation() {
        return relCustRelation;
    }

    public void setRelCustRelation(String relCustRelation) {
        this.relCustRelation = relCustRelation == null ? null : relCustRelation.trim();
    }

    public String getRelPhone() {
        return relPhone;
    }

    public void setRelPhone(String relPhone) {
        this.relPhone = relPhone == null ? null : relPhone.trim();
    }

    public String getRelAddress() {
        return relAddress;
    }

    public void setRelAddress(String relAddress) {
        this.relAddress = relAddress == null ? null : relAddress.trim();
    }

    public String getRelComName() {
        return relComName;
    }

    public void setRelComName(String relComName) {
        this.relComName = relComName == null ? null : relComName.trim();
    }

    public String getRelComAddress() {
        return relComAddress;
    }

    public void setRelComAddress(String relComAddress) {
        this.relComAddress = relComAddress == null ? null : relComAddress.trim();
    }

    public String getRelComPhone() {
        return relComPhone;
    }

    public void setRelComPhone(String relComPhone) {
        this.relComPhone = relComPhone == null ? null : relComPhone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}