package io.zipcoder.service;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Bill;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.BillRepository;
import io.zipcoder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {


    private CustomerRepository repo;
    private AccountRepository accountRepo;
    private BillRepository billRepo;
    private AccountService accountService;

    @Autowired
    public CustomerService(CustomerRepository repo, AccountRepository accountRepo, BillRepository billRepo, AccountService accountService) {
        this.repo = repo;
        this.accountRepo = accountRepo;
        this.billRepo = billRepo;
        this.accountService = accountService;
    }

    public List<Account> getAllAccountsForCust(Long id){
        List<Account> accounts = new ArrayList<>();
        for(Account a : accountRepo.findAllByCustomerId(id)) {
            accounts.add(a);
        }
        return accounts;
    }

    public void createAccount(Account account){
        accountRepo.save(account);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList();
        for(Customer c : repo.findAll()){
            customers.add(c);
        }
        return customers;
    }

    public Customer getCustomerById(Long id){
        return repo.findOne(id);
    }

    public void addCustomer (Customer customer) {
        repo.save(customer);
    }

    public boolean updateCustomer(Long id, Customer customer){
        if(repo.exists(id)){
            repo.save(customer);
            return true;
        }
        else{
            return false;
        }
    }

    public List<Bill> getAllBillsForCustomer(Long id){
        List<Bill> bills = new ArrayList<>();
        List<Account> accounts = this.getAllAccountsForCust(id);
        for(Account a : accounts){
            List<Bill> accountBills = accountService.getAccountBills(a.getId());
            for(Bill b : accountBills){
                bills.add(b);
            }
        }
        return bills;
    }

}
