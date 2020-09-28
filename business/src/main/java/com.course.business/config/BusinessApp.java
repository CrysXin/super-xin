package com.course.business.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * Created by ZHX on 2020/9/6.
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.course")
@MapperScan("com.course.server.mapper")
public class BusinessApp {
    private static final Logger LOG = LoggerFactory.getLogger(BusinessApp.class);
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BusinessApp.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("Business地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }
}