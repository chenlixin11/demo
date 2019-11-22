package rxt.bsb.api.dto.request.query;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 3.4.7 还款结果查询（实时模式） 请求报文
 * Created by ChenLiXin on 2019/9/18 0018 16:43
 */
public class RepaymentResultReqDto implements Serializable {

    @NotBlank(message = "申请客户号不能空")
    @Size(max = 32, message = "申请客户号长度不超过{max}位")
    private String PlatCustNo;//申请客户号

    @NotBlank(message = "渠道编号不能空")
    @Size(max = 20, message = "渠道编号长度不超过{max}位")
    private String ChannelNo;//渠道编号

    @Size(max = 32, message = "融资申请编号长度不超过{max}位")
    private String FinancApplyNo;//融资申请编号

    @Size(max = 2, message = "还款范围长度不超过{max}位")
    private String RepayType;//还款范围

    @Size(max = 2, message = "还款状态长度不超过{max}位")
    private String RepayStat;//还款状态

    @Size(max = 8, message = "开始日期长度不超过{max}位")
    private String RepayStartDate;//开始日期

    @Size(max = 8, message = "结束日期长度不超过{max}位")
    private String RepayEndDate;//结束日期

    private PageRequest  PageRequest;

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

    @JSONField(name = "RepayType")
    public String getRepayType() {
        return RepayType;
    }

    public void setRepayType(String repayType) {
        RepayType = repayType;
    }

    @JSONField(name = "RepayStat")
    public String getRepayStat() {
        return RepayStat;
    }

    public void setRepayStat(String repayStat) {
        RepayStat = repayStat;
    }

    @JSONField(name = "RepayStartDate")
    public String getRepayStartDate() {
        return RepayStartDate;
    }

    public void setRepayStartDate(String repayStartDate) {
        RepayStartDate = repayStartDate;
    }

    @JSONField(name = "RepayEndDate")
    public String getRepayEndDate() {
        return RepayEndDate;
    }

    public void setRepayEndDate(String repayEndDate) {
        RepayEndDate = repayEndDate;
    }

    @JSONField(name = "PageRequest")
    public rxt.bsb.api.dto.request.query.PageRequest getPageRequest() {
        return PageRequest;
    }

    public void setPageRequest(rxt.bsb.api.dto.request.query.PageRequest pageRequest) {
        PageRequest = pageRequest;
    }
}
