package com.byd.message.domain;

/**
 * 通用返回状态码
 */
public enum ResultCode {
    SUCCESS(0,"成功"),
    FAIL(1,"失败"),
    NO_LOGIN(-200,"未登录"),
    UNKNOWN_ERROR(-1,"未知错误"),
    NO_DATA(10001,"没有数据");

    private final Integer code;
    private final String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
