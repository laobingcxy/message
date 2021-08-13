package com.byd.message.domain;

import lombok.Data;

/**
 * 通用返回类
 */
@Data
public class Result<T> {
    /*返回体*/
    private Integer code;
    private String msg;
    private T data;
    /**
     * 成功
     **/
    public Result success(Object object) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public Result success(String msg) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(msg);
        return result;
    }

    /**
     * 失败
     **/
    public Result fail(Object object) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL.getCode());
        result.setMsg(ResultCode.FAIL.getMsg());
        result.setData(object);
        return result;
    }

    public Result fail(String message) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL.getCode());
        result.setMsg(message);
        result.setData(null);
        return result;
    }

    public Result result(ResultCode resultCode, Object object) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
        result.setData(object);
        return result;
    }
    public Result result(ResultCode resultCode) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
        result.setData(null);
        return result;
    }
}