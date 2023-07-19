package com.Financially.FinancialApplication.service.Impl;

import com.Financially.FinancialApplication.exceptions.AccountNotFoundException;
import com.Financially.FinancialApplication.model.Accounts;
import com.Financially.FinancialApplication.repository.AccountRepository;
import com.Financially.FinancialApplication.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public String createAccount(Accounts account) {
        accountRepository.save(account);
        return "Success";
    }

    @Override
    public String updateAccount(Accounts account) {
        accountRepository.save(account);
        return "Update Success";
    }

    @Override
    public Accounts getAccountDetail(int Id) {
        if(accountRepository.findById(Id).isEmpty()){
            throw new AccountNotFoundException("Account Not Exist");
        }
        return accountRepository.findById(Id).get();
    }

    @Override
    public List<Accounts> getAllAccounts() {
        return accountRepository.findAll();
    }

//    @Override
//    public int checkBalance(int acctID) {
//        return accountRepository.checkBalance(acctID);
//    }

    @Override
    public void depositAmount(int acctID, int balance) {
        accountRepository.saveBalanceByAcctID(acctID, balance);
    }

    @Override
    public void withDrawAmount(int Id, int balance) {
        accountRepository.withDrawAmountByAcctID(Id, balance);
    }

    @Override
    public void fundsTransfer(int acctID, int destAcctID, int balance) {
        accountRepository.withDrawAmountByAcctID(acctID,balance);
        accountRepository.saveBalanceByAcctID(destAcctID,balance);
    }
}
