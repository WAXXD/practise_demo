package com.waxxd.msconsumer004_feign_hystrix.controller;

import com.waxxd.msconsumer004_feign_hystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author waxxd
 * @date 2019-04-23 13:39
 **/

@RestController
public class Consumer004 {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return "msconsumer002 ----------- say hi";
    }

    @GetMapping("/feign/{name}")
    public String feignHello(@PathVariable("name") String name){
        return helloService.feignHello(name);
    }


}
