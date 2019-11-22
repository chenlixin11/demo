package rxt.bsb.api.dto.response.notice;

import java.io.Serializable;

/**
 * 通知管理的 应答报文
 * Created by ChenLiXin on 2019/9/18 0018 14:51
 */
public class NotifyResultResDto implements Serializable {

    private String  RetCode;//返回码
    private String  RetInfo;//返回信息
    private String  AuthURL; //网关页面 URL
    private String  AuthTokenID; //网关令牌校验码

    public String getRetCode() {
        return RetCode;
    }

    public void setRetCode(String retCode) {
        RetCode = retCode;
    }

    public String getRetInfo() {
        return RetInfo;
    }

    public void setRetInfo(String retInfo) {
        RetInfo = retInfo;
    }

    public String getAuthURL() {
        return AuthURL;
    }

    public void setAuthURL(String authURL) {
        AuthURL = authURL;
    }

    public String getAuthTokenID() {
        return AuthTokenID;
    }

    public void setAuthTokenID(String authTokenID) {
        AuthTokenID = authTokenID;
    }
}
