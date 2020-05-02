package com.xiaoxiao.hotal.core.exception;

import com.xiaoxiao.hotal.base.BusinessException;

public class HotalBusinessException extends BusinessException {

    /**
     * 自定义异常
     */
    private static final long serialVersionUID = 1L;

    public static final String ERROR_CODE_PREFIX = "HOTAL";

    private ErrorInfoInterface errorInfo;

    public HotalBusinessException(ErrorInfoInterface errorInfo ) {
        super(errorInfo.getCode(), errorInfo.getMessage());
    }

    public HotalBusinessException(String code , String message ) {
        super(code, message);
    }

    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

}
