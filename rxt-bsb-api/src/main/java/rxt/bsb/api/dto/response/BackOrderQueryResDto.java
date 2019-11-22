package rxt.bsb.api.dto.response;

import java.io.Serializable;
import java.util.List;

//回单查询 应答报文
public class BackOrderQueryResDto implements Serializable {


    /**
     * Count : 1
     * Result : 0
     * FileName : recp16_A2019052820122510000000056320347.xml
     * InnerNoList : [{"InnerNo":"51289867","TrDate":"2019-05-22","ReceiptName":"客户通用记账凭证（付款）","AccNo":"9956760994182000000038","Currency":"人民币","Flag":"D","Amount":"0.50","SerialNo":"56700201905220000054759567054759","FileName":"recp16_A2019052820122510000000056320347.xml","PrintCount":"1"}]
     */

    private String Count;
    private String Result;
    private String FileName;
    private List<InnerNoListBean> InnerNoList;

    public String getCount() {
        return Count;
    }

    public void setCount(String Count) {
        this.Count = Count;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public List<InnerNoListBean> getInnerNoList() {
        return InnerNoList;
    }

    public void setInnerNoList(List<InnerNoListBean> InnerNoList) {
        this.InnerNoList = InnerNoList;
    }

    public static class InnerNoListBean {
        /**
         * InnerNo : 51289867
         * TrDate : 2019-05-22
         * ReceiptName : 客户通用记账凭证（付款）
         * AccNo : 9956760994182000000038
         * Currency : 人民币
         * Flag : D
         * Amount : 0.50
         * SerialNo : 56700201905220000054759567054759
         * FileName : recp16_A2019052820122510000000056320347.xml
         * PrintCount : 1
         */

        private String InnerNo;
        private String TrDate;
        private String ReceiptName;
        private String AccNo;
        private String Currency;
        private String Flag;
        private String Amount;
        private String SerialNo;
        private String FileName;
        private String PrintCount;

        public String getInnerNo() {
            return InnerNo;
        }

        public void setInnerNo(String InnerNo) {
            this.InnerNo = InnerNo;
        }

        public String getTrDate() {
            return TrDate;
        }

        public void setTrDate(String TrDate) {
            this.TrDate = TrDate;
        }

        public String getReceiptName() {
            return ReceiptName;
        }

        public void setReceiptName(String ReceiptName) {
            this.ReceiptName = ReceiptName;
        }

        public String getAccNo() {
            return AccNo;
        }

        public void setAccNo(String AccNo) {
            this.AccNo = AccNo;
        }

        public String getCurrency() {
            return Currency;
        }

        public void setCurrency(String Currency) {
            this.Currency = Currency;
        }

        public String getFlag() {
            return Flag;
        }

        public void setFlag(String Flag) {
            this.Flag = Flag;
        }

        public String getAmount() {
            return Amount;
        }

        public void setAmount(String Amount) {
            this.Amount = Amount;
        }

        public String getSerialNo() {
            return SerialNo;
        }

        public void setSerialNo(String SerialNo) {
            this.SerialNo = SerialNo;
        }

        public String getFileName() {
            return FileName;
        }

        public void setFileName(String FileName) {
            this.FileName = FileName;
        }

        public String getPrintCount() {
            return PrintCount;
        }

        public void setPrintCount(String PrintCount) {
            this.PrintCount = PrintCount;
        }
    }
}
