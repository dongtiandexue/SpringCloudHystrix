package com.dtdx.hystrix.hystrixprovider.controller;

import com.dtdx.hystrix.hystrixprovider.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProviderController
 * @Description TODO
 * @Author huawei
 * @Date 2019/2/27 21:22
 * @Version 1.0
 **/

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String hello(){
        return "Success connect : "+port;
    }

    @RequestMapping("/getPerson")
    public Person getPerson(){
        Person p = new Person();
        p.setName("zhangsan");
        p.setAge(23);
        p.setAddress("Beijin 端口：" + port);
        return p;
    }
}
