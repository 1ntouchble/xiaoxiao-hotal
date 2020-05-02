package com.xiaoxiao.hotal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangtianqi
 * @since 2020-04-28 21:06
 */
@ServletComponentScan
@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.xiaoxiao.hotal.mapper")
public class HotalServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(HotalServiceApplication.class, args);
    }



}
