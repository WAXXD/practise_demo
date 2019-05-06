package com.waxxd.msconsumer004_feign_hystrix.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description:
 *
 * @author waxxd
 * @date 2019-04-23 13:46
 **/
@FeignClient(value = "provider001",fallbackFactory = FeignHelloDaoFallbackFactory.class)
public interface FeignHelloDao {

    @RequestMapping("/provideHello")
    String feignHello(@RequestParam("name") String name);
}
