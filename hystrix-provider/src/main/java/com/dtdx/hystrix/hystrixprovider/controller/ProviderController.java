package com.dtdx.hystrix.hystrixprovider.controller;

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
    public Object hello(){
        return "Success connect : "+port;
    }
}
