package com.syrisa.customerservice.service.impl;

import com.syrisa.customerservice.model.Customer;
import com.syrisa.customerservice.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService<Customer> {
    private static final Map<Integer, Customer> customerRepo = new HashMap<>();
    private static final List<Customer> customers = new ArrayList<>();

    @Override
    @PostConstruct
    public void createCustomer() {
        customers.add(new Customer(Customer.count.getAndIncrement(), "John", "Carter", "+9012345678911", "john.ca@example.com"));
        customers.add(new Customer(Customer.count.getAndIncrement(), "Tom", "Clark", "+9012345678912", "clarl.tom@example.com"));
        customers.add(new Customer(Customer.count.getAndIncrement(), "Terry", "Johnson", "+9012345678913", "terry.john7@example.com"));
        customers.add(new Customer(Customer.count.getAndIncrement(), "Sarra", "Tancredi", "+9012345678914", "tanc.sarr05@example.com"));
        customers.forEach(this::create);
    }

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
            return id + " numbered Customer was deleted";
        }
        throw new Exception("Customer not found");
    }
}
