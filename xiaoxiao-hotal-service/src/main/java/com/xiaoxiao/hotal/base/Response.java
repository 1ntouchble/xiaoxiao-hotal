package com.xiaoxiao.hotal.base;

import java.io.Serializable;

/**
 * 公共返回内容
 * @author Xiongmw
 * @version 1.0.0
 * @param <T>
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 是否成功 */
    private Integer success = 1;
    /** 错误编码 */
    private String errorCode;
    /** 错误信息 */
    private String errorMsg;
    /** 返回数据 */
    private T data;
    /** 链路跟踪Id */
    private String traceId;

    public Response() {
    }

    public Response(Integer success, String errorCode, String errorMsg, T data) {
        super();
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    /**
     * 业务处理成功
     * @param data
     * @return
     */
    public static <T> Response<T> success(T data) {
        return new Response<T>(1, null, null, data);
    }

    /**
     * 业务处理失败
     * @param data
     * @return
     */
    public static <T> Response<T> failure(String errorCode, String errorMsg) {
        return new Response<T>(0, errorCode, errorMsg, null);
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String dataStr = data == null ? "NULL" : data.toString();
        return "Response[success=" + success //
                + "; errorCode=" + errorCode //
                + "; errorMsg=" + errorMsg //
                + "; traceId=" + traceId //
                + "; data=" + dataStr + "]";
    }
}
