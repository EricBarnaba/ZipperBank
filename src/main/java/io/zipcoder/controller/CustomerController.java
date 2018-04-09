package io.zipcoder.controller;

import io.zipcoder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CustomerController {

    @Autowired
    CustomerService service;

    @RequestMapping(value = "/customer/{customer}/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAcctsForCust() {
        return null;
    }

    @RequestMapping(value = "/customer/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(){
        return null;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomers(){
        return null;
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSpecificCusomer(){
        return null;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createACustomer(){
        return null;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(){
        return null;
    }

    @RequestMapping(value = "/customer/{id}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBillsForCust(){
        return null;
    }
}
