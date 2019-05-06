package com.waxxd.msconsumer004_feign_hystrix.service.impl;

import com.waxxd.msconsumer004_feign_hystrix.dao.FeignHelloDao;
import com.waxxd.msconsumer004_feign_hystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author waxxd
 * @date 2019-04-23 13:44
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    FeignHelloDao faignHelloDao;

    @Override
    public String feignHello(String name) {
       return faignHelloDao.feignHello(name);
    }
}
