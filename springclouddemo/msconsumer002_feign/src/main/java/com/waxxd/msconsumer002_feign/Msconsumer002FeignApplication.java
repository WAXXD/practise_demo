package com.waxxd.msconsumer002_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Msconsumer002FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Msconsumer002FeignApplication.class, args);
    }

}
