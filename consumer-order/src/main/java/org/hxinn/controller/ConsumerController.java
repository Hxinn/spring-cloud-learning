package org.hxinn.controller;

import org.hxinn.entity.BaseResult;
import org.hxinn.entity.Payment;
import org.hxinn.server.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
//    private final static String PAYMENT_SERVER = "http://PAYMENTSERVER/";

//    @Resource
//    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("create")
    public BaseResult<Payment> createPayment(@RequestBody Payment payment){
//        return restTemplate.postForObject(PAYMENT_SERVER + "payment/create", payment, BaseResult.class);
        return paymentService.createPayment(payment);
    }

    @RequestMapping("log")
    public BaseResult<Payment> getPaymentById(Long id){
//       return restTemplate.getForObject(PAYMENT_SERVER + "payment/log/"+id, BaseResult.class);
        return paymentService.getPaymentById(id);
    }
}
