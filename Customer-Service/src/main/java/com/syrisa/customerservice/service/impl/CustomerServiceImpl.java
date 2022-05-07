package com.syrisa.customerservice.service.impl;

import com.syrisa.customerservice.model.Customer;
import com.syrisa.customerservice.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService<Customer> {
    private static final Map<Integer, Customer> customerRepo = new HashMap<>();


    @Override
    public Customer create(Customer customer) {
        if (!customerRepo.containsKey(customer.getId())) {
            customerRepo.put(customer.getId(), customer);
        }
        return customerRepo.get(customer.getId());
    }

    @Override
    public Customer update(Customer update, int id) throws Exception {
        if (update.getId() == id) {
            customerRepo.put(id, update);
            return customerRepo.get(id);
        }
        throw new Exception("Customer not found");
    }

    @Override
    public List<Customer> getAllCustomer() {
        return new ArrayList<>(customerRepo.values());
    }

    @Override
    public Customer getByCustomer(int id) {
        return customerRepo.get(id);
    }

    @Override
    public String delete(int id) throws Exception {
        if (customerRepo.containsKey(id)) {
            customerRepo.remove(id);
            return id+" numbered Customer was deleted";
        }
        throw new Exception("Customer not found");
    }
}
