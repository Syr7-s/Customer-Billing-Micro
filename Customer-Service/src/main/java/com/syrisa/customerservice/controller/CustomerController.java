package com.syrisa.customerservice.controller;

import com.syrisa.customerservice.model.Customer;
import com.syrisa.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    public final CustomerService<Customer> customerService;

    @GetMapping
    public String message(){
        return "Hi";
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.create(customer), HttpStatus.OK);
    }

    @PutMapping("/update/{customerID}")
    public ResponseEntity<?> update(@RequestBody Customer customer,@PathVariable("customerID") Long customerID) {
        try {
            return new ResponseEntity<>(customerService.update(customer,customerID), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/all", params = {"page", "size"})
    public ResponseEntity<?> getAll(@Min(0) int page, @Min(1) int size){
        return new ResponseEntity<>(customerService.getAllCustomer(PageRequest.of(page, size))
                .stream()
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/customer/{customerID}")
    public ResponseEntity<?> getCustomerByID(@PathVariable("customerID") Long customerID){
        return new ResponseEntity<>(customerService.getByCustomer(customerID), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{customerID}")
    public ResponseEntity<?> delete(@PathVariable("customerID") Long customerID){
        try {
            return new ResponseEntity<>(customerService.delete(customerID), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
