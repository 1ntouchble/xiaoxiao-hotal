package com.xiaoxiao.hotal.core.aop;


import com.xiaoxiao.hotal.util.ValidateUtil;
import com.xiaoxiao.hotal.base.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckParamtersAop {

    private static Logger log = LoggerFactory.getLogger(CheckParamtersAop.class);

    @Pointcut("execution(@com.xiaoxiao.hotal.annotation.CheckParameters * com.xiaoxiao.hotal.controller..*.*(..))")
    private void checkParameters(){}


    /**
     * 感觉慢了就别用这个方式了，spirngboot有最新的验证不需要这样玩
     * @param jp
     * @return
     * @throws Throwable
     */
    @Around("checkParameters()")
    public Object checkParameter(ProceedingJoinPoint jp) throws Throwable {
        log.info("开始验证参数");
        Object obj = jp.getArgs()[0];
        Response response = ValidateUtil.validateModel(obj);
        if(response!=null) {
            log.info("参数错误，错误信息为：{}",response.getErrorMsg());
            return response;
        }
        log.info("验参成功");
        return jp.proceed();
    }

}
