package rxt.bsb.api.dto.response.query;

import rxt.bsb.api.dto.request.query.PageRequest;

import java.io.Serializable;
import java.util.List;

/**
 * 3.4.4.合同协议列表查询（实时模式） 应答报文
 * Created by ChenLiXin on 2019/9/18 0018 16:24
 */
public class ContractAgreementResDto implements Serializable {

    private List<ScfPrtSignDetailDtoList> ScfPrtSignDetailDtoList;

    private PageRequest PageResp;

    public List<rxt.bsb.api.dto.response.query.ScfPrtSignDetailDtoList> getScfPrtSignDetailDtoList() {
        return ScfPrtSignDetailDtoList;
    }

    public void setScfPrtSignDetailDtoList(List<rxt.bsb.api.dto.response.query.ScfPrtSignDetailDtoList> scfPrtSignDetailDtoList) {
        ScfPrtSignDetailDtoList = scfPrtSignDetailDtoList;
    }

    public PageRequest getPageResp() {
        return PageResp;
    }

    public void setPageResp(PageRequest pageResp) {
        PageResp = pageResp;
    }
}
