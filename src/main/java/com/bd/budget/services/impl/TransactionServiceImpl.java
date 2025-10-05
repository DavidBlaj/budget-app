package com.bd.budget.services.impl;

import com.bd.budget.dtos.TransactionUpdateDto;
import com.bd.budget.exceptions.ResourceNotFoundException;
import com.bd.budget.models.CustomCategory;
import com.bd.budget.models.StandardCategory;
import com.bd.budget.models.Transaction;
import com.bd.budget.repositories.TransactionRepository;
import com.bd.budget.services.CustomCategoryService;
import com.bd.budget.services.StandardCategoryService;
import com.bd.budget.services.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final CustomCategoryService customCategoryService;
    private final StandardCategoryService standardCategoryService;

    public TransactionServiceImpl(TransactionRepository transactionRepository, CustomCategoryService customCategoryService, StandardCategoryService standardCategoryService) {
        this.transactionRepository = transactionRepository;
        this.customCategoryService = customCategoryService;
        this.standardCategoryService = standardCategoryService;
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
    public Transaction updateTransaction(Long id, TransactionUpdateDto dto) {
        Transaction transaction = findTransactionById(id);

        boolean customCategoryExists = dto.getCustomCategoryId() != null;
        boolean standardCategoryExists = dto.getStandardCategoryId() != null;

        if (dto.getAmount() != null) transaction.setAmount(dto.getAmount());
        if (dto.getDescription() != null) transaction.setDescription(dto.getDescription());

        if (dto.getDate() != null) {
            LocalDate today = LocalDate.now();
            LocalDate pastDateLimit = today.minusMonths(6);
            if (dto.getDate().isAfter(today)) {
                throw new IllegalArgumentException("Transaction date cannot be in the future.");
            }
            if (dto.getDate().isBefore(pastDateLimit)) {
                throw new IllegalArgumentException("Transaction date cannot be older than 6 months.");
            }

            transaction.setDate(dto.getDate());
        }

        if (customCategoryExists && standardCategoryExists) {
            throw new IllegalArgumentException("Cannot update both standard and custom categories at the same time");
        }

        if (customCategoryExists) {
            CustomCategory customCategory = customCategoryService.findCustomCategoryById(dto.getCustomCategoryId());
            transaction.setCustomCategory(customCategory);
            transaction.setStandardCategory(customCategory.getStandardCategory());

        } else if (standardCategoryExists) {
            StandardCategory standardCategory = standardCategoryService.findStandardCategoryById(dto.getStandardCategoryId());
            transaction.setStandardCategory(standardCategory);
            transaction.setCustomCategory(null);

        }

        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}