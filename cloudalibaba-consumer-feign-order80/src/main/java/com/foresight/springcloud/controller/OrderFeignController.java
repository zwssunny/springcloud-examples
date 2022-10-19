package com.foresight.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.foresight.springcloud.service.PaymentFeignService;


@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/nacos/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id)
    {
        return paymentFeignService.paymentInfo_ok(id);
    }



}
