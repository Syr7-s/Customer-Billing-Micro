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

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Customer customer,@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(customerService.update(customer,id), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getCustomerByID(@PathVariable("id") int id){
        return new ResponseEntity<>(customerService.getByCustomer(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(customerService.delete(id), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
