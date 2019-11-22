package rxt.bsb.rest.common;
import com.alibaba.fastjson.JSON;
import rxt.bsb.rest.common.Enums.ResultCode;

public class ApiResult {

    private int code;
    /**
     * 对错误的具体解释
     */
    private String message;
    /**
     * 返回的结果包装在value中，value可以是单个对象
     */
    private  Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    private ApiResult(ResultCode code, Object data) {
        this.code = code.getCode();
        this.message = code.getMsg();
        this.data = data;
    }

    public static ApiResult successOf(Object data) {
        return new ApiResult(ResultCode.SUCCESS,data);
    }
    public static ApiResult errorOf(Object data) {
        return new ApiResult(ResultCode.ERROR,data);
    }
    public static ApiResult of (ResultCode code) {
        return new ApiResult(code,null);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
