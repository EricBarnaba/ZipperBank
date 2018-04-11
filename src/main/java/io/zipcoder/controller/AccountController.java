package io.zipcoder.controller;

import io.zipcoder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService service;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccounts() {
        return null;
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccount(@PathVariable Long id) {
        return null;
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@PathVariable Long id) {
        return null;
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        return null;
    }

    @RequestMapping(value = "/accounts/{id}/customer", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountCustomer(@PathVariable Long id) {
        return null;
    }

    @RequestMapping(value = "/accounts/{id}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountBills(@PathVariable Long id) {
        return null;
    }

    @RequestMapping(value = "/accounts/{id}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> createBill(@PathVariable Long id) {
        return null;
    }

    @RequestMapping(value = "/accounts/{id}/deposits", method = RequestMethod.GET)
    public ResponseEntity<?> getAllDeposits(@PathVariable Long id) {
        return null;
    }

    @RequestMapping(value = "/accounts/{id}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@PathVariable Long id) {
        return null;
    }

    @RequestMapping(value = "/accounts/{id}/withdrawals", method = RequestMethod.GET)
    public ResponseEntity<?> getAllWithdrawals(@PathVariable Long id) {
        return null;
    }

    @RequestMapping(value = "/accounts/{id}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal(@PathVariable Long id) {
        return null;
    }







}
