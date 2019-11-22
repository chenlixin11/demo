package rxt.bsb.rest.common.Enums;

/**
 * 证件类型
 */
public enum CustTypeEnum {
    身份证("01"),
    社会统一信用证("07");
    private String code;

    CustTypeEnum(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
