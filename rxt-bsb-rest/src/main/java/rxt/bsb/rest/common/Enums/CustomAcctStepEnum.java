package rxt.bsb.rest.common.Enums;

/**
 * 客户开户步骤
 */
public enum CustomAcctStepEnum {
    开通子账户("1"),
    绑定结算账户("2"),
    支付认证("3"),
    开户完成("4");

    private String code;
    CustomAcctStepEnum( String code){
         this.code = code;
    }

    public String getCode() {
        return code;
    }

}
