package com.example.demo.resilience.demo;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/order/checkout")
    @RateLimiter(name = "paymentService")
    public String checkout() {
        logger.info("Call checkout process");
        // Checkout process
        // Call payment gateway
        Try.run(() -> Thread.sleep(1000));
        return "Pay success";
    }

}
