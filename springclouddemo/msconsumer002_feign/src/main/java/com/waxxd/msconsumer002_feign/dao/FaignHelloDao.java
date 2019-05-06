package com.waxxd.msconsumer002_feign.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description:
 *
 * @author waxxd
 * @date 2019-04-23 13:46
 **/
@FeignClient("provider001")
public interface FaignHelloDao {

    @RequestMapping("/provideHello")
    String feignHello(@RequestParam("name") String name);
}
