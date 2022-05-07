package com.syrisa.customerservice.service;

import java.util.List;

public interface CustomerService<T> {
    T create(T create);

    T update(T update, int id) throws Exception;

    List<T> getAllCustomer();

    T getByCustomer(int id);

    String delete(int id) throws Exception;
}
