package rxt.bsb.api.dto.request.query;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 3.4.8. 项目信息查询（实时模式）请求报文
 * Created by ChenLiXin on 2019/9/19 0019 14:39
 */
public class ProjectInfoReqDto implements Serializable {

    @NotBlank(message = "项目编号不能空")
    @Size(max = 32, message = "项目编号长度不超过{max}位")
    private String ProjNo;//项目编号

    private PageRequest PageRequest;

    @JSONField(name = "ProjNo")
    public String getProjNo() {
        return ProjNo;
    }

    public void setProjNo(String projNo) {
        ProjNo = projNo;
    }

    @JSONField(name = "PageRequest")
    public PageRequest getPageRequest() {
        return PageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        PageRequest = pageRequest;
    }
}
