package com.syrisa.billingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/billing")
public class BillingController {
    @GetMapping
    public String bill(){
        return "Hi,Bill Service is running.";
    }
}
