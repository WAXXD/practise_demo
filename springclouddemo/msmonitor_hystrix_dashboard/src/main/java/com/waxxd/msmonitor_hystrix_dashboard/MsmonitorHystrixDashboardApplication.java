package com.waxxd.msmonitor_hystrix_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MsmonitorHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsmonitorHystrixDashboardApplication.class, args);
    }

}
