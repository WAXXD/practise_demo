package com.waxxd.msconsumer003_ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Msconsumer003RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(Msconsumer003RibbonApplication.class, args);
    }

}
