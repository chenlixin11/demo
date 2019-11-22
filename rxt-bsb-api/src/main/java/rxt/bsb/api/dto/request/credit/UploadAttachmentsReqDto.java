package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 3.2.1 附件上传 请求报文
 * Created by ChenLiXin on 2019/9/18 0018 11:11
 */
public class UploadAttachmentsReqDto implements Serializable {
    @JsonProperty(value = "UploadFile")
    @NotBlank(message = "上传文件字节流不能空")
    private String UploadFile;  //上传文件字节流 Base64加密

    @JsonProperty(value = "FileName")
    @NotBlank(message = "文件名称不能空")
    @Size(max = 256, message = "文件名称长度不超过{max}位")
    private String FileName;  //文件名称

    @JsonProperty(value = "FileType")
    @NotBlank(message = "文件类型不能空")
    @Size(max = 10, message = "文件类型长度不超过{max}位")
    private String FileType;  //文件类型

    @JsonProperty(value = "RelNo")
    @NotBlank(message = "关联编号不能空")
    @Size(max = 64, message = "关联编号长度不超过{max}位")
    private String RelNo;  //关联编号 为授信、提款申请编号，授信、提款申请接口中的申请编号保持一致


    @JSONField(name = "UploadFile")
    public String getUploadFile() {
        return UploadFile;
    }

    public void setUploadFile(String uploadFile) {
        UploadFile = uploadFile;
    }

    @JSONField(name = "FileName")
    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    @JSONField(name = "FileType")
    public String getFileType() {
        return FileType;
    }

    public void setFileType(String fileType) {
        FileType = fileType;
    }

    @JSONField(name = "RelNo")
    public String getRelNo() {
        return RelNo;
    }

    public void setRelNo(String relNo) {
        RelNo = relNo;
    }
}
