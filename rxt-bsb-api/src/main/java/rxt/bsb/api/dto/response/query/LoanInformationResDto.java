package rxt.bsb.api.dto.response.query;

import rxt.bsb.api.dto.request.query.PageRequest;

import java.io.Serializable;
import java.util.List;

/**
 * 3.4.1 贷款信息查询（实时模式） 应答报文
 * Created by ChenLiXin on 2019/9/18 0018 15:26
 */
public class LoanInformationResDto implements Serializable {

    private PageRequest pageResponse;//分页对象

    private List<ListScfLoanInfoDosDto> ListScfLoanInfoDos;

    public PageRequest getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageRequest pageResponse) {
        this.pageResponse = pageResponse;
    }

    public List<ListScfLoanInfoDosDto> getListScfLoanInfoDos() {
        return ListScfLoanInfoDos;
    }

    public void setListScfLoanInfoDos(List<ListScfLoanInfoDosDto> listScfLoanInfoDos) {
        ListScfLoanInfoDos = listScfLoanInfoDos;
    }
}
