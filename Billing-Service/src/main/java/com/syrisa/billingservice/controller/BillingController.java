package com.syrisa.billingservice.controller;

import com.syrisa.billingservice.model.Billing;
import com.syrisa.billingservice.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/billing")
@RequiredArgsConstructor
public class BillingController {

    public final BillingService<Billing> billingService;

    @GetMapping
    public String bill(){
        return "Hi,Bill Service is running.";
    }

    @GetMapping("/getBilling")
    public ResponseEntity<?> getBilling(){
        return new ResponseEntity<>(billingService.createBilling(), HttpStatus.OK);
    }
}
