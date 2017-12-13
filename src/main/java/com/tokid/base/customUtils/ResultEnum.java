package com.tokid.base.customUtils;
/*
* @Description:
* @author king
* @date 2017/11/15 16:43
*/

public enum ResultEnum {

    ERROR(0, "请求失败"), SUCCESS(200, "请求成功"),
    SYSTEM_ERROR(10001, "系统错误"),LOGIN_ERROR_UN_EXIST_NAME_PASSWORD(10003,"用户名或者密码为空"),
    LOGIN_ERROR_FALIE_NAME_PASSWORD(10004,"用户名或者密码为错误"),FORBIDDEN(10403,"无权限访问");


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
