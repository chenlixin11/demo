package rxt.bsb.rest.common.Enums;

/**
 * 提交状态
 */
public enum ApplySubmitStatusEnum {
    未提交申请("0"),
    已提交申请("1");
    private  String code;
    ApplySubmitStatusEnum(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
