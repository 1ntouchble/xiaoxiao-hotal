package com.xiaoxiao.hotal.config;

import com.xiaoxiao.hotal.core.exception.HotalBusinessException;
import com.xiaoxiao.hotal.handler.BusinessExceptionHandler;
import com.xiaoxiao.hotal.handler.CommonErrorController;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @Package com.ziku.yuyuan.config  
 * @ClassName:  WebMvcConfiguration    
 * @Description: mvc配置   
 * @author: miles
 * @date:   2018年9月11日 下午5:14:37   
 * @version V1.0
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public BusinessExceptionHandler commonErrorHandler() {
        return new BusinessExceptionHandler();
    }

    @Bean
    public CommonErrorController commonErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties) {
        return new CommonErrorController(errorAttributes, serverProperties.getError(), HotalBusinessException.ERROR_CODE_PREFIX);
    }

    /**
    * 添加跨域支持
    */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//
            .allowedOrigins("*")//
            .allowedMethods("*")//
            .allowCredentials(true)//
            .maxAge(3600);
        super.addCorsMappings(registry);
    }
}
