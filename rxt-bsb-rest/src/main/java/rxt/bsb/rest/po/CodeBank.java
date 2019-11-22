package rxt.bsb.rest.po;

public class CodeBank {
    private Integer id;

    private String bankCode;

    private String bankName;

    private String payCode;

    private String payBankname;

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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    public String getPayBankname() {
        return payBankname;
    }

    public void setPayBankname(String payBankname) {
        this.payBankname = payBankname == null ? null : payBankname.trim();
    }
}