package com.example.springbootdemo.util.response;

public enum  ResponseEnum {
    SUCCESS("0000", "成功"),
    PARAM_ERROR("1000","参数错误"),
    SYSTEM_ERROR("9999","系统错误"),
    GET_REDIS_VALUE_ERROR("200001","释放Redis锁失败"),
    ;
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
