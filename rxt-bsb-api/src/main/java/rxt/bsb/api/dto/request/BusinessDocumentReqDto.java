package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 商户文件上传/下载 请求报文
 */
public class BusinessDocumentReqDto implements Serializable {

    @NotBlank(message = "文件名称不能空")
    @Size(max = 256,message = "文件名称不能超过{max}位")
    private String FileName;
    @Size(max = 1024*1024,message = "文件内容不能超过{max}位")
    private String FileData;

    @JSONField(name = "FileName")
    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    @JSONField(name = "FileData")
    public String getFileData() {
        return FileData;
    }

    public void setFileData(String fileData) {
        FileData = fileData;
    }
}
