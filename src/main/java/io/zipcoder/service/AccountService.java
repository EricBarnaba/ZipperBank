package io.zipcoder.service;

import io.zipcoder.domain.Account;
import io.zipcoder.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository repo;


    public List<Account> getAllAccounts(){
        List<Account> accounts = new ArrayList<>();
        for(Account a : repo.findAll()) {
            accounts.add(a);
        }
       return accounts;
    }

    public Account getAccountById(Long id){
        return repo.findOne(id);
    }

    public boolean updateAccount(Long id, Account account){
        if(repo.exists(id)){
            repo.save(account);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removeAccount(Long id){
        if(repo.exists(id)){
            repo.delete(id);
            return true;
        }
        else{
            return false;
        }
    }

}
