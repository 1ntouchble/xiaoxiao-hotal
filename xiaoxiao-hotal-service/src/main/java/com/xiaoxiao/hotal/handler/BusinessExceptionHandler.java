package com.xiaoxiao.hotal.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoxiao.hotal.base.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一业务异常拦截
 */
@ControllerAdvice
public class BusinessExceptionHandler {

	@Value("${error.path:/error}")
	private String errorPath;

	/**
	 * 转发异常至统一处理，避免日志记录ERROR级别的业务异常
	 * @param request
	 * @param response
	 * @param ex
	 * @throws ServletException
	 * @throws IOException
	 */
	@ExceptionHandler(BusinessException.class)
	public void error(HttpServletRequest request, HttpServletResponse response, BusinessException ex) throws ServletException, IOException {
		request.setAttribute("javax.servlet.error.status_code", 200);
		request.setAttribute("javax.servlet.error.exception", ex);
		request.getRequestDispatcher(this.errorPath).forward(request, response);
	}
}