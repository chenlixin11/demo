package rxt.bsb.rest.common.Enums;

/**
 * 认证状态
 */
public enum CertifiedStatusEnum {
    认证失败("0"),

    认证成功("1"),

    已提交申请("2");

    private  String code;

    CertifiedStatusEnum(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
