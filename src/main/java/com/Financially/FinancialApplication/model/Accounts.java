package com.Financially.FinancialApplication.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int acctID;
    private int balance;
    private String acctStatus;

    private String firstName;

    private String gender;
    private String dob;

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }





    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Accounts() {

    }

    public Accounts(int acctID, int balance, String acctStatus, String firstName, String lastName, String phoneNumber) {
        super();
        this.acctID = acctID;
        this.balance = balance;
        this.acctStatus = acctStatus;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
    }

    private String lastName;
    private String phoneNumber;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAcctID() {
        return acctID;
    }

    public void setAcctID(int acctID) {
        this.acctID = acctID;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
