package rxt.bsb.rest.po;

public class CreditApplyOrderRel {
    private Integer id;

    private Integer creditApplyId;

    private Integer ordersInfoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreditApplyId() {
        return creditApplyId;
    }

    public void setCreditApplyId(Integer creditApplyId) {
        this.creditApplyId = creditApplyId;
    }

    public Integer getOrdersInfoId() {
        return ordersInfoId;
    }

    public void setOrdersInfoId(Integer ordersInfoId) {
        this.ordersInfoId = ordersInfoId;
    }
}