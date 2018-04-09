package io.zipcoder.service;

import io.zipcoder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {

    @Autowired
    CustomerRepository repo;
}
