package com.waxxd.mseureka002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Mseureka002Application {

    public static void main(String[] args) {
        SpringApplication.run(Mseureka002Application.class, args);
    }

}
