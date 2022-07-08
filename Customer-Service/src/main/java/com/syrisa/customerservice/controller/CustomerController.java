package com.syrisa.customerservice.controller;

import com.syrisa.customerservice.model.Customer;
import com.syrisa.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
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
