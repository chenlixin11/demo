package rxt.bsb.api.dto.response.query;

import java.io.Serializable;

/**
 * Created by ChenLiXin on 2019/9/18 0018 16:27
 */
public class ScfPrtSignDetailDtoList implements Serializable {

    private String ContractNo;//合同编号
    private String  RegDate ;//创建日期
    private String  Stat ;//协议状态
    private String  CustType ;//客户类型
    private String  ProdNo ;//产品编号
    private String  TmplNo ;//协议模板编号
    private String  TamplName ;//协议模板名称
    private String  TamplType ;//协议模板类型
    private String  BankSignFlag ;//银行签章标记
    private String  CustIsSign ;//客户是否签章
    private String  BankIsSign ;//行方是否签章
    private String  BusinessNode ;//业务节点
    private String  UpdDate ;//签署日期
    private String  RelNo ;//申请编号

    public String getContractNo() {
        return ContractNo;
    }

    public void setContractNo(String contractNo) {
        ContractNo = contractNo;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }

    public String getStat() {
        return Stat;
    }

    public void setStat(String stat) {
        Stat = stat;
    }

    public String getCustType() {
        return CustType;
    }

    public void setCustType(String custType) {
        CustType = custType;
    }

    public String getProdNo() {
        return ProdNo;
    }

    public void setProdNo(String prodNo) {
        ProdNo = prodNo;
    }

    public String getTmplNo() {
        return TmplNo;
    }

    public void setTmplNo(String tmplNo) {
        TmplNo = tmplNo;
    }

    public String getTamplName() {
        return TamplName;
    }

    public void setTamplName(String tamplName) {
        TamplName = tamplName;
    }

    public String getTamplType() {
        return TamplType;
    }

    public void setTamplType(String tamplType) {
        TamplType = tamplType;
    }

    public String getBankSignFlag() {
        return BankSignFlag;
    }

    public void setBankSignFlag(String bankSignFlag) {
        BankSignFlag = bankSignFlag;
    }

    public String getCustIsSign() {
        return CustIsSign;
    }

    public void setCustIsSign(String custIsSign) {
        CustIsSign = custIsSign;
    }

    public String getBankIsSign() {
        return BankIsSign;
    }

    public void setBankIsSign(String bankIsSign) {
        BankIsSign = bankIsSign;
    }

    public String getBusinessNode() {
        return BusinessNode;
    }

    public void setBusinessNode(String businessNode) {
        BusinessNode = businessNode;
    }

    public String getUpdDate() {
        return UpdDate;
    }

    public void setUpdDate(String updDate) {
        UpdDate = updDate;
    }

    public String getRelNo() {
        return RelNo;
    }

    public void setRelNo(String relNo) {
        RelNo = relNo;
    }
}
