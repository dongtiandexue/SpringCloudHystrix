package com.dtdx.hystrix.hystrixconsumer.command;

import com.dtdx.hystrix.hystrixconsumer.domain.Person;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ProviderCommand
 * @Description TODO
 * @Author huawei
 * @Date 2019/3/1 21:27
 * @Version 1.0
 **/
public class ProviderCommand extends HystrixCommand<Person> {

    private RestTemplate restTemplate;

    @Override
    protected Person getFallback(){
        return new Person("lisi",24,"shanghai");
    }

    public ProviderCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected Person run() throws Exception {
        return restTemplate.getForObject("http://provider-server/provider/getPerson",Person.class);
    }
}
