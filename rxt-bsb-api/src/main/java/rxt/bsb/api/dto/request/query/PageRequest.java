package rxt.bsb.api.dto.request.query;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by ChenLiXin on 2019/9/18 0018 15:19
 */
public class PageRequest implements Serializable {

    @NotBlank(message = "页码不能空")
    @Size(max = 10, message = "页码长度不超过{max}位")
    private String PageNo;//页码
    @NotBlank(message = "每页记录数不能空")
    @Size(max = 10, message = "每页记录数长度不超过{max}位")
    private String PageSize;//每页记录数 最大 100 条

//    @Size(max = 10, message = "总记录数长度不超过{max}位")
//    private String Count;//总记录数

    @JSONField(name = "PageNo")
    public String getPageNo() {
        return PageNo;
    }

    public void setPageNo(String pageNo) {
        PageNo = pageNo;
    }

    @JSONField(name = "PageSize")
    public String getPageSize() {
        return PageSize;
    }

    public void setPageSize(String pageSize) {
        PageSize = pageSize;
    }

//    @JSONField(name = "Count")
//    public String getCount() {
//        return Count;
//    }
//
//    public void setCount(String count) {
//        Count = count;
//    }
}
