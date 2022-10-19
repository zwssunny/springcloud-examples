package com.foresight.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foresight.springcloud.entities.CommonResult;
import com.foresight.springcloud.entities.Payment;
import com.foresight.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment)
    {
        int result=paymentService.create(payment);
        log.info("****插入结果："+result);
        if (result>0) {
            return new CommonResult(200,"插入数据库成功,serverport"+serverPort,result);
        } else {
            return new CommonResult<Payment>(444,"插入数据库失败,serverport"+serverPort,null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id)
    {
        Payment result=paymentService.getPaymentById(id);
        log.info("****查询结果："+result);
        if (result!=null) {
            return new CommonResult<Payment>(200,"查询数据库成功,serverport"+serverPort,result);
        } else {
            return new CommonResult<Payment>(444,"查询数据库失败,serverport"+serverPort,null);
        }
    }
}
