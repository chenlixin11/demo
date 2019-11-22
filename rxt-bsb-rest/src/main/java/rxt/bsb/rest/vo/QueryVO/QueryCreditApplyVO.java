package rxt.bsb.rest.vo.QueryVO;


/**
 * 查询授信申请信息VO
 */
public class QueryCreditApplyVO {

    private String custName; //客户名称

    private String custNo;//客户编号

        private String creditApplyNo;//授信申请编号

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCreditApplyNo() {
        return creditApplyNo;
    }

    public void setCreditApplyNo(String creditApplyNo) {
        this.creditApplyNo = creditApplyNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

}
