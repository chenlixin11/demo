package rxt.bsb.front.po;

import java.util.Date;

public class LogInterfaceinvoke {
    private Integer id;

    private Integer businessId;

    private String funCode;

    private String funName;

    private Date invokeTime;

    private Integer invokeResult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getFunCode() {
        return funCode;
    }

    public void setFunCode(String funCode) {
        this.funCode = funCode == null ? null : funCode.trim();
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName == null ? null : funName.trim();
    }

    public Date getInvokeTime() {
        return invokeTime;
    }

    public void setInvokeTime(Date invokeTime) {
        this.invokeTime = invokeTime;
    }

    public Integer getInvokeResult() {
        return invokeResult;
    }

    public void setInvokeResult(Integer invokeResult) {
        this.invokeResult = invokeResult;
    }
}