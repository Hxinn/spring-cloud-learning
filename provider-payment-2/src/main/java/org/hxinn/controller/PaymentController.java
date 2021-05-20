package org.hxinn.controller;

import org.hxinn.entity.BaseResult;
import org.hxinn.entity.Payment;
import org.hxinn.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("create")
    public BaseResult<Payment> createPayment(@RequestBody Payment payment){
        Payment p = paymentService.createPayment(payment);
        return new BaseResult<>(1, "success:"+port, p);
    }

    @RequestMapping("log/{id}")
    public BaseResult<Payment> getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        return new BaseResult<>(1,"success:"+port, payment);
    }
}
