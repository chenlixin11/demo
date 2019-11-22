package rxt.bsb.rest.common.Enums;

/**
 * 子账户开户状态
 */
public enum OpenSubAcctStatusEnum {
    注销("0"),
    正常("1"),
    冻结("5"),
    已提交申请("99"),
    开户失败("98");

    private String code;

    OpenSubAcctStatusEnum (String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
