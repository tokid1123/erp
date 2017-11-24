package com.tokid.base.exception;
/*
* @Description: 业务错误基础类
* @author king
* @date 2017/11/24 14:51
*/

public class ServiceException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer errId;

    public Integer getErrId() {
        return errId;
    }

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}

