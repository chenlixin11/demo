package rxt.bsb.api.dto.request.query;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 3.4.9. 模式查询（实时模式） 请求报文
 * Created by ChenLiXin on 2019/9/19 0019 14:41
 */
public class PatternQueryReqDto implements Serializable {

    @NotBlank(message = "模式编号不能空")
    @Size(max = 32, message = "模式编号长度不超过{max}位")
    private String PatternNo;//模式编号

    @JSONField(name = "PatternNo")
    public String getPatternNo() {
        return PatternNo;
    }

    public void setPatternNo(String patternNo) {
        PatternNo = patternNo;
    }
}
