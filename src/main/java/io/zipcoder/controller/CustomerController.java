package io.zipcoder.controller;

import com.sun.deploy.net.HttpResponse;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {


    CustomerService service;

    @Autowired
    public CustomerController(CustomerService service){
        this.service = service;
    }

    @RequestMapping(value = "/customers/{id}/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAcctsForCust(@PathVariable Long id) {

        return new ResponseEntity<>(service.getAllAccountsForCust(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@PathVariable Long id, @RequestBody Account account){
        service.createAccount(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomers(){
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSpecificCusomer(@PathVariable Long id){

        return new ResponseEntity<>(service.getCustomerById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createACustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        if(service.updateCustomer(id,customer)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/customer/{id}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBillsForCust(@PathVariable Long id){

        return new ResponseEntity<>(service.getAllBillsForCustomer(id), HttpStatus.OK);
    }
}
