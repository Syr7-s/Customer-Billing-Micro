package com.syrisa.billingservice.service.impl;

import com.syrisa.billingservice.model.Billing;
import com.syrisa.billingservice.model.Customer;
import com.syrisa.billingservice.service.BillingService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class BillingServiceImpl implements BillingService<Billing> {
    List<Billing> billings = null;

    @Override
    @PostConstruct
    public void initBills() {
        billings = new ArrayList<>();
        billings.add(new Billing("2021/05/18","2021/05/28",0));
        billings.add(new Billing("2021/05/08","2021/06/28",1));
        billings.add(new Billing("2021/05/06","2021/07/28",2));
        billings.add(new Billing("2021/05/28","2021/08/28",3));
    }

    @Override
    public List<Billing> createBilling() {
        String customerServiceUrl = "http://localhost:8090/api/v1/customer/customer/";
        RestTemplate restTemplate = new RestTemplate();

        billings.forEach(billing -> {
            Customer customer = restTemplate.getForObject(customerServiceUrl+billing.getCustomerId(),Customer.class);
            billing.setCustomer(customer);
        });
        return billings;
    }
}
