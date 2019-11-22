package rxt.bsb.api.dto.response.query;

import rxt.bsb.api.dto.request.query.PageRequest;

import java.io.Serializable;
import java.util.List;

/**
 * 3.4.7 还款结果查询（实时模式） 应答报文
 * Created by ChenLiXin on 2019/9/18 0018 16:53
 */
public class RepaymentResultResDto implements Serializable {

    private PageRequest  pageResponse;
    private List<ScfRepayResultQueryDtoList> ScfRepayResultQueryDtoList;

    public PageRequest getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageRequest pageResponse) {
        this.pageResponse = pageResponse;
    }

    public List<rxt.bsb.api.dto.response.query.ScfRepayResultQueryDtoList> getScfRepayResultQueryDtoList() {
        return ScfRepayResultQueryDtoList;
    }

    public void setScfRepayResultQueryDtoList(List<rxt.bsb.api.dto.response.query.ScfRepayResultQueryDtoList> scfRepayResultQueryDtoList) {
        ScfRepayResultQueryDtoList = scfRepayResultQueryDtoList;
    }
}
