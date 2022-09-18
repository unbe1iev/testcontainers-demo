package com.unbe1iev.testcontainersdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomepageController {

    private static final Logger logger = LoggerFactory.getLogger(HomepageController.class);

    private final CustomerDao customerDao;

    public HomepageController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @GetMapping("/")
    public List<Customer> getCustomers() {
        List<Customer> customers = customerDao.findAll();
        customers.forEach(c -> logger.info("Found a customer: {}", c));

        return customers;
    }
}
