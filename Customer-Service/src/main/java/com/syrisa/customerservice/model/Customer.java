package com.syrisa.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private static final AtomicInteger count = new AtomicInteger(-1);
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
