package rxt.bsb.rest.po;

import java.util.Date;

public class LogBusiness {
    private Integer id;

    private Integer usersId;

    private String businessName;

    private Date businessTime;

    private Integer businessResult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    public Date getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(Date businessTime) {
        this.businessTime = businessTime;
    }

    public Integer getBusinessResult() {
        return businessResult;
    }

    public void setBusinessResult(Integer businessResult) {
        this.businessResult = businessResult;
    }
}