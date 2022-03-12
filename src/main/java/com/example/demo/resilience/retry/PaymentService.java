package com.example.demo.resilience.retry;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Retry(name = "paymentService")
    public String pay() {
        return callPaymentGateway();
    }

    private String callPaymentGateway() {
        // Call Payment API
        logger.info("Call slow payment gateway");
        throw new PaymentException();
    }


}
