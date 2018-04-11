package io.zipcoder.service;

import io.zipcoder.domain.Deposit;
import io.zipcoder.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

    private DepositRepository depositRepository;

    @Autowired
    DepositService(DepositRepository depositRepository){
        this.depositRepository = depositRepository;
    }

    public Deposit getDepositById(Long depositId){
        return this.depositRepository.findOne(depositId);
    }

    public boolean updateBill(Deposit newBill){
        if(this.depositRepository.findOne(newBill.getId()) != null) {
            this.depositRepository.save(newBill);
            return true;
        }else {
            return false;
        }
    }

    public void deleteBillById(Long id){
        this.depositRepository.delete(id);
    }
}
