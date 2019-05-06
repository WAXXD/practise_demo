package com.waxxd.msconsumer001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Msconsumer001001Application {

    public static void main(String[] args) {
        SpringApplication.run(Msconsumer001001Application.class, args);
    }

}
