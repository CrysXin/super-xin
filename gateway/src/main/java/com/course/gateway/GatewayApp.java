package com.course.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;

/**
 * Created by ZHX on 2020/9/6.
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApp {
    private static final Logger LOG = LoggerFactory.getLogger(GatewayApp.class);
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GatewayApp.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("System地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }
}
