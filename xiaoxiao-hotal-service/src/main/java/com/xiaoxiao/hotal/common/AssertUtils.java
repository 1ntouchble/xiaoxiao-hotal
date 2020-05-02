package com.xiaoxiao.hotal.common;

import com.xiaoxiao.hotal.core.exception.HotalBusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collection;

/***
 * 参数校验工具类
 * 
 * @author gfqlm
 *
 */
public class AssertUtils {

	/**
	 * 字符串校验
	 * 
	 * @param param     被校验参数
	 * @param errorCode 错误码
	 * @param magess    错误信息提示
	 * @return
	 * @throws ParamException
	 */
	public static void hasText(String param, String errorCode, String message) {
		if (StringUtils.isBlank(param))
			throw new HotalBusinessException(errorCode, message);
	}

	/**
	 * 对象校验
	 * 
	 * @param object    被校验对象
	 * @param errorCode 错误码
	 * @param message   错误信息提示
	 * @return
	 */
	public static void notNull(Object object, String errorCode, String message) {
		if (object == null)
			throw new HotalBusinessException(errorCode, message);
	}

	/**
	 * 表达式校验
	 * 
	 * @param expression 被校验表达式
	 * @param errorCode  错误码
	 * @param message    错误信息提示
	 * @return
	 */
	public static void isTrue(boolean expression, String errorCode, String message) {
		if (!expression)
			throw new HotalBusinessException(errorCode, message);
	}
	
	/**
	 * 对象数据校验
	 * 
	 * @param array     被校验数据
	 * @param errorCode 错误码
	 * @param message   错误信息提示
	 * @return
	 */
	public static void notEmpty(Object[] array, String errorCode, String message) {
		if (ObjectUtils.isEmpty(array))
			throw new HotalBusinessException(errorCode, message);
	}

	/***
	 * 集合校验
	 * 
	 * @param collection 被校验集合
	 * @param errorCode  错误码
	 * @param message    错误信息提示
	 * @return
	 */
	public static void notEmpty(Collection<?> collection, String errorCode, String message) {
		if (CollectionUtils.isEmpty(collection))
			throw new HotalBusinessException(errorCode, message);
	}
}
