package com.foresight.springcloud.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.foresight.springcloud.dao.PaymentDao;
import com.foresight.springcloud.entities.Payment;
import com.foresight.springcloud.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {

        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}
