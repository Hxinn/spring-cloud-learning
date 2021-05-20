package org.hxinn.service;

import org.hxinn.entity.Payment;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment getPaymentById(long id);
}
