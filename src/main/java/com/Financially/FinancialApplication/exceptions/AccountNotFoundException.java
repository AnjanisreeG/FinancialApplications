package com.Financially.FinancialApplication.exceptions;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(String message){
        super(message);
    }

    public AccountNotFoundException(String mesage, Throwable cause){
        super(mesage,cause);
    }
}
