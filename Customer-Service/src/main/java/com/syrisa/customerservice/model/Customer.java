package com.syrisa.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
/*
@Getter
@Setter
@AllArgsConstructor
public class Customer {
    public static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public Customer(){
        this.id = count.getAndIncrement();
    }
}
*/

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long customerId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;

}
