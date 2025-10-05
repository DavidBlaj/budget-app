package com.bd.budget.services;

import com.bd.budget.dtos.TransactionUpdateDto;
import com.bd.budget.models.Transaction;

public interface TransactionService {

    Transaction findTransactionById(Long id);

    // TODO: Find all transactions for a User

    Transaction addTransaction(Transaction transaction);

    Transaction updateTransaction(Long id, TransactionUpdateDto dto);

    void deleteTransaction(Long id);

}