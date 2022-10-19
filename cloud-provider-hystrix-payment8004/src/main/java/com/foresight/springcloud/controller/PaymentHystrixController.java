package com.foresight.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.foresight.springcloud.service.PaymentServic;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentHystrixController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentServic paymentServic;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id) {

        String messString = paymentServic.paymentInfo_ok(id);
        log.info(messString);
        return messString;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Long id) {

        String messString = paymentServic.paymentInfo_timeout(id);
        log.info(messString);
        return messString;
    }
    @GetMapping("/payment/hystrix/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {

        String messString = paymentServic.paymentCircuitBreaker(id);
        log.info(messString);
        return messString;
    }
}
