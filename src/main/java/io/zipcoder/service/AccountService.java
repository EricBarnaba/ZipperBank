package io.zipcoder.service;

import io.zipcoder.domain.*;
import io.zipcoder.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {


    private AccountRepository repo;
    private BillRepository billRepo;
    private DepositRepository depositRepo;
    private WithdrawalRepository withdrawalRepo;
    private CustomerRepository customerRepo;

    @Autowired
    public AccountService(BillRepository billRepo, AccountRepository repo, DepositRepository depositRepo, WithdrawalRepository withdrawalRepo, CustomerRepository customerRepo){
        this.billRepo=billRepo;
        this.repo = repo;
        this.depositRepo= depositRepo;
        this.withdrawalRepo=withdrawalRepo;
        this.customerRepo = customerRepo;
    }


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

    public Customer getAccountCustomer(Long id) {
        Account account = repo.findOne(id);

        return customerRepo.findOne(account.getCustomer());
    }

    public List<Bill> getAccountBills(Long id) {
        List<Bill> bills = new ArrayList<>();
        for(Bill b : billRepo.findAllByAccount_id(id)) {
            bills.add(b);
        }
        return bills;
    }

    public void createBill(Bill bill) {
        billRepo.save(bill);
    }

    public List<Deposit> getAccountDeposits(Long id) {
        List<Deposit> deposits = new ArrayList<>();
        for(Deposit d : depositRepo.findAllByPayee_id(id)) {
            deposits.add(d);
        }
        return deposits;
    }

    public void createDeposit(Deposit deposit) {
        depositRepo.save(deposit);
    }

    public List<Withdrawal> getAccountWithdrawals(Long id) {
        List<Withdrawal> withdrawals = new ArrayList<>();
        for(Withdrawal w : withdrawalRepo.findAllByPayee_id(id)) {
            withdrawals.add(w);
        }
        return withdrawals;
    }

    public void createWithdrawal(Withdrawal withdrawal) {
        withdrawalRepo.save(withdrawal);
    }

}
