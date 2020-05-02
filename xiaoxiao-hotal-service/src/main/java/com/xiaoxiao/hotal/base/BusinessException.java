package com.xiaoxiao.hotal.base;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -2776676656209663624L;
    private String code;

    public BusinessException() {
    }

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}