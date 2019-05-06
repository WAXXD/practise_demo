package com.waxxd.msprovider001.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * description:
 *
 * @author waxxd
 * @date 2019-04-23 13:51
 **/
@RestController
public class ProvideHelloController {

    @RequestMapping("/")
    public String sayHello(){
        return "mspovider001 ---------- sayHi";
    }

    @RequestMapping("/provideHello")
    public String provideHello(String name, HttpServletRequest request){
        return "msprovider001---provideHello sayHi to" + name + request.getServerPort();
    }

    @HystrixCommand(fallbackMethod = "hello1Hystrix_get")
    @RequestMapping("/provideHello1/{name}")
    public String provideHello1(@PathVariable String name, HttpServletRequest request){
        if(name.equals("123")){
            throw new RuntimeException("此名称" + name + "不存在" + " " + request.getServerPort());
        }
        return "msprovider001---provideHello1 sayHi to" + name + " " + request.getServerPort();
    }

    public String hello1Hystrix_get(@PathVariable String name ,HttpServletRequest request){
        return "服务不可用" + request.getServerPort();
    }
}
