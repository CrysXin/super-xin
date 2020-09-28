package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by ZHX on 2020/9/15.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class FeignApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignApp.class,args);
    }
}
