package rxt.bsb.rest.po;

public class CodeCity {
    private Integer id;

    private String code;

    private String name;

    private Integer type;

    private String upcode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUpcode() {
        return upcode;
    }

    public void setUpcode(String upcode) {
        this.upcode = upcode == null ? null : upcode.trim();
    }
}