package com.dtdx.hystrix.hystrixconsumer.domain;

import java.io.Serializable;

/**
 * @ClassName Person
 * @Description TODO
 * @Author huawei
 * @Date 2019/2/27 21:23
 * @Version 1.0
 **/

public class Person implements Serializable {

    private String name;

    private String address;

    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name,Integer age, String address ) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Person() {
    }
}
