package rxt.bsb.rest.po;

public class LoanApplyOrderRel {
    private Integer id;

    private Integer loanApplyId;

    private Integer ordersInfoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanApplyId() {
        return loanApplyId;
    }

    public void setLoanApplyId(Integer loanApplyId) {
        this.loanApplyId = loanApplyId;
    }

    public Integer getOrdersInfoId() {
        return ordersInfoId;
    }

    public void setOrdersInfoId(Integer ordersInfoId) {
        this.ordersInfoId = ordersInfoId;
    }
}