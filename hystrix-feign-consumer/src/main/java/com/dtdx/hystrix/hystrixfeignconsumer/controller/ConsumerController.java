package com.dtdx.hystrix.hystrixfeignconsumer.controller;

import com.dtdx.hystrix.hystrixfeignconsumer.client.ProviderClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumerController
 * @Description 控制端
 * @Author huawei
 * @Date 2019/3/1 20:50
 * @Version 1.0
 **/

@RestController
@RequestMapping("/consumer-feign")
public class ConsumerController {

    @Autowired
    private ProviderClient providerClient;

    @RequestMapping("test01")
    public Object test01(){
        return providerClient.hello();
    }

}
