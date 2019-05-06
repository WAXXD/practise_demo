package com.waxxd.msconsumer002_feign.service.impl;

import com.waxxd.msconsumer002_feign.dao.FaignHelloDao;
import com.waxxd.msconsumer002_feign.service.HelloService;
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
    FaignHelloDao faignHelloDao;

    @Override
    public String feignHello(String name) {
       return faignHelloDao.feignHello(name);
    }
}
