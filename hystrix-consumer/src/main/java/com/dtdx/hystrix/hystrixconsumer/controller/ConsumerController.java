package com.dtdx.hystrix.hystrixconsumer.controller;

import com.dtdx.hystrix.hystrixconsumer.command.ProviderCommand;
import com.dtdx.hystrix.hystrixconsumer.domain.Person;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    private static final Logger log = LoggerFactory.getLogger(ConsumerController.class);

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

    @RequestMapping("test02")
    public Object test02() throws ExecutionException, InterruptedException {
        ProviderCommand provider = new ProviderCommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),restTemplate);
        //同步调用
//        Person person = provider.execute();

        System.out.println("调用开始");
        Future<Person> future = provider.queue();
        System.out.println("调用结束");
        Person person = future.get();
        log.info("connect finish !");
        return person;
    }

    @RequestMapping("test03")
    public Object test03() throws ExecutionException, InterruptedException {
        Person person = test3().get();
        return person;
    }



    @HystrixCommand
    public Future<Person> test3() {
        return new AsyncResult<Person>() {
            @Override
            public Person invoke() {
                return restTemplate.getForObject("http://provider-server/getPerson", Person.class);
            }
        };
    }
}
