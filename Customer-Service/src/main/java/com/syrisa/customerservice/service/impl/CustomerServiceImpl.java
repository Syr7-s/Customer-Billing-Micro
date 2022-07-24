package com.syrisa.customerservice.service.impl;

import com.syrisa.customerservice.model.Customer;
import com.syrisa.customerservice.repository.CustomerRepository;
import com.syrisa.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService<Customer> {
    private static final Map<Long, Customer> customerRepo = new HashMap<>();
    private static final List<Customer> customers = new ArrayList<>();

    private final CustomerRepository customerRepository;

    /*
        @Override
        @PostConstruct
        public void createCustomer() {
            customers.add(new Customer(Customer.count.getAndIncrement(), "John", "Carter", "+9012345678911", "john.ca@example.com"));
            customers.add(new Customer(Customer.count.getAndIncrement(), "Tom", "Clark", "+9012345678912", "clark.tom@example.com"));
            customers.add(new Customer(Customer.count.getAndIncrement(), "Terry", "Johnson", "+9012345678913", "terry.john7@example.com"));
            customers.add(new Customer(Customer.count.getAndIncrement(), "Sarra", "Tancredi", "+9012345678914", "tanc.sarr05@example.com"));
            customers.forEach(this::create);
        }
    */
    @Override
    public Customer create(Customer customer) {
       /* if (!customerRepo.containsKey(customer.getCustomerId())) {
            customerRepo.put(customer.getCustomerId(), customer);
        }
        return customerRepo.get(customer.getCustomerId());*/
        try {
            return customerRepository.save(customer);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public Customer update(Customer update, Long id) throws Exception {
    /*    if (update.getCustomerId() == id) {
            customerRepo.put(id, update);
            return customerRepo.get(id);
        }
        throw new Exception("Customer not found");*/
        try {
            if (getByCustomer(id) != null) {
                return customerRepository.save(update);
            }
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error an occurred.");
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public Page<Customer> getAllCustomer(Pageable pageable) {
        // return new ArrayList<>(customerRepo.values());
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getByCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " numbered was book not found."));
    }

    @Override
    public String delete(Long id) throws Exception {
        try {
            // customerRepo.remove(id);
            customerRepository.delete(getByCustomer(id));
            return id + " numbered Customer was deleted";
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }
}
