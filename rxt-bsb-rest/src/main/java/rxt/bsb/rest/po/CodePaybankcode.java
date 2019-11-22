package rxt.bsb.rest.po;

public class CodePaybankcode {
    private Integer id;

    private String bankCode;

    private String cityCode;

    private String payCode;

    private String branchBankname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    public String getBranchBankname() {
        return branchBankname;
    }

    public void setBranchBankname(String branchBankname) {
        this.branchBankname = branchBankname == null ? null : branchBankname.trim();
    }
}