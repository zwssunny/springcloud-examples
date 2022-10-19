package com.foresight.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentServic {
    public String paymentInfo_ok(Long id) {

        String messString = "查询服务器线程为：" + Thread.currentThread().getName() + ",paymentInfo_ok,id:" + id + ",hi!";
        return messString;
    }
}
