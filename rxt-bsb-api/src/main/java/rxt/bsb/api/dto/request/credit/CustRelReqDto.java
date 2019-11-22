package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * Created by ChenLiXin on 2019/9/17 0017 20:26
 */
public class CustRelReqDto implements Serializable {


    @NotBlank(message="关系类型不能空")
    @Size(max=2,message="关系类型长度不能超过{max}位")
    private String RelType ;//关系类型  01  直属联系人 02  其他联系人

    @NotBlank(message="关系人姓名不能空")
    @Size(max=40,message="关系人姓名长度不能超过{max}位")
    private String RelName ;//关系人姓名

    @NotBlank(message="与申请人关系不能空")
    @Size(max=2,message="与申请人关系长度不能超过{max}位")
    private String RelCustRelation ;//与申请人关系 01 父母02 配偶03 子女04 兄弟姐妹05 朋友06 同事07 合伙人08 其他

    @NotBlank(message="关系人联系电话不能空")
    @Size(max=25,message="关系人联系电话长度不能超过{max}位")
    private String RelPhone ;//关系人联系电话

    @NotBlank(message="关系人家庭住址不能空")
    @Size(max=30,message="关系人家庭住址长度不能超过{max}位")
    private String RelAddress ;//关系人家庭住址

    @Size(max=30,message="关系人单位名称长度不能超过{max}位")
    private String RelComName ;//关系人单位名称

    @Size(max=30,message="关系人单位地址长度不能超过{max}位")
    private String RelComAddress ;//关系人单位地址

    @Size(max=25,message="关系人单位电话长度不能超过{max}位")
    private String RelComPhone ;//关系人单位电话

    @JSONField(name="RelType")
    public String getRelType() {
        return RelType;
    }

    public void setRelType(String relType) {
        RelType = relType;
    }

    @JSONField(name="RelName")
    public String getRelName() {
        return RelName;
    }

    public void setRelName(String relName) {
        RelName = relName;
    }

    @JSONField(name="RelCustRelation")
    public String getRelCustRelation() {
        return RelCustRelation;
    }

    public void setRelCustRelation(String relCustRelation) {
        RelCustRelation = relCustRelation;
    }

    @JSONField(name="RelPhone")
    public String getRelPhone() {
        return RelPhone;
    }

    public void setRelPhone(String relPhone) {
        RelPhone = relPhone;
    }

    @JSONField(name="RelAddress")
    public String getRelAddress() {
        return RelAddress;
    }

    public void setRelAddress(String relAddress) {
        RelAddress = relAddress;
    }

    @JSONField(name="RelComName")
    public String getRelComName() {
        return RelComName;
    }

    public void setRelComName(String relComName) {
        RelComName = relComName;
    }

    @JSONField(name="RelComAddress")
    public String getRelComAddress() {
        return RelComAddress;
    }

    public void setRelComAddress(String relComAddress) {
        RelComAddress = relComAddress;
    }

    @JSONField(name="RelComPhone")
    public String getRelComPhone() {
        return RelComPhone;
    }

    public void setRelComPhone(String relComPhone) {
        RelComPhone = relComPhone;
    }
}
