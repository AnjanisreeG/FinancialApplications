package com.Financially.FinancialApplication.service;

import com.Financially.FinancialApplication.model.Accounts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    public String createAccount(Accounts account);
    public String updateAccount(Accounts account);
    public Accounts getAccountDetail(int Id);
    public List<Accounts> getAllAccounts();

    //public int checkBalance(int acctID);
    public void depositAmount(int Id, int balance);

    public void withDrawAmount(int Id, int balance);

    public void fundsTransfer(int acctID,int destAcctID, int balance);
}
