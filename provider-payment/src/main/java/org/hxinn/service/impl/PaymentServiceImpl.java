package org.hxinn.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import lombok.extern.slf4j.Slf4j;
import org.hxinn.entity.Payment;
import org.hxinn.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Payment createPayment(Payment payment) {
        int i = 10 / 0;
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

    @Override
    public String paymentInfoOK(Integer id) {
        return "Thread:" + Thread.currentThread().getName() + "pay id" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeOut(Integer id) {
        try {
            log.info("paymentInfoTimeOut.....");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Thread:" + Thread.currentThread().getName() + "pay time out id" + id;
    }

    public String paymentInfoTimeOutHandler(Integer id) {
        log.info("return timeout");
        return "Thread:" + Thread.currentThread().getName() + "pay time out id " + id + "😭";
    }

    @Override
    @HystrixCommand(fallbackMethod = "circuitBreakerHandler", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED,value = "true"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value = "10"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value = "60"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value = "10000"),
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id can not less than 0");
        }
        return UUID.randomUUID().toString();
    }


    public String circuitBreakerHandler(Integer id){
        return "please try a later" + id;
    }

}
