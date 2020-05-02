package com.xiaoxiao.hotal.common;


import com.xiaoxiao.hotal.base.Response;
import com.xiaoxiao.hotal.core.exception.HotalBusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = "com.xiaoxiao.hotal.controller")
public class ResponseErrorAdvisor {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Response<?> apiExceptionHandler(HotalBusinessException exception) {
        return Response.failure(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Response<?> unknownExceptionHandler(Exception exception) {
        return Response.failure("hotal-unknow-error", exception.toString());
    }

}
