package rxt.bsb.api.dto.response.query;

import java.io.Serializable;

/**
 * 3.4.8 模式查询（实时模式） 应答报文
 * Created by ChenLiXin on 2019/9/18 0018 17:10
 */
public class PatternQueryResDto implements Serializable {


    /**
     * PatternName : 模式名称
     * ProjName : 项目名称
     * ChnlNo : 1234567
     * CreditProduct : 4
     * ReceAccType : 0
     * PatternAmt :
     * LoanPayment : 1
     * AutoPayMaxAmt : 30000
     * RepaymentMethoed : 1,2,3
     * RepyCyc : D
     * FinanceRatioMax : 0.12
     * MinInterestRate : 0.10
     * BailMinMargin : 9956700002000000009
     * PerHgamt : 200000
     * BrwrDayQotMgt : 200000
     * BlAccHgamt : 200000
     * SingleBusiMaxterm : 12
     * SingleBusiLatestdate : 30
     * ChnlDayQotMgt : 100000
     * ChnlMrgnMgt : 0.20
     * MargnAccNo : 9956700002000000001
     * WthrRvl : 0
     * WthrRvlCtr : 0
     * WthrMultiDsbr : 0
     * CustGuarant : 0
     * CoreOrderReview : 0
     * CoreRight : 0
     * SingleFamilyLoanconfirm : 0
     * IsGuarantee : 4
     * WthrRegCfm : 0
     */

    private String PatternName;//模式名称
    private String ProjName;//所属项目名称
    private String ChnlNo;//渠道号
    private String CreditProduct;//信贷产品
    private String ReceAccType;//单据类型
    private String PatternAmt;//模式额度
    private String LoanPayment;//贷款支付方式
    private String AutoPayMaxAmt;//自主支付最高金额
    private String RepaymentMethoed;//贷款还款方式
    private String RepyCyc;//还款周期
    private String FinanceRatioMax;//融资最高比例
    private String MinInterestRate;//最低比例
    private String BailMinMargin;//借款人保证金
    private String PerHgamt;//单笔最高金额
    private String BrwrDayQotMgt;//借款人日限额
    private String BlAccHgamt;//单户最高金额
    private String SingleBusiMaxterm;//单笔业务最长期限
    private String SingleBusiLatestdate;//单笔业务最迟到期日
    private String ChnlDayQotMgt;//渠道日限额
    private String ChnlMrgnMgt;//渠道保证金比例
    private String MargnAccNo;//渠道保证金账号
    private String WthrRvl;//是否循环
    private String WthrRvlCtr;//是否循环合同
    private String WthrMultiDsbr;//是否多次放款
    private String CustGuarant;//是否核心方担保
    private String CoreOrderReview;//核心方订单审查
    private String CoreRight;//是否核心方确权
    private String SingleFamilyLoanconfirm;//核心方单户放款确认
    private String IsGuarantee;//是否实际控制人担保
    private String WthrRegCfm;//是否仓储监管方确认

    public String getPatternName() {
        return PatternName;
    }

    public void setPatternName(String PatternName) {
        this.PatternName = PatternName;
    }

    public String getProjName() {
        return ProjName;
    }

    public void setProjName(String ProjName) {
        this.ProjName = ProjName;
    }

    public String getChnlNo() {
        return ChnlNo;
    }

    public void setChnlNo(String ChnlNo) {
        this.ChnlNo = ChnlNo;
    }

    public String getCreditProduct() {
        return CreditProduct;
    }

    public void setCreditProduct(String CreditProduct) {
        this.CreditProduct = CreditProduct;
    }

    public String getReceAccType() {
        return ReceAccType;
    }

    public void setReceAccType(String ReceAccType) {
        this.ReceAccType = ReceAccType;
    }

    public String getPatternAmt() {
        return PatternAmt;
    }

    public void setPatternAmt(String PatternAmt) {
        this.PatternAmt = PatternAmt;
    }

    public String getLoanPayment() {
        return LoanPayment;
    }

    public void setLoanPayment(String LoanPayment) {
        this.LoanPayment = LoanPayment;
    }

    public String getAutoPayMaxAmt() {
        return AutoPayMaxAmt;
    }

    public void setAutoPayMaxAmt(String AutoPayMaxAmt) {
        this.AutoPayMaxAmt = AutoPayMaxAmt;
    }

    public String getRepaymentMethoed() {
        return RepaymentMethoed;
    }

    public void setRepaymentMethoed(String RepaymentMethoed) {
        this.RepaymentMethoed = RepaymentMethoed;
    }

    public String getRepyCyc() {
        return RepyCyc;
    }

    public void setRepyCyc(String RepyCyc) {
        this.RepyCyc = RepyCyc;
    }

    public String getFinanceRatioMax() {
        return FinanceRatioMax;
    }

    public void setFinanceRatioMax(String FinanceRatioMax) {
        this.FinanceRatioMax = FinanceRatioMax;
    }

    public String getMinInterestRate() {
        return MinInterestRate;
    }

    public void setMinInterestRate(String MinInterestRate) {
        this.MinInterestRate = MinInterestRate;
    }

    public String getBailMinMargin() {
        return BailMinMargin;
    }

    public void setBailMinMargin(String BailMinMargin) {
        this.BailMinMargin = BailMinMargin;
    }

    public String getPerHgamt() {
        return PerHgamt;
    }

    public void setPerHgamt(String PerHgamt) {
        this.PerHgamt = PerHgamt;
    }

    public String getBrwrDayQotMgt() {
        return BrwrDayQotMgt;
    }

    public void setBrwrDayQotMgt(String BrwrDayQotMgt) {
        this.BrwrDayQotMgt = BrwrDayQotMgt;
    }

    public String getBlAccHgamt() {
        return BlAccHgamt;
    }

    public void setBlAccHgamt(String BlAccHgamt) {
        this.BlAccHgamt = BlAccHgamt;
    }

    public String getSingleBusiMaxterm() {
        return SingleBusiMaxterm;
    }

    public void setSingleBusiMaxterm(String SingleBusiMaxterm) {
        this.SingleBusiMaxterm = SingleBusiMaxterm;
    }

    public String getSingleBusiLatestdate() {
        return SingleBusiLatestdate;
    }

    public void setSingleBusiLatestdate(String SingleBusiLatestdate) {
        this.SingleBusiLatestdate = SingleBusiLatestdate;
    }

    public String getChnlDayQotMgt() {
        return ChnlDayQotMgt;
    }

    public void setChnlDayQotMgt(String ChnlDayQotMgt) {
        this.ChnlDayQotMgt = ChnlDayQotMgt;
    }

    public String getChnlMrgnMgt() {
        return ChnlMrgnMgt;
    }

    public void setChnlMrgnMgt(String ChnlMrgnMgt) {
        this.ChnlMrgnMgt = ChnlMrgnMgt;
    }

    public String getMargnAccNo() {
        return MargnAccNo;
    }

    public void setMargnAccNo(String MargnAccNo) {
        this.MargnAccNo = MargnAccNo;
    }

    public String getWthrRvl() {
        return WthrRvl;
    }

    public void setWthrRvl(String WthrRvl) {
        this.WthrRvl = WthrRvl;
    }

    public String getWthrRvlCtr() {
        return WthrRvlCtr;
    }

    public void setWthrRvlCtr(String WthrRvlCtr) {
        this.WthrRvlCtr = WthrRvlCtr;
    }

    public String getWthrMultiDsbr() {
        return WthrMultiDsbr;
    }

    public void setWthrMultiDsbr(String WthrMultiDsbr) {
        this.WthrMultiDsbr = WthrMultiDsbr;
    }

    public String getCustGuarant() {
        return CustGuarant;
    }

    public void setCustGuarant(String CustGuarant) {
        this.CustGuarant = CustGuarant;
    }

    public String getCoreOrderReview() {
        return CoreOrderReview;
    }

    public void setCoreOrderReview(String CoreOrderReview) {
        this.CoreOrderReview = CoreOrderReview;
    }

    public String getCoreRight() {
        return CoreRight;
    }

    public void setCoreRight(String CoreRight) {
        this.CoreRight = CoreRight;
    }

    public String getSingleFamilyLoanconfirm() {
        return SingleFamilyLoanconfirm;
    }

    public void setSingleFamilyLoanconfirm(String SingleFamilyLoanconfirm) {
        this.SingleFamilyLoanconfirm = SingleFamilyLoanconfirm;
    }

    public String getIsGuarantee() {
        return IsGuarantee;
    }

    public void setIsGuarantee(String IsGuarantee) {
        this.IsGuarantee = IsGuarantee;
    }

    public String getWthrRegCfm() {
        return WthrRegCfm;
    }

    public void setWthrRegCfm(String WthrRegCfm) {
        this.WthrRegCfm = WthrRegCfm;
    }
}
