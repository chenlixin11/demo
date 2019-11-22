package rxt.bsb.rest.common.Enums;

/**
 * 接口返回结果
 */
public enum InterfaceResultEnum {
    成功("1"),
    失败("0");
    private  String code;

    InterfaceResultEnum(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
