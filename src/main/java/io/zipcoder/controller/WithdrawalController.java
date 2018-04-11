package io.zipcoder.controller;

import io.zipcoder.domain.Withdrawal;
import io.zipcoder.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class WithdrawalController {

    private WithdrawalService withdrawalService;

    @Autowired
    WithdrawalController(WithdrawalService withdrawalService){
        this.withdrawalService = withdrawalService;
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.GET)
    public ResponseEntity getWithdrawalById(@PathVariable long withdrawalId){
        return new ResponseEntity(this.withdrawalService.getWithdrawalById(withdrawalId), HttpStatus.OK);
    }

    @RequestMapping(value = "/withdrawals/{withdrawalid}", method = RequestMethod.PUT)
    public ResponseEntity updateWithdrawal(@PathVariable long withdrawalId, @RequestBody Withdrawal withdrawalToUpdate){
        boolean wasUpdated = this.withdrawalService.updateWithdrawal(withdrawalToUpdate);
        if (wasUpdated) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteWithdrawalById(@PathVariable long withdrawalId){
        this.withdrawalService.deleteWithdrawalById(withdrawalId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
