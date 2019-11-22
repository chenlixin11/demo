package rxt.bsb.api.dto.response;

import java.io.Serializable;
//商户文件下载应答报文
public class BusinessFileDownloadResDto implements Serializable {

    private String FileData;

    public String getFileData() {
        return FileData;
    }

    public void setFileData(String fileData) {
        FileData = fileData;
    }
}
