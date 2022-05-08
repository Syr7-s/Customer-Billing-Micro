package com.syrisa.billingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public Customer() {this.id = count.getAndIncrement();}
}
