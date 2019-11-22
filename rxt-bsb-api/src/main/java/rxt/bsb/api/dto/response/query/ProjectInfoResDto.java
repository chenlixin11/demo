package rxt.bsb.api.dto.response.query;

import rxt.bsb.api.dto.request.query.PageRequest;

import java.io.Serializable;
import java.util.List;

/**
 * 3.4.8 项目信息查询（实时模式） 应答报文
 * Created by ChenLiXin on 2019/9/18 0018 17:02
 */
public class ProjectInfoResDto implements Serializable {


    /**
     * ProjNo : 10086
     * ProjName : 测试项目
     * ProjAmt : 1000
     * ProjAmtDeadline : 12
     * ProjAmtEffdate : 20190101
     * ProjAmtDuedate : 20200101
     * ScfPatternDtos : [{"PatternNo":"10010","PatternName":"模式 1","ChnlNo":"123456","PatternType":"1","CreditProduct":"4"},{"PatternNo":"10011","PatternName":"模式 2","ChnlNo":"123456","PatternType":"1","CreditProduct":"5"}]
     */

    private String ProjNo;//项目编号
    private String ProjName;//项目名称
    private String ProjAmt;//项目额度
    private Integer ProjAmtDeadline;//项目期限 项目期限(月)
    private String ProjAmtEffdate;//项目生效日期
    private String ProjAmtDuedate;//项目到期日
    private List<ScfPatternDtosBean> ScfPatternDtos;//
    private PageRequest PageResp;//分页模式

    public String getProjNo() {
        return ProjNo;
    }

    public void setProjNo(String ProjNo) {
        this.ProjNo = ProjNo;
    }

    public String getProjName() {
        return ProjName;
    }

    public void setProjName(String ProjName) {
        this.ProjName = ProjName;
    }

    public String getProjAmt() {
        return ProjAmt;
    }

    public void setProjAmt(String ProjAmt) {
        this.ProjAmt = ProjAmt;
    }

    public Integer getProjAmtDeadline() {
        return ProjAmtDeadline;
    }

    public void setProjAmtDeadline(Integer ProjAmtDeadline) {
        this.ProjAmtDeadline = ProjAmtDeadline;
    }

    public String getProjAmtEffdate() {
        return ProjAmtEffdate;
    }

    public void setProjAmtEffdate(String ProjAmtEffdate) {
        this.ProjAmtEffdate = ProjAmtEffdate;
    }

    public String getProjAmtDuedate() {
        return ProjAmtDuedate;
    }

    public void setProjAmtDuedate(String ProjAmtDuedate) {
        this.ProjAmtDuedate = ProjAmtDuedate;
    }

    public List<ScfPatternDtosBean> getScfPatternDtos() {
        return ScfPatternDtos;
    }

    public void setScfPatternDtos(List<ScfPatternDtosBean> ScfPatternDtos) {
        this.ScfPatternDtos = ScfPatternDtos;
    }

    public static class ScfPatternDtosBean {
        /**
         * PatternNo : 10010
         * PatternName : 模式 1
         * ChnlNo : 123456
         * PatternType : 1
         * CreditProduct : 4
         */

        private String PatternNo;//模式编号
        private String PatternName;//模式名称
        private String ChnlNo;//渠道号
        private String PatternType;//模式状态
        private String CreditProduct;//融资产品

        public String getPatternNo() {
            return PatternNo;
        }

        public void setPatternNo(String PatternNo) {
            this.PatternNo = PatternNo;
        }

        public String getPatternName() {
            return PatternName;
        }

        public void setPatternName(String PatternName) {
            this.PatternName = PatternName;
        }

        public String getChnlNo() {
            return ChnlNo;
        }

        public void setChnlNo(String ChnlNo) {
            this.ChnlNo = ChnlNo;
        }

        public String getPatternType() {
            return PatternType;
        }

        public void setPatternType(String PatternType) {
            this.PatternType = PatternType;
        }

        public String getCreditProduct() {
            return CreditProduct;
        }

        public void setCreditProduct(String CreditProduct) {
            this.CreditProduct = CreditProduct;
        }
    }
}
