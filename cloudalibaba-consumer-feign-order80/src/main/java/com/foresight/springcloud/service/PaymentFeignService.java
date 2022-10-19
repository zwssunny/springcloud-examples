package com.foresight.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//feign=ribbon+restTemplate
@Component
@FeignClient(value = "cloudalibaba-payment-service")
public interface PaymentFeignService {

    @GetMapping("/payment/nacos/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id);

}
