package com.xiaoxiao.hotal.core.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAop {

    private static final Logger logger = LoggerFactory.getLogger(LogAop.class);

    @Pointcut("execution(* com.xiaoxiao.hotal.controller.*.*(..))"
//            "&& !execution(* com.xiaoxiao.hotal.controller.AccountLoginController.*(..))"
    )
    public void webLog() {}


    //fixme 可以把验证用户登录的也都记录一下

    @Around("webLog()")
    public Object recordLog(ProceedingJoinPoint jp) throws Throwable {
        // 获取request
        logger.info("=============>开始记录日志<===============");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        // 请求参数
        String parameter = Arrays.toString(jp.getArgs());
        // ip
        String ip = request.getRemoteHost();
        // 用户标识
        String userAgent = request.getHeader("User-Agent");
        Object result;
        result = jp.proceed();
        // 请求结果
        String transferResult = JSON.toJSONString(result);

        logger.info("==============>请求参数为 {}<=========",parameter);
        logger.info("==============>返回参数为 {}<=========",transferResult);
        logger.info("==========> 日志记录完毕 <===============");
        return result;
    }
}