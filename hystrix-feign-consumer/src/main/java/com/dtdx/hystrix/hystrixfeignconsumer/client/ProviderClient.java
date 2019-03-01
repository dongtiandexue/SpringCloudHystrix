package com.dtdx.hystrix.hystrixfeignconsumer.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ProviderClient
 * @Description feign结合hystrix
 * @Author huawei
 * @Date 2019/3/1 20:52
 * @Version 1.0
 **/

@FeignClient(name = "provider-server",path = "/provider",fallback = ProviderBack.class)
public interface ProviderClient {

    @RequestMapping("/hello")
    public String hello();
}
