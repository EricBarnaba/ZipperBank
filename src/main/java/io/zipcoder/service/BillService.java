package io.zipcoder.service;

import io.zipcoder.domain.Bill;
import io.zipcoder.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    private BillRepository billRepository;

    @Autowired
    BillService(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    public Bill getBillById(Long id){
        return this.billRepository.findOne(id);
    }

    public boolean updateBill(Bill newBill){
        if(this.billRepository.findOne(newBill.getId()) != null) {
            this.billRepository.save(newBill);
            return true;
        }else {
            return false;
        }
    }

    public void deleteBillById(Long id){
        this.billRepository.delete(id);
    }
}
