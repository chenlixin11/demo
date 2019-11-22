package rxt.bsb.api.dto.response.query;

import rxt.bsb.api.dto.request.query.PageRequest;

import java.io.Serializable;
import java.util.List;

/**
 * 3.4.3 还款计划明细查询（实时模式） 应答报文
 * Created by ChenLiXin on 2019/9/18 0018 15:54
 */
public class PaymentDetaileResDto implements Serializable {

    private List<RepayDetailDtosList> RepayDetailDtos;

    private PageRequest PageResp;

    public List<RepayDetailDtosList> getRepayDetailDtos() {
        return RepayDetailDtos;
    }

    public void setRepayDetailDtos(List<RepayDetailDtosList> repayDetailDtos) {
        RepayDetailDtos = repayDetailDtos;
    }

    public PageRequest getPageResp() {
        return PageResp;
    }

    public void setPageResp(PageRequest pageResp) {
        PageResp = pageResp;
    }
}
