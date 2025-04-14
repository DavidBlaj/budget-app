package com.bd.budget.services.impl;

import com.bd.budget.dtos.ExpenseDto;
import com.bd.budget.exceptions.ResourceNotFoundException;
import com.bd.budget.models.Expense;
import com.bd.budget.repositories.ExpenseRepository;
import com.bd.budget.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<ExpenseDto> findAll() {
        List<Expense> expenses = expenseRepository.findAll();
        System.out.println(expenses);
        return expenses.stream().map((expense) -> mapToExpenseDto(expense)).collect(Collectors.toList());
    }

    @Override
    public Expense add(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense findById(Long expenseId) {
        return expenseRepository
                .findById(expenseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The expense with given id does not exist: " + expenseId));
    }

    private ExpenseDto mapToExpenseDto(Expense expense) {
        return ExpenseDto.builder()
                .id(expense.getId())
                .expenseCategory(expense.getCategory())
                .amount(expense.getAmount())
                .subCategory(expense.getSubCategory())
                .notes(expense.getNotes())
                .dateAdded(expense.getDateAdded())
                .build();
    }
}