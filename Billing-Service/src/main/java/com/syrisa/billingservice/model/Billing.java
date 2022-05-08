package com.syrisa.billingservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Billing {
    private String billingDate;
    private String paymentDate;
    private int customerId;
    private Customer customer;

    public Billing(String billingDate, String paymentDate, int customerId) {
        this.billingDate = billingDate;
        this.paymentDate = paymentDate;
        this.customerId = customerId;
    }
}
