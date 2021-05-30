package org.hxinn.server;


import org.hxinn.entity.BaseResult;
import org.hxinn.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("PAYMENTSERVER")
public interface PaymentService {

    @PostMapping("payment/create")
    BaseResult<Payment> createPayment(@RequestBody Payment payment);

    @GetMapping("payment/log/{id}")
    BaseResult<Payment> getPaymentById(@PathVariable Long id);

    @GetMapping("payment/ok/{id}")
    BaseResult<String> paymentSuccess(@PathVariable Integer id);

    @GetMapping("payment/time-out/{id}")
    BaseResult<String> paymentTimeOut(@PathVariable Integer id);
}
