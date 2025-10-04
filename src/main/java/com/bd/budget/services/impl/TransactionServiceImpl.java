package com.bd.budget.services.impl;

import com.bd.budget.exceptions.ResourceNotFoundException;
import com.bd.budget.models.Transaction;
import com.bd.budget.repositories.TransactionRepository;
import com.bd.budget.services.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public Transaction findTransactionById(Long id) {
        return transactionRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The transaction with the given id does not exist: " + id));
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        Transaction transaction = findTransactionById(id);

        transaction.setAmount(updatedTransaction.getAmount());
        transaction.setStandardCategory(updatedTransaction.getStandardCategory());
        transaction.setCustomCategory(updatedTransaction.getCustomCategory());
        transaction.setDescription(updatedTransaction.getDescription());

        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}