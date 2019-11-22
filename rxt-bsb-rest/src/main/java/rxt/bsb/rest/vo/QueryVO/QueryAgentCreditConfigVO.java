package rxt.bsb.rest.vo.QueryVO;


/**
 * 查询授信申请信息VO
 */
public class QueryAgentCreditConfigVO {

    private String custName; //客户名称

    private String custNo;//客户编号

    private String isStopLoan;//是否停贷，0：否，1：是

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

    public String getIsStopLoan() {
        return isStopLoan;
    }

    public void setIsStopLoan(String isStopLoan) {
        this.isStopLoan = isStopLoan;
    }
}
