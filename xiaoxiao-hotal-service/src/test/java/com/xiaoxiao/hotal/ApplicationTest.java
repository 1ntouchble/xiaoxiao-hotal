package com.xiaoxiao.hotal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement

@MapperScan(basePackages ="com.xiaoxiao.hotal.mapper")
public class ApplicationTest {

    public static void main(String[] args){
        SpringApplication.run(ApplicationTest.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder)
    {
        return restTemplateBuilder
//                .setConnectTimeout()
//                .setReadTimeout(1500)
                .build();
    }

}