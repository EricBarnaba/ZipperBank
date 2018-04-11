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

    public boolean updateDeposit(Deposit newDeposit){
        if(this.depositRepository.findOne(newDeposit.getId()) != null) {
            this.depositRepository.save(newDeposit);
            return true;
        }else {
            return false;
        }
    }

    public void deleteDepositById(Long id){
        this.depositRepository.delete(id);
    }
}
