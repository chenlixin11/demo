package rxt.bsb.api.dto.request.query;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 3.4.1 贷款信息查询（实时模式） 请求报文
 * Created by ChenLiXin on 2019/9/18 0018 15:13
 */
public class LoanInformationReqDto implements Serializable {

    @NotBlank(message = "申请客户号不能空")
    @Size(max = 32, message = "申请客户号长度不超过{max}位")
    private String PlatCustNo;//申请客户号

    @NotBlank(message = "渠道编号不能空")
    @Size(max = 20, message = "渠道编号长度不超过{max}位")
    private String ChannelNo;//渠道编号

    @Size(max = 32, message = "提款申请编号长度不超过{max}位")
    private String FinancApplyNo;//提款申请编号

    @Size(max = 8, message = "开始日期长度不超过{max}位")
    private String  BegDate ;//开始日期 格式：yyyyMMdd

    @Size(max = 8, message = "结束日期长度不超过{max}位")
    private String  EndDate ;//结束日期 格式：yyyyMMdd

    @Size(max = 2, message = "贷款状态长度不超过{max}位")
    private String  Stat ;//贷款状态

    private PageRequest PageRequest;//分页对象

    @JSONField(name = "PlatCustNo")
    public String getPlatCustNo() {
        return PlatCustNo;
    }

    public void setPlatCustNo(String platCustNo) {
        PlatCustNo = platCustNo;
    }

    @JSONField(name = "ChannelNo")
    public String getChannelNo() {
        return ChannelNo;
    }

    public void setChannelNo(String channelNo) {
        ChannelNo = channelNo;
    }

    @JSONField(name = "FinancApplyNo")
    public String getFinancApplyNo() {
        return FinancApplyNo;
    }

    public void setFinancApplyNo(String financApplyNo) {
        FinancApplyNo = financApplyNo;
    }

    @JSONField(name = "BegDate")
    public String getBegDate() {
        return BegDate;
    }

    public void setBegDate(String begDate) {
        BegDate = begDate;
    }

    @JSONField(name = "EndDate")
    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    @JSONField(name = "Stat")
    public String getStat() {
        return Stat;
    }

    public void setStat(String stat) {
        Stat = stat;
    }

    @JSONField(name = "PageRequest")
    public rxt.bsb.api.dto.request.query.PageRequest getPageRequest() {
        return PageRequest;
    }

    public void setPageRequest(rxt.bsb.api.dto.request.query.PageRequest pageRequest) {
        PageRequest = pageRequest;
    }
}
