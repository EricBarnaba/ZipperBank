package io.zipcoder.controller;


import io.zipcoder.domain.Bill;
import io.zipcoder.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {

    private BillService billService;

    @Autowired
    BillController(BillService billService){
        this.billService = billService;
    }

    @RequestMapping(value = "/bills/{billid}", method = RequestMethod.GET)
    public ResponseEntity getBillById(@PathVariable Long billId){
        return new ResponseEntity(this.billService.getBillById(billId), HttpStatus.OK);
    }

    @RequestMapping(value = "/bills/(billid}", method = RequestMethod.PUT)
    public ResponseEntity updateBill(@PathVariable Long billId, @RequestBody Bill billToUpdate){
        boolean wasUpdated = this.billService.updateBill(billToUpdate);
        if (wasUpdated){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/bills/{billid}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBill(@PathVariable Long billId){
        this.billService.deleteBillById(billId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
