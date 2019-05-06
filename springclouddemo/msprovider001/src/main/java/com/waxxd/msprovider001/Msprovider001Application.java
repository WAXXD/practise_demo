package com.waxxd.msprovider001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class Msprovider001Application {

    public static void main(String[] args) {
        SpringApplication.run(Msprovider001Application.class, args);
    }

}
