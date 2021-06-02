package org.hxinn.server;

import org.hxinn.entity.BaseResult;
import org.hxinn.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFallBackHandler implements PaymentService{

    @Override
    public BaseResult<Payment> createPayment(Payment payment) {
        return new BaseResult<Payment>(100,"createPayment fail please try a later (ToT)/~~~");
    }

    @Override
    public BaseResult<Payment> getPaymentById(Long id) {
        return new BaseResult<>(100,"PaymentById fail please try a later (ToT)/~~~");
    }

    @Override
    public BaseResult<String> paymentSuccess(Integer id) {
        return new BaseResult<>(100,"payment fail please try a later (ToT)/~~~");
    }

    @Override
    public BaseResult<String> paymentTimeOut(Integer id) {
        return new BaseResult<>(100,"payment timeout please try a later (ToT)/~~~");
    }
}
