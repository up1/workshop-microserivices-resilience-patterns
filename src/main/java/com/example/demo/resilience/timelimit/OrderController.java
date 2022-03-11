package com.example.demo.resilience.timelimit;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;

@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/order/checkout")
    public CompletableFuture<String> checkout() {
        return paymentService.pay();
    }

}
