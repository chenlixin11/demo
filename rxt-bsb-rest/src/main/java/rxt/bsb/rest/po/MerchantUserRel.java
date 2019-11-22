package rxt.bsb.rest.po;

public class MerchantUserRel {
    private Integer id;

    private Integer merchantInfoId;

    private Integer userInfoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantInfoId() {
        return merchantInfoId;
    }

    public void setMerchantInfoId(Integer merchantInfoId) {
        this.merchantInfoId = merchantInfoId;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }
}