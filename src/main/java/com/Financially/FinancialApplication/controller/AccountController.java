package com.Financially.FinancialApplication.controller;

import com.Financially.FinancialApplication.model.Accounts;
import com.Financially.FinancialApplication.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class AccountController {
    AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public Accounts getAccountDetails(@RequestParam("Id") Integer Id) {
        return accountService.getAccountDetail(Id);
    }

//    @RequestMapping(value = "/check", method = RequestMethod.GET)
//    @ResponseBody
//    public int checkBalance(@RequestParam("Id") Integer Id){
//        return accountService.checkBalance(Id);
//    }

    @GetMapping("/CheckAllAccount")
    public ResponseEntity<List<Accounts>> getAllAccountDetails(){
        return new ResponseEntity<List<Accounts>>(accountService.getAllAccounts(), HttpStatus.OK);
        //return accountService.getAllAccounts();
    }

    @PostMapping
    public String createAccount(@RequestBody Accounts account){
        accountService.createAccount(account);
        return "Account created";
    }

    @PutMapping("/update")
    public String UpdateAccount(@RequestBody Accounts account){
        accountService.updateAccount(account);
        return "Account Updated";
    }

    @RequestMapping(value = "/depositAmount", method = RequestMethod.PUT)
    @ResponseBody
    public String depositAmount(@RequestParam("Id") Integer Id,@RequestParam("balance") Integer balance){
        accountService.depositAmount(Id,balance);
        return "Deposited Successfully";
    }

    @RequestMapping(value = "/withDrawAmount", method = RequestMethod.PUT)
    @ResponseBody
    public String withDrawAmount(@RequestParam("Id") Integer Id,@RequestParam("balance") Integer balance){
        accountService.withDrawAmount(Id,balance);
        return "Withdraw Successfully";
    }

    @RequestMapping(value = "/fundsTransfer", method = RequestMethod.PUT)
    @ResponseBody
    public String fundsTransfer(@RequestParam("acctID") int acctID, @RequestParam("destAcctID") int destAcctID, @RequestParam("balance") int balance){
        accountService.fundsTransfer(acctID,destAcctID,balance);
        return "Successfully Transferred";
    }

}
