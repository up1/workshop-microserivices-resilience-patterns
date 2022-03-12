package com.example.demo.resilience.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/order/checkout")
    public String checkout() {
        // Checkout process
        // Call payment gateway
        return paymentService.pay();
    }

}
