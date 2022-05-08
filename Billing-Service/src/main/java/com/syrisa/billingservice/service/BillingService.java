package com.syrisa.billingservice.service;

import com.syrisa.billingservice.model.Billing;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BillingService<T> {
    void initBills();
    List<T> createBilling();
}
