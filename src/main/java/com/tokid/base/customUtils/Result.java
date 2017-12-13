package com.tokid.base.customUtils;
/*
* @Description:
* @author king
* @date 2017/11/15 16:27
*/

import java.io.Serializable;

public class Result<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    private T data;

    private String msg;

    private int code;

    public static <T> Result<T> createResultForm(ResultEnum status, T result,  String messages) {
        return new Result<T>(result, messages, status.getResult());
    }

    public static <T> Result<T> createResultForm(ResultEnum status, T result) {
        return new Result<T>(result, status.getMsg(), status.getResult());
    }

    public static <T> Result<T> createSuccessResultForm(T result, String messages) {
        return createResultForm(ResultEnum.SUCCESS, result, messages);
    }

    public static <T> Result<T> createSuccessResultForm(T result, ResultEnum resultEnum) {
        return createResultForm(ResultEnum.SUCCESS, result, resultEnum.getMsg());
    }

    public static <T> Result<T> createErrorResultForm(T result, String messages) {
        return createResultForm(ResultEnum.ERROR, result, messages);
    }

    public static <T> Result<T> createErrorResultForm(T result, ResultEnum resultEnum) {
        return createResultForm(ResultEnum.ERROR, result, resultEnum.getMsg());
    }

    public static <T> Result<T> createErrorResultForm(T result) {
        return createResultForm(ResultEnum.ERROR, result);
    }

    public static <T> Result<T> createSuccessResultForm(T result) {
        return createResultForm(ResultEnum.SUCCESS, result);
    }

    public Result() {
    }

    public Result(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public Result(T data, String msg, int code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
