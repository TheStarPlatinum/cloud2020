package com.ydx.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "xxxxxxxxx  ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "xxxxxxxxxxx  timeout";
    }
}
