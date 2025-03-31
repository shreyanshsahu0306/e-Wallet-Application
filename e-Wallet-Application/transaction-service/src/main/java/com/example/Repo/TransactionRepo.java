package com.example.Repo;

import com.example.Model.Transaction;
import com.example.Model.TransactionStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

    @Transactional
    @Modifying
    @Query("update Transaction t set t.transactionStatus = ?2 where t.externalId = ?1")
    void updateTransaction(String externalTransactionId, TransactionStatus transactionStatus);
}
