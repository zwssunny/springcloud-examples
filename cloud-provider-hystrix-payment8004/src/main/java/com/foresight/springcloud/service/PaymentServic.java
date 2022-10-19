package com.foresight.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.hutool.core.util.IdUtil;

@Component
public class PaymentServic {

    public String paymentInfo_ok(Long id) {

        String messString = "查询服务器线程为：" + Thread.currentThread().getName() + ",paymentInfo_ok,id:" + id + ",hi!";
        return messString;
    }

    // 服务降级
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_timeout(Long id) {

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String messString = "线程为：" + Thread.currentThread().getName() + ",paymentInfo_timeout,id:" + id + ",oo!";
        return messString;
    }

    public String paymentInfo_timeoutHandle(Long id) {

        String messString = "线程为：" + Thread.currentThread().getName() + ",服务繁忙，稍后重试,id:" + id + ",oo!";
        return messString;
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("***id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Long id) {//参数一致
        return "id 不能负数,请稍后再试，id：" + id;
    }
}
