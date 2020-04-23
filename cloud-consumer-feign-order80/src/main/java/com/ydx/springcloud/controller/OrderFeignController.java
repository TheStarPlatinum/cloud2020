package com.ydx.springcloud.controller;

import com.ydx.springcloud.entities.CommonResult;
import com.ydx.springcloud.entities.Payment;
import com.ydx.springcloud.service.PaymentFeignService;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Log4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/openfeignTimeout")
    public String openfeignTimeOut(){
        return paymentFeignService.openfeignTimeOut();
    }
}
