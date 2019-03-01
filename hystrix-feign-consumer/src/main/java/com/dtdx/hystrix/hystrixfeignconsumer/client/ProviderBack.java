package com.dtdx.hystrix.hystrixfeignconsumer.client;

import org.springframework.stereotype.Component;

/**
 * @ClassName ProviderBack
 * @Description TODO
 * @Author huawei
 * @Date 2019/3/1 21:00
 * @Version 1.0
 **/

@Component
public class ProviderBack implements ProviderClient {

    @Override
    public String hello() {
        return "connect fail ,this is from hystrix fallback";
    }
}
