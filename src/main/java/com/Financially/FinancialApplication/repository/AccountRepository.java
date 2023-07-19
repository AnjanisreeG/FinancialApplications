package com.Financially.FinancialApplication.repository;

import com.Financially.FinancialApplication.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer> {
//    @Query(value = "select balance from Accounts where acctID = ?1")
//    public int checkBalance(int acctID);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accounts set balance = balance+?2 where acctID=?1")
    public void saveBalanceByAcctID(int acctID, int balance);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accounts set balance = balance-?2 where acctID=?1")
    public void withDrawAmountByAcctID(int Id, int balance);



}
