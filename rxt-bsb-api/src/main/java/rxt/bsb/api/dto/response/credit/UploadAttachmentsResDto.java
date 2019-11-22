package rxt.bsb.api.dto.response.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 附件上传 应答报文
 * Created by ChenLiXin on 2019/9/18 0018 11:17
 */
public class UploadAttachmentsResDto implements Serializable {

    private String RelNo;  //关联编号 为授信、提款申请编号，授信、提款申请接口中的申请编号保持一致

    private String BusinessTime;  //文件上传业务时间

    private String BusinessSeriNo;  //文件上传业务流水

    @JSONField(name = "RelNo")
    public String getRelNo() {
        return RelNo;
    }

    public void setRelNo(String relNo) {
        RelNo = relNo;
    }

    @JSONField(name = "BusinessTime")
    public String getBusinessTime() {
        return BusinessTime;
    }

    public void setBusinessTime(String businessTime) {
        BusinessTime = businessTime;
    }

    @JSONField(name = "BusinessSeriNo")
    public String getBusinessSeriNo() {
        return BusinessSeriNo;
    }

    public void setBusinessSeriNo(String businessSeriNo) {
        BusinessSeriNo = businessSeriNo;
    }
}
