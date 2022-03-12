package com.example.demo.resilience.demo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackMethod")
    public String pay() {
        logger.info("Call payment service");
        // Throw error
        Try.run(() -> Thread.sleep(3000));
        throw new PaymentException();
    }

    public String fallbackMethod(Throwable t) {
        logger.info("Call fallbackMethod, cause - {}", t.toString());
        return "TODO Next...";
    }

}
