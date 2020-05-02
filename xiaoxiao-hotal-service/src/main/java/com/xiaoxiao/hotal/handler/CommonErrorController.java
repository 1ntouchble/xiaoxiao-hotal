package com.xiaoxiao.hotal.handler;

import com.xiaoxiao.hotal.base.BusinessException;
import com.xiaoxiao.hotal.base.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.context.request.*;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"${server.error.path:${error.path:/error}}"})
public class CommonErrorController extends AbstractErrorController {
    private static final Logger log = LoggerFactory.getLogger(CommonErrorController.class);
    private final ErrorProperties errorProperties;
    private final ErrorAttributes errorAttributes;
    private final String errorCodePrefix;

    public CommonErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, String errorCodePrefix) {
        this(errorAttributes, errorProperties, Collections.emptyList(), errorCodePrefix);
    }

    public CommonErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers, String errorCodePrefix) {
        super(errorAttributes, errorViewResolvers);
        Assert.notNull(errorProperties, "ErrorProperties must not be null");
        Assert.hasText(errorCodePrefix, "errorCodePrefix  must not be null");
        this.errorProperties = errorProperties;
        this.errorAttributes = errorAttributes;
        this.errorCodePrefix = errorCodePrefix;
    }

    @Override
    public String getErrorPath() {
        return this.errorProperties.getPath();
    }

    protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
        ErrorProperties.IncludeStacktrace include = this.getErrorProperties().getIncludeStacktrace();
        if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
            return true;
        } else {
            return include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM ? this.getTraceParameter(request) : false;
        }
    }

    protected ErrorProperties getErrorProperties() {
        return this.errorProperties;
    }

    @RequestMapping(
        produces = {"text/html"}
    )
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = this.getStatus(request);
        Map<String, Object> model = Collections.unmodifiableMap(this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.TEXT_HTML)));
        response.setStatus(status.value());
        ModelAndView modelAndView = this.resolveErrorView(request, response, status, model);
        return modelAndView == null ? new ModelAndView("error", model) : modelAndView;
    }

    protected Exception getError(HttpServletRequest request) {
//        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        return (Exception)this.errorAttributes.getError(servletWebRequest);
    }

    @ResponseBody
    @RequestMapping
    public ResponseEntity<Response<Map<String, Object>>> error(HttpServletRequest request) {
        HttpStatus status = this.getStatus(request);
        String traceId = MDC.get("X-B3-TraceId");
        Response<Map<String, Object>> response = new Response();
        response.setSuccess(0);
        response.setErrorCode(this.errorCodePrefix + ".service_error");
        response.setErrorMsg("服务繁忙,请稍后再试!");

        try {
            Exception ex = this.getError(request);
            if (ex != null) {
                throw ex;
            }
        } catch (BusinessException var6) {
            status = HttpStatus.OK;
            response = Response.failure(this.errorCodePrefix + "." + var6.getCode(), var6.getMessage());
        } catch (NoHandlerFoundException var7) {
            status = HttpStatus.NOT_FOUND;
            response = Response.failure(this.errorCodePrefix + ".", var7.getMessage());
        } catch (HttpRequestMethodNotSupportedException var8) {
            status = HttpStatus.METHOD_NOT_ALLOWED;
            response.setErrorCode(this.errorCodePrefix + ".method_not_allowed");
            response.setErrorMsg("请求方法‘" + var8.getMethod() + "’不被支持!");
        } catch (HttpMediaTypeNotAcceptableException var9) {
            status = HttpStatus.NOT_ACCEPTABLE;
            response.setErrorCode(this.errorCodePrefix + ".not_acceptable");
            response.setErrorMsg("服务端不支持生成指定的响应实体!");
        } catch (HttpMediaTypeNotSupportedException var10) {
            status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
            response.setErrorCode(this.errorCodePrefix + ".unsupported_media_type");
            response.setErrorMsg("服务端不支持请求中提交的实体格式!");
        } catch (Exception var11) {
            log.error("业务处理失败,未知异常!", var11);
            response.setErrorCode(this.errorCodePrefix + ".server_error");
            response.setErrorMsg("服务繁忙,请稍后再试!");
        }

        if (this.isIncludeStackTrace(request, MediaType.APPLICATION_JSON)) {
            response.setData(this.getErrorAttributes(request, true));
        }

        response.setTraceId(traceId);
        return new ResponseEntity(response, new HttpHeaders(), status);
    }
}