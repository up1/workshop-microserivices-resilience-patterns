package com.example.demo.resilience.retry;

import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Retry(name = "paymentService")
    @TimeLimiter(name = "paymentService")
    public CompletableFuture<String> pay() {
        return CompletableFuture.supplyAsync(this::callPaymentGateway);
    }

    private String callPaymentGateway() {
        // Call Payment API
        logger.info("Call slow payment gateway");
        Try.run(() -> Thread.sleep(5000));
        return "Pay success";
    }

}
