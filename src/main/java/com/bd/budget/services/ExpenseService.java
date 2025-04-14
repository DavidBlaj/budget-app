package com.bd.budget.services;

import com.bd.budget.dtos.ExpenseDto;
import com.bd.budget.models.Expense;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDto> findAll();

    Expense add(Expense expense);

    Expense findById(Long expenseId);
}