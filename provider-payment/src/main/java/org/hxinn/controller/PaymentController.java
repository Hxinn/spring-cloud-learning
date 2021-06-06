package org.hxinn.controller;

import org.hxinn.entity.BaseResult;
import org.hxinn.entity.Payment;
import org.hxinn.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;

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

    @GetMapping("ok/{id}")
    public BaseResult<String> paymentSuccess(@PathVariable Integer id){
        String msg = paymentService.paymentInfoOK(id);
        return new BaseResult<>(1,"success"+port,msg);
    }

    @GetMapping("time-out/{id}")
    public BaseResult<String> paymentTimeOut(@PathVariable Integer id){
        String msg = paymentService.paymentInfoTimeOut(id);
        return new BaseResult<>(1,"success"+port,msg);
    }

    @GetMapping("circuit/{id}")
    public BaseResult<String> paymentCircuit(@PathVariable Integer id){
        String msg = paymentService.paymentCircuitBreaker(id);
        return new BaseResult<>(1,"success"+port,msg);
    }

    @GetMapping("trace")
    public BaseResult<String> zipkinTrace(){
        return new BaseResult<>(1,"zipkinTrace span is payment");
    }



}
