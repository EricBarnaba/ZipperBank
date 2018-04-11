package io.zipcoder.controller;

import io.zipcoder.domain.Deposit;
import io.zipcoder.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepositController {

    private DepositService depositService;

    @Autowired
    DepositController(DepositService depositService){
        this.depositService = depositService;
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity getDepositById(@PathVariable long depositId){
        return new ResponseEntity(this.depositService.getDepositById(depositId), HttpStatus.OK);
    }

    @RequestMapping(value = "/deposits/{depositid}", method = RequestMethod.PUT)
    public ResponseEntity updateDeposit(@PathVariable long depositId, @RequestBody Deposit depositToUpdate){
        boolean wasUpdated = this.depositService.updateDeposit(depositToUpdate);
        if (wasUpdated) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDepositById(@PathVariable long depositId){
        this.depositService.deleteDepositById(depositId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
