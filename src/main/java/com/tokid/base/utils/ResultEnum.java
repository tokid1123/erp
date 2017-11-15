package com.tokid.base.utils;
/*
* @Description: TODO
* @author king
* @date 2017/11/15 16:43
*/

public enum ResultEnum {

    error(0, "请求失败"), success(200, "请求成功");

    private Integer result;

    private String msg;

    ResultEnum(Integer result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
