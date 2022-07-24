package com.syrisa.customerservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CustomerService<T> {

   // void createCustomer();

    T create(T create);

    T update(T update, Long id) throws Exception;

   // List<T> getAllCustomer();

    Page<T> getAllCustomer(Pageable pageable);

    T getByCustomer(Long id);

    String delete(Long id) throws Exception;
}
