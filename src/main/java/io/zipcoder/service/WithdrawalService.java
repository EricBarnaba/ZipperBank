package io.zipcoder.service;

import io.zipcoder.domain.Withdrawal;
import io.zipcoder.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalService {

    private WithdrawalRepository withdrawalRepository;

    @Autowired
    WithdrawalService(WithdrawalRepository withdrawalRepository){
        this.withdrawalRepository = withdrawalRepository;
    }

    public Withdrawal getWithdrawalById(Long withdrawalId){
        return this.withdrawalRepository.findOne(withdrawalId);
    }

    public boolean updateWithdrawal(Withdrawal newWithdrawal){
        if(this.withdrawalRepository.findOne(newWithdrawal.getId()) != null) {
            this.withdrawalRepository.save(newWithdrawal);
            return true;
        }else {
            return false;
        }
    }

    public void deleteWithdrawalById(Long id){
        this.withdrawalRepository.delete(id);
    }
}
