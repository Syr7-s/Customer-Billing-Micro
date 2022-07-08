package com.syrisa.customerservice.service;

import java.util.List;

public interface CustomerService<T> {

   // void createCustomer();

    T create(T create);

    T update(T update, Long id) throws Exception;

    List<T> getAllCustomer();

    T getByCustomer(Long id);

    String delete(Long id) throws Exception;
}
