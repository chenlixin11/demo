package rxt.bsb.api.dto.response.notice;

import java.io.Serializable;

/**
 * 4.3 合同签署 应答报文
 * Created by ChenLiXin on 2019/9/19 0019 17:01
 */
public class ContractSignResDto implements Serializable  {

    private String AuthURL;  //网关页面 URL 商户平台根据此 URL 进行网关页面链接跳转

    public String getAuthURL() {
        return AuthURL;
    }

    public void setAuthURL(String authURL) {
        AuthURL = authURL;
    }
}
