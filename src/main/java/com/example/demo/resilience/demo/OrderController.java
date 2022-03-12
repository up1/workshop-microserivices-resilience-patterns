package com.example.demo.resilience.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/order/checkout")
    public String checkout() throws InterruptedException {
        logger.info("Call checkout process");
        // Checkout process
        // Call payment gateway
        return paymentService.pay();
    }

}
