package rxt.bsb.api.dto.request.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 4.3.1.3 会员批量出金 请求报文
 * Created by ChenLiXin on 2019/9/26 0026 10:16
 */
public class BatchPaymentReqDto implements Serializable {

    /**
     * SubAcctNo : 9956770001941400000001
     * OperFlag : 0
     * Amount : 0.40
     * Count : 2
     * BatchWithdrawInfoList : [{"BatchAcctNo":"9956770001941400000002","BatchAcctName":"测试账户","BatchAmt":"2.00","BatchOrderNo":"232132131231231232113","BatchBankNo":"103126080105","BatchBankName":"中国农业银行股份有限公司北京支行","FeeList":[{"FeeCode":"000052","FeeAmt":"2"}],"BatchPostScript":"交易附言 1"},{"BatchAcctNo":"9956770001941400000002","BatchAcctName":"测试账户","BatchAmt":"2.00","BatchOrderNo":"2321321312312312321131","BatchBankNo":"103126080105","BatchBankName":"中国农业银行股份有限公司北京支行","FeeList":[{"FeeCode":"000052","FeeAmt":"2"}],"BatchPostScript":"交易附言 2"}]
     */

    private String SubAcctNo;
    private String OperFlag;
    private String Amount;
    private String Count;
    private List<BatchWithdrawInfoListBean> BatchWithdrawInfoList;

    @JSONField(name="SubAcctNo")
    public String getSubAcctNo() {
        return SubAcctNo;
    }

    public void setSubAcctNo(String SubAcctNo) {
        this.SubAcctNo = SubAcctNo;
    }

    @JSONField(name="OperFlag")
    public String getOperFlag() {
        return OperFlag;
    }

    public void setOperFlag(String OperFlag) {
        this.OperFlag = OperFlag;
    }

    @JSONField(name="Amount")
    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    @JSONField(name="Count")
    public String getCount() {
        return Count;
    }

    public void setCount(String Count) {
        this.Count = Count;
    }

    @JSONField(name="BatchWithdrawInfoList")
    public List<BatchWithdrawInfoListBean> getBatchWithdrawInfoList() {
        return BatchWithdrawInfoList;
    }

    public void setBatchWithdrawInfoList(List<BatchWithdrawInfoListBean> BatchWithdrawInfoList) {
        this.BatchWithdrawInfoList = BatchWithdrawInfoList;
    }

    public static class BatchWithdrawInfoListBean {
        /**
         * BatchAcctNo : 9956770001941400000002
         * BatchAcctName : 测试账户
         * BatchAmt : 2.00
         * BatchOrderNo : 232132131231231232113
         * BatchBankNo : 103126080105
         * BatchBankName : 中国农业银行股份有限公司北京支行
         * FeeList : [{"FeeCode":"000052","FeeAmt":"2"}]
         * BatchPostScript : 交易附言 1
         */

        private String BatchAcctNo;
        private String BatchAcctName;
        private String BatchAmt;
        private String BatchOrderNo;
        private String BatchBankNo;
        private String BatchBankName;
        private String BatchPostScript;
        private List<FeeListBean> FeeList;

        @JSONField(name="BatchAcctNo")
        public String getBatchAcctNo() {
            return BatchAcctNo;
        }

        public void setBatchAcctNo(String BatchAcctNo) {
            this.BatchAcctNo = BatchAcctNo;
        }

        @JSONField(name="BatchAcctName")
        public String getBatchAcctName() {
            return BatchAcctName;
        }

        public void setBatchAcctName(String BatchAcctName) {
            this.BatchAcctName = BatchAcctName;
        }

        @JSONField(name="BatchAmt")
        public String getBatchAmt() {
            return BatchAmt;
        }

        public void setBatchAmt(String BatchAmt) {
            this.BatchAmt = BatchAmt;
        }

        @JSONField(name="BatchOrderNo")
        public String getBatchOrderNo() {
            return BatchOrderNo;
        }

        public void setBatchOrderNo(String BatchOrderNo) {
            this.BatchOrderNo = BatchOrderNo;
        }

        @JSONField(name="BatchBankNo")
        public String getBatchBankNo() {
            return BatchBankNo;
        }

        public void setBatchBankNo(String BatchBankNo) {
            this.BatchBankNo = BatchBankNo;
        }

        @JSONField(name="BatchBankName")
        public String getBatchBankName() {
            return BatchBankName;
        }

        public void setBatchBankName(String BatchBankName) {
            this.BatchBankName = BatchBankName;
        }

        @JSONField(name="BatchPostScript")
        public String getBatchPostScript() {
            return BatchPostScript;
        }

        public void setBatchPostScript(String BatchPostScript) {
            this.BatchPostScript = BatchPostScript;
        }

        @JSONField(name="FeeList")
        public List<FeeListBean> getFeeList() {
            return FeeList;
        }

        public void setFeeList(List<FeeListBean> FeeList) {
            this.FeeList = FeeList;
        }

        public static class FeeListBean {
            /**
             * FeeCode : 000052
             * FeeAmt : 2
             */

            private String FeeCode;
            private String FeeAmt;

            @JSONField(name="FeeCode")
            public String getFeeCode() {
                return FeeCode;
            }

            public void setFeeCode(String FeeCode) {
                this.FeeCode = FeeCode;
            }

            @JSONField(name="FeeAmt")
            public String getFeeAmt() {
                return FeeAmt;
            }

            public void setFeeAmt(String FeeAmt) {
                this.FeeAmt = FeeAmt;
            }
        }
    }
}
