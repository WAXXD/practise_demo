package com.waxxd.mseureka001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Mseureka001Application {

    public static void main(String[] args) {
        SpringApplication.run(Mseureka001Application.class, args);
    }

}
