package rxt.bsb.api.dto.response.query;

import java.io.Serializable;

/**
 * 3.4.5. 合同协议详情查询（实时模式） 应答报文
 * Created by ChenLiXin on 2019/9/19 0019 14:48
 */
public class ContractAgreementDetailResDto implements Serializable {

    private String  DownloadFile; //下载文件字节流 Base64加密

    public String getDownloadFile() {
        return DownloadFile;
    }

    public void setDownloadFile(String downloadFile) {
        DownloadFile = downloadFile;
    }
}
