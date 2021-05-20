package org.hxinn.service.impl;

import org.hxinn.entity.Payment;
import org.hxinn.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Payment createPayment(Payment payment) {
        payment.setId(System.currentTimeMillis());
        return payment;
    }

    @Override
    public Payment getPaymentById(long id) {
        Payment payment = new Payment();
        payment.setId(id);
        payment.setPrice("￥8499");
        payment.setSerial("2021年5月18日16:52:48");
        return payment;
    }
}
