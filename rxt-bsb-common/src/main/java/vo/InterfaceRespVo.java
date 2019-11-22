package vo;

import com.alibaba.fastjson.JSON;

public class InterfaceRespVo<T> {
    private Integer result;// 0 失败   1成功
    private String failReasons;//失败原因
    private T object;//接口返回数据


    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getFailReasons() {
        return failReasons;
    }

    public void setFailReasons(String failReasons) {
        this.failReasons = failReasons;
    }


    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }


    public boolean isSuccess() {
        return this.result == 1;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
