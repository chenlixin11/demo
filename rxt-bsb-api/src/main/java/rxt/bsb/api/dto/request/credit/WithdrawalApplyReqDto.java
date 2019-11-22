package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 3.1.3提款申请（实时模式） 请求报文
 * Created by ChenLiXin on 2019/9/17 0017 21:37
 */
public class WithdrawalApplyReqDto implements Serializable {

    @NotBlank(message = "渠道编号不能空")
    @Size(max = 20,message = "渠道编号长度不超过{max}位")
    private String ChnlNo;  //渠道编号

    @NotBlank(message = "提款申请编号不能空")
    @Size(max = 32,message = "提款申请编号长度不超过{max}位")
    private String DwmAplyNo;  //提款申请编号

    @Size(max = 32,message = "授信申请编号长度不超过{max}位")
    private String CrgAplyNp ;  //授信申请编号 当融资产品为 12：丰收贷时，此字段非必输，其他融资产品此字段必输

    @NotBlank(message = "客户编号不能空")
    @Size(max = 20,message = "客户编号长度不超过{max}位")
    private String CstNo;  //客户编号

    @NotBlank(message = "客户名称不能空")
    @Size(max = 40,message = "客户名称长度不超过{max}位")
    private String CstNm;  // 客户名称

    private String LoanAmt;  //贷款金额

    @NotBlank(message = "币种不能空")
    @Size(max =3,message = "币种长度不超过{max}位")
    private String Ccy;  //币种

    private String LoanTrm;  // 贷款期限 取值范围 1-99999

    @Size(max =2,message = "贷款期限单位长度不超过{max}位")
    private String  LoanTrmUnit;  // 贷款期限单位

    @Size(max =2,message = "支付方式长度不超过{max}位")
    private String  PyMd;  // 支付方式

    @Size(max =2,message = "还款日长度不超过{max}位")
    private String RepyDy;  // 还款日 默认显示 20(每月几号还款)

    private String RepyItrv;  // 还款间隔

    @Size(max =3,message = "还款周期长度不超过{max}位")
    private String RepyCyc;  // 还款周期

    @Size(max =2,message = "还款方式长度不超过{max}位")
    private String RpMd;  // 还款方式

    @Size(max =32,message = "模式编号长度不超过{max}位")
    private String  ModeNumber;  // 模式编号 当融资产品为 12：丰收贷时，此字段必输

    @NotBlank(message = "产品编号不能空")
    @Size(max =2,message = "产品编号长度不超过{max}位")
    private String  PdNo;  // 产品编号

    @Size(max =2,message = "证件类型长度不超过{max}位")
    private String   DocumentType;  // 证件类型 当融资产品为 12：丰收贷时，此字段必输

    @Size(max =32,message = "证件号码长度不超过{max}位")
    private String   DocumentNumber;  // 证件号码 当融资产品为 12：丰收贷时，此字段必输

    @Size(max =32,message = "贷款账号长度不超过{max}位")
    private String    AccNo ;  //贷款账号 当融资产品为 12：丰收贷时，此字段必输

    @Size(max =32,message = "还款账号长度不超过{max}位")
    private String   RepaymentAccount;  // 还款账号 当融资产品为 12：丰收贷时，此字段必输

    private List<EntrstdPayListReqDto> EntrstdPayList; //受托支付账号列表

    private List<OrdrInfoReqDto>  OrederList; //订单信息列表

    @JSONField(name = "ChnlNo")
    public String getChnlNo() {
        return ChnlNo;
    }

    public void setChnlNo(String chnlNo) {
        ChnlNo = chnlNo;
    }

    @JSONField(name = "DwmAplyNo")
    public String getDwmAplyNo() {
        return DwmAplyNo;
    }

    public void setDwmAplyNo(String dwmAplyNo) {
        DwmAplyNo = dwmAplyNo;
    }

    @JSONField(name = "CrgAplyNp")
    public String getCrgAplyNp() {
        return CrgAplyNp;
    }

    public void setCrgAplyNp(String crgAplyNp) {
        CrgAplyNp = crgAplyNp;
    }

    @JSONField(name = "CstNo")
    public String getCstNo() {
        return CstNo;
    }

    public void setCstNo(String cstNo) {
        CstNo = cstNo;
    }

    @JSONField(name = "CstNm")
    public String getCstNm() {
        return CstNm;
    }

    public void setCstNm(String cstNm) {
        CstNm = cstNm;
    }

    @JSONField(name = "LoanAmt")
    public String getLoanAmt() {
        return LoanAmt;
    }

    public void setLoanAmt(String loanAmt) {
        LoanAmt = loanAmt;
    }

    @JSONField(name = "Ccy")
    public String getCcy() {
        return Ccy;
    }

    public void setCcy(String ccy) {
        Ccy = ccy;
    }

    @JSONField(name = "LoanTrm")
    public String getLoanTrm() {
        return LoanTrm;
    }

    public void setLoanTrm(String loanTrm) {
        LoanTrm = loanTrm;
    }

    @JSONField(name = "LoanTrmUnit")
    public String getLoanTrmUnit() {
        return LoanTrmUnit;
    }

    public void setLoanTrmUnit(String loanTrmUnit) {
        LoanTrmUnit = loanTrmUnit;
    }

    @JSONField(name = "PyMd")
    public String getPyMd() {
        return PyMd;
    }

    public void setPyMd(String pyMd) {
        PyMd = pyMd;
    }

    @JSONField(name = "RepyDy")
    public String getRepyDy() {
        return RepyDy;
    }

    public void setRepyDy(String repyDy) {
        RepyDy = repyDy;
    }

    @JSONField(name = "RepyItrv")
    public String getRepyItrv() {
        return RepyItrv;
    }

    public void setRepyItrv(String repyItrv) {
        RepyItrv = repyItrv;
    }

    @JSONField(name = "RepyCyc")
    public String getRepyCyc() {
        return RepyCyc;
    }

    public void setRepyCyc(String repyCyc) {
        RepyCyc = repyCyc;
    }

    @JSONField(name = "RpMd")
    public String getRpMd() {
        return RpMd;
    }

    public void setRpMd(String rpMd) {
        RpMd = rpMd;
    }

    @JSONField(name = "ModeNumber")
    public String getModeNumber() {
        return ModeNumber;
    }

    public void setModeNumber(String modeNumber) {
        ModeNumber = modeNumber;
    }

    @JSONField(name = "PdNo")
    public String getPdNo() {
        return PdNo;
    }

    public void setPdNo(String pdNo) {
        PdNo = pdNo;
    }

    @JSONField(name = "DocumentType")
    public String getDocumentType() {
        return DocumentType;
    }

    public void setDocumentType(String documentType) {
        DocumentType = documentType;
    }

    @JSONField(name = "DocumentNumber")
    public String getDocumentNumber() {
        return DocumentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        DocumentNumber = documentNumber;
    }

    @JSONField(name = "AccNo")
    public String getAccNo() {
        return AccNo;
    }

    public void setAccNo(String accNo) {
        AccNo = accNo;
    }

    @JSONField(name = "RepaymentAccount")
    public String getRepaymentAccount() {
        return RepaymentAccount;
    }

    public void setRepaymentAccount(String repaymentAccount) {
        RepaymentAccount = repaymentAccount;
    }

    @JSONField(name = "EntrstdPayList")
    public List<EntrstdPayListReqDto> getEntrstdPayList() {
        return EntrstdPayList;
    }

    public void setEntrstdPayList(List<EntrstdPayListReqDto> entrstdPayList) {
        EntrstdPayList = entrstdPayList;
    }

    @JSONField(name = "OrederList")
    public List<OrdrInfoReqDto> getOrederList() {
        return OrederList;
    }

    public void setOrederList(List<OrdrInfoReqDto> orederList) {
        OrederList = orederList;
    }
}
