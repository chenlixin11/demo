package rxt.bsb.api.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

//回单打印
public class BackOrderPrinReqDto implements Serializable {

    @Size(max = 50,message = "回单唯一编号长度不能超过{max}位")
    @NotBlank(message = "回单唯一编号不能空")
    private String InnerNo;

    @Size(max = 100,message = "回单文件名称长度不能超过{max}位")
    @NotBlank(message = "回单文件名称不能空")
    private String FileName;

    @JSONField(name = "InnerNo")
    public String getInnerNo() {
        return InnerNo;
    }

    public void setInnerNo(String innerNo) {
        InnerNo = innerNo;
    }

    @JSONField(name = "FileName")
    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }
}
