package rxt.bsb.rest.common.Enums;

/**
 * 绑定结算账户状态
 */
public enum BindClearAcctStatusEnum {

    绑定失败("0"),

    绑定成功("1"),

    已提交申请("2");

    private  String code;

    BindClearAcctStatusEnum(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
