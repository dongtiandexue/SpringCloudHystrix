package com.dtdx.hystrix.consumerhystrixdashboard.controller;

import com.dtdx.hystrix.consumerhystrixdashboard.client.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConsumerController
 * @Description 控制端
 * @Author huawei
 * @Date 2019/3/1 20:50
 * @Version 1.0
 **/

@RestController
@RequestMapping("/consumer-dashboard")
public class ConsumerController {

    @Autowired
    private ProviderClient providerClient;

    @RequestMapping("test01")
    public Object test01(){
        return providerClient.hello();
    }

}
