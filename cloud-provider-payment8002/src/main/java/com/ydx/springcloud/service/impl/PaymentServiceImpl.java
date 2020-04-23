package com.ydx.springcloud.service.impl;

import com.ydx.springcloud.dao.PaymentDao;
import com.ydx.springcloud.entities.Payment;
import com.ydx.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id") long id) {
        return paymentDao.getPaymentById(id);
    }
}
