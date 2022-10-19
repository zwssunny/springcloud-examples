package com.foresight.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.foresight.springcloud.service.PaymentServic;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentServic paymentServic;

    @GetMapping("/payment/nacos/{id}")
    @SentinelResource(value="paymentnacosinfo",blockHandler = "paymentInfo_okHandler", fallback="paymentInfo_fallback")
    public String paymentInfo_ok(@PathVariable("id") Long id) {

        String messString = paymentServic.paymentInfo_ok(id);
        log.info(messString);
        return messString;
    }
    public String paymentInfo_okHandler(Long id,BlockException exception)  {
        return "Block by myself!";
    }
    public String paymentInfo_fallback(Long id,Exception exception)  {
        return "调用出错了id:"+id+"\t"+exception.toString();
    }
}
