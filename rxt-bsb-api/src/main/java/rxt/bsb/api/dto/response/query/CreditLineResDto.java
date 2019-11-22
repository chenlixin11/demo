package rxt.bsb.api.dto.response.query;

import java.io.Serializable;

/**
 * 3.4.6 授信额度查询（实时模式）应答报文
 * Created by ChenLiXin on 2019/9/18 0018 16:37
 */
public class CreditLineResDto implements Serializable {

    private String Product;//授信产品名称
    private String CustName;//客户名称
    private String ConfirmFacility;//授信额度
    private String AvaiSum;//授信可用额度
    private String FacFrDate;//生效日期
    private String AvailableTerm;//期限
    private String FacThDate;//到期日
    private String OccSum;//授信已用额度

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public String getConfirmFacility() {
        return ConfirmFacility;
    }

    public void setConfirmFacility(String confirmFacility) {
        ConfirmFacility = confirmFacility;
    }

    public String getAvaiSum() {
        return AvaiSum;
    }

    public void setAvaiSum(String avaiSum) {
        AvaiSum = avaiSum;
    }

    public String getFacFrDate() {
        return FacFrDate;
    }

    public void setFacFrDate(String facFrDate) {
        FacFrDate = facFrDate;
    }

    public String getAvailableTerm() {
        return AvailableTerm;
    }

    public void setAvailableTerm(String availableTerm) {
        AvailableTerm = availableTerm;
    }

    public String getFacThDate() {
        return FacThDate;
    }

    public void setFacThDate(String facThDate) {
        FacThDate = facThDate;
    }

    public String getOccSum() {
        return OccSum;
    }

    public void setOccSum(String occSum) {
        OccSum = occSum;
    }
}
