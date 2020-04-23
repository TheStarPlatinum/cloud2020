package com.ydx.springcloud.controller;

import com.ydx.springcloud.entities.CommonResult;
import com.ydx.springcloud.entities.Payment;
import com.ydx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    //不要忘记这个注解
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);

        log.info("************插入结果 " + result);
        if (result>0){
            return new CommonResult(200,"插入成功,serverPort: " + serverPort,result);
        } else {
            return new CommonResult(444,"插入失败",result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id) {

        System.out.println("+++++++++走到查询");
        Payment payment = paymentService.getPaymentById(id);



        if (payment!=null){
            return new CommonResult(200,"查询成功,serverPort: " + serverPort,payment);
        } else {
            return new CommonResult(444,"没有对应记录,查询ID: " + id,null);
        }
    }

    @GetMapping(value = "/openfeignTimeout")
    public String openfeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping(value = "/payment/lb")
    public String lb(){
        return serverPort;
    }
}
