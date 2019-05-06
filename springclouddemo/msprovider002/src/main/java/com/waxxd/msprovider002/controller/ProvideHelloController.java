package com.waxxd.msprovider002.controller;

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

    @RequestMapping("/provideHello1/{name}")
    public String provideHello1(@PathVariable String name, HttpServletRequest request){
        if(name.equals("234")){
            throw new RuntimeException("调用失败了" + request.getServerPort());
        }

        return "msprovider001---provideHello1 sayHi to" + name + " " + request.getServerPort();
    }
}
