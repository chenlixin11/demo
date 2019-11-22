package rxt.bsb.rest.po;

import java.util.Date;

public class Holidays {
    private Integer id;

    private Date cYear;

    private Date holidayDate;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getcYear() {
        return cYear;
    }

    public void setcYear(Date cYear) {
        this.cYear = cYear;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}