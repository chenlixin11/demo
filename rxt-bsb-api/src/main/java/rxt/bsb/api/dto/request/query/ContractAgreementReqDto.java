package rxt.bsb.api.dto.request.query;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 3.4.4 合同协议列表查询（实时模式） 请求报文
 * Created by ChenLiXin on 2019/9/18 0018 16:06
 */
public class ContractAgreementReqDto implements Serializable {

    private String BusinessNode;//业务节点
    private String Stat;//合同状态
    private String IsCore;//是否核心企业

    @NotBlank(message = "第三方平台客户号不能空")
    @Size(max = 20, message = "第三方平台客户号长度不超过{max}位")
    private String PlatCustNo;// 第三方平台客户号

    @NotBlank(message = "第三方渠道号不能空")
    @Size(max = 32, message = "第三方渠道号长度不超过{max}位")
    private String ApplySubChannel;// 第三方渠道号

    @Size(max = 32, message = "第三方申请编号长度不超过{max}位")
    private String PlatApplyNo;// 第三方申请编号

    @Size(max = 8, message = "查询开始日期长度不超过{max}位")
    private String StartDate;// 查询开始日期

    @Size(max = 8, message = "查询结束日期长度不超过{max}位")
    private String EndDate;// 查询结束日期

    private  PageRequest PageRequest ;// 分页对象

    @JSONField(name = "BusinessNode")
    public String getBusinessNode() {
        return BusinessNode;
    }

    public void setBusinessNode(String businessNode) {
        BusinessNode = businessNode;
    }

    @JSONField(name = "Stat")
    public String getStat() {
        return Stat;
    }

    public void setStat(String stat) {
        Stat = stat;
    }

    @JSONField(name = "IsCore")
    public String getIsCore() {
        return IsCore;
    }

    public void setIsCore(String isCore) {
        IsCore = isCore;
    }

    @JSONField(name = "PlatCustNo")
    public String getPlatCustNo() {
        return PlatCustNo;
    }

    public void setPlatCustNo(String platCustNo) {
        PlatCustNo = platCustNo;
    }

    @JSONField(name = "ApplySubChannel")
    public String getApplySubChannel() {
        return ApplySubChannel;
    }

    public void setApplySubChannel(String applySubChannel) {
        ApplySubChannel = applySubChannel;
    }

    @JSONField(name = "PlatApplyNo")
    public String getPlatApplyNo() {
        return PlatApplyNo;
    }

    public void setPlatApplyNo(String platApplyNo) {
        PlatApplyNo = platApplyNo;
    }

    @JSONField(name = "StartDate")
    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    @JSONField(name = "EndDate")
    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    @JSONField(name = "PageRequest")
    public PageRequest getPageRequest() {
        return PageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        PageRequest = pageRequest;
    }
}
