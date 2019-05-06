package com.waxxd.msconsumer003_ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * description:
 *
 * @author waxxd
 * @date 2019-04-23 14:05
 **/
@Controller
public class RibbonHelloController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String hello(){
        return "msconsumer003_ribbon ---- sayHi";
    }

    @RequestMapping("/003")
    public String  h00(){
        return "03";
    }

    @DeleteMapping("/test")
    @ResponseBody
    public String test(@RequestParam(value = "strs[]") String[] strs){

        for(int i = 0; i < strs.length ;i++){
            System.out.println(strs[i].toString());
        }
        System.out.println(strs.length);
        System.out.println(strs);
        return "成功";
    }

    @RequestMapping("/ribbonHello/{name}")
    public String ribbonHello(@PathVariable("name") String name){
        return restTemplate.getForObject("http://PROVIDER001/provideHello1/{1}" ,String.class,name);
    }

}
