package com.waxxd.msconsumer004_feign_hystrix.dao;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author waxxd
 * @date 2019-04-23 20:55
 **/
@Component
public class FeignHelloDaoFallbackFactory implements FallbackFactory<FeignHelloDao> {
    @Override
    public FeignHelloDao create(Throwable throwable) {
        return new FeignHelloDao() {
            @Override
            public String feignHello(String name) {
                return "调用用失败！！！";
            }
        };
    }
}
