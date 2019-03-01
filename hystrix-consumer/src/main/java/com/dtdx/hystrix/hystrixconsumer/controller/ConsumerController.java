package com.dtdx.hystrix.hystrixconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumerController
 * @Description TODO
 * @Author huawei
 * @Date 2019/2/27 21:34
 * @Version 1.0
 **/
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("test01")
    @HystrixCommand(fallbackMethod = "test01Fail")
    public Object test01(){
        String result = restTemplate.getForObject("http://provider-server/provider/hello", String.class);
        return result;
    }

    public Object test01Fail(){
        return "Connect server provider fail";
    }
}
