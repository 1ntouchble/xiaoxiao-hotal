package com.xiaoxiao.hotal.util;

import com.xiaoxiao.hotal.base.Response;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

public class ValidateUtil {


    public static Response validateModel(Object obj) {// 验证某一个对象
        Response response = new Response();
        response.setErrorCode("3001");
        response.setErrorMsg("验证参数失败");
        if (obj == null) {
            response.setErrorMsg("参数不能为空!");
            return response;
        }
        String errMsg = getErrorMsg(obj);
        if (StringUtils.isNotBlank(errMsg)) {
            response.setErrorMsg(errMsg);
            return response;
        }
        return null;
    }

    public static String validateModelReturnString(Object obj) {// 验证某一个对象
        String errorMsg;
        if (obj == null) {
            errorMsg = "参数不能为空";
            return errorMsg;
        }
        errorMsg = getErrorMsg(obj);
        return errorMsg;
    }


    private static String getErrorMsg(Object obj){

        // 用于存储验证后的错误信息
        StringBuilder builder = new StringBuilder();

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        // 验证某个对象,，其实也可以只验证其中的某一个属性的
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj);

        Iterator<ConstraintViolation<Object>> iter = constraintViolations.iterator();
        while (iter.hasNext()) {
            String message = iter.next().getMessage();
            builder.append(message);
        }
        return builder.toString();

    }



}
