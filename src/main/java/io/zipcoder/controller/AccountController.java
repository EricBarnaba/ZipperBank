package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.domain.Deposit;
import io.zipcoder.domain.Withdrawal;
import io.zipcoder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {


    AccountService service;

    @Autowired
    public AccountController(AccountService service){
        this.service = service;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccounts() {
        return new ResponseEntity<>(service.getAllAccounts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccount(@PathVariable Long id) {
        return new ResponseEntity<>(service.getAccountById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        if(service.updateAccount(id,account)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        if(service.removeAccount(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/accounts/{id}/customer", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(service.getAccountCustomer(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{id}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountBills(@PathVariable Long id) {
        return new ResponseEntity<>(service.getAccountBills(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{id}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> createBill(@PathVariable Long id, @RequestBody Bill bill) {
        service.createBill(bill);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/accounts/{id}/deposits", method = RequestMethod.GET)
    public ResponseEntity<?> getAllDeposits(@PathVariable Long id) {
        return new ResponseEntity<>(service.getAccountDeposits(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{id}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@PathVariable Long id, @RequestBody Deposit deposit) {
        service.createDeposit(deposit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/accounts/{id}/withdrawals", method = RequestMethod.GET)
    public ResponseEntity<?> getAllWithdrawals(@PathVariable Long id) {
        return new ResponseEntity<>(service.getAccountWithdrawals(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{id}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal(@PathVariable Long id, @RequestBody Withdrawal withdrawal) {
        service.createWithdrawal(withdrawal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }







}
